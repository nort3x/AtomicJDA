package me.nort3x.master;

import me.nort3x.atomic.basic.AtomicModule;
import me.nort3x.atomic.core.AtomicEnvironment;
import me.nort3x.atomic.core.container.Container;
import me.nort3x.atomic.logger.Priority;
import me.nort3x.atomic.wrappers.AtomicAnnotation;
import me.nort3x.atomic.wrappers.AtomicType;
import me.nort3x.interfaces.TicBot;
import me.nort3x.atomic.annotation.Atomic;
import me.nort3x.atomic.logger.AtomicLogger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;


@Atomic
public class BotLoader extends AtomicModule {


    @Override
    public String getName() {
        return "AtomicJDA";
    }

    @Override
    public int getVersion() {
        return 1;
    }

    @Override
    public void whenScannedFinished(AtomicEnvironment atomicEnvironment) {

        AtomicEnvReleaser rel = new AtomicEnvReleaser(atomicEnvironment);
        var list_of_bots = rel.getAllAtomicTypesDerivedFromAtomicType(AtomicType.of(TicBot.class));
        var list_of_pools = rel.getAllAtomicTypesAnnotatedWith(AtomicAnnotation.of(BotCommandPool.class));


        Map<Class<? extends TicBot>,TicBot> instancesOfBots = new ConcurrentHashMap<>();
        list_of_bots.parallelStream()
                .forEach(type ->{
                    instancesOfBots.put((Class<? extends TicBot>) type.getCorrespondingType(),(TicBot) Container.makeContainerAround(type).getCentral());
                });

        Map<TicBot, BasicListener> listeners = new HashMap<>();

        list_of_pools.stream() // this is all of your rules:
                .map(AtomicType::getMethodSet)
                .flatMap(Set::stream)
                .forEach(rule->{
                    Class<?>[] bots_class = rule.getCorrespondingMethod().getAnnotation(Rule.class).forBot();
                    for (Class<?> botsClass : bots_class) {
                        TicBot bot = instancesOfBots.getOrDefault(botsClass,null);
                        if(bot==null){
                            AtomicLogger.getInstance().warning("requested Bot DoesntExist: "+ botsClass.getName() +" at: " + rule.getCorrespondingMethod().getDeclaringClass().getName()+"."+rule.getCorrespondingMethod().getName(), Priority.VERY_IMPORTANT,BotLoader.class);
                            return;
                        }

                        // if bot exist
                        BasicListener bs = listeners.computeIfAbsent(bot,crap->new BasicListener());
                        bs.addRule(rule.getCorrespondingMethod(),Container.makeContainerAround(AtomicType.of(rule.getCorrespondingMethod().getDeclaringClass())).getCentral());
                    }
                });
        listeners.forEach((bot,lis)->bot.provideJDA().addEventListener(lis));

    }

    @Override
    public void whenModuleStarted(AtomicEnvironment atomicEnvironment) {

    }

    @Override
    public void whenModuleStopped(AtomicEnvironment atomicEnvironment) {

    }
}
