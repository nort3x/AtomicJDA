package me.nort3x.internal;

import me.nort3x.annotation.BotCommandPool;
import me.nort3x.annotation.Rule;
import me.nort3x.atomic.basic.AtomicModule;
import me.nort3x.atomic.core.container.Container;
import me.nort3x.atomic.core.internal.AtomicEnvironment;
import me.nort3x.atomic.logger.AtomicLogger;
import me.nort3x.atomic.logger.Priority;
import me.nort3x.atomic.wrappers.AtomicAnnotation;
import me.nort3x.atomic.wrappers.AtomicMethod;
import me.nort3x.atomic.wrappers.AtomicType;
import me.nort3x.interfaces.AtomicJDABot;
import me.nort3x.atomic.annotation.Atomic;

import java.lang.reflect.Modifier;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;


@Atomic
public class AtomicJDABotLoader extends AtomicModule {


    @Override
    public String getName() {
        return "AtomicJDA";
    }

    @Override
    public int getVersion() {
        return 1;
    }


    Set<AtomicType> list_of_bots, list_of_pools;
    Map<AtomicType, BasicListener> listeners = new ConcurrentHashMap<>();
    Map<AtomicType, AtomicJDABot> instancesOfBots = new ConcurrentHashMap<>();
    Map<AtomicType, Object> instancesOfPools = new ConcurrentHashMap<>();

    AtomicLogger logger = AtomicLogger.getInstance();
    static class TupleOfMethodAndRuleAnnotation {
        AtomicMethod am;
        Rule r;

        public TupleOfMethodAndRuleAnnotation(AtomicMethod am) {
            this.am = am;
        }
    }

    @Override
    public void onModuleLoaded(AtomicEnvironment rel,String...args) {

        list_of_bots = rel.getAllAtomicTypesDerivedFromAtomicType(AtomicType.of(AtomicJDABot.class)); // get all scanned bots (implementations)
        list_of_pools = rel.getAllAtomicTypesAnnotatedWith(AtomicAnnotation.of(BotCommandPool.class)); // get all command pools

        // parse pools and generate listeners

        list_of_pools.parallelStream()
                .forEach(pool -> {

                    Object poolInstance = instancesOfPools.computeIfAbsent(pool, x -> Container.makeContainerAround(x).getCentral()); // make pool instance

                    pool.getMethodSet()
                            .forEach(method -> {
                                AtomicEnvironment.getAnnotationIfExist(Rule.class, method.getCorrespondingMethod()) // get rules and do:
                                        .ifPresent(rule -> {
                                            logger.info("Rule: "+method.getCorrespondingMethod().getName()+" Discovered in CommandPool: "+pool.getCorrespondingType().getName(), Priority.VERBOSE, AtomicJDABotLoader.class);
                                            Arrays.stream((rule.forBot())) // for each bot
                                                    .forEach(target_bot -> {
                                                         boolean accepted= listeners.computeIfAbsent(AtomicType.of(target_bot), x -> new BasicListener()) // add to listeners
                                                                .addRule(method.getCorrespondingMethod(), poolInstance);
                                                         if(accepted)
                                                            logger.info("Rule: "+method.getCorrespondingMethod().getName()+" Registered for Bot: "+target_bot.getSimpleName(), Priority.VERBOSE, AtomicJDABotLoader.class);
                                                    });
                                        });
                            });
                });


    }

    @Override
    public void onModuleStart(AtomicEnvironment atomicEnvironment) {

        // instantiate bots
        list_of_bots.parallelStream()
                .filter(x -> !x.getCorrespondingType().isInterface())
                .filter(x -> !Modifier.isAbstract(x.getCorrespondingType().getModifiers()))
                .forEach(type -> {
                    AtomicJDABot bot = (AtomicJDABot) Container.makeContainerAround(type).getCentral();
                    instancesOfBots.put(type,bot );
                    logger.info("invoking [start] Bot: "+type.getCorrespondingType().getName()+" a.k.a "+bot.provideName(), Priority.VERBOSE, AtomicJDABotLoader.class);
                });

        listeners.forEach((botType, listener) -> {
            Optional.ofNullable(instancesOfBots.getOrDefault(botType, null))
                    .ifPresent(botInstance -> {
                        botInstance.provideJDA().addEventListener(listener);
                        logger.info("attaching Rules to Bot: "+botType.getCorrespondingType().getName()+" a.k.a "+botInstance.provideName(), Priority.VERBOSE, AtomicJDABotLoader.class);
                    });
        });
    }

    @Override
    public void onModuleStop(AtomicEnvironment atomicEnvironment) {
        instancesOfBots.values().forEach(bot -> {
            //bot.provideJDA().shutdownNow();
        });
    }
}
