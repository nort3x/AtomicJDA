package me.nort3x.master;

import me.nort3x.interfaces.TicBot;
import me.nort3x.atomic.annotation.Atomic;
import me.nort3x.atomic.basic.Policy;
import me.nort3x.atomic.bean.Provider;
import me.nort3x.atomic.logger.AtomicLogger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Atomic
public class BotLoader extends Policy {

    @Override
    public void accept(Provider provider) {
        var list_of_bots = provider.getAllAtomicInstancesDerivedFrom(TicBot.class);
        var list_of_pools = provider.getAllAtomicAnnotatedWith(BotCommandPool.class);


        Map<Class<? extends TicBot>,? extends TicBot> instancesOfBots = list_of_bots.stream()
                .collect(Collectors.toMap(TicBot::getClass, x->x));

        Map<TicBot, BasicListener> listeners = new HashMap<>();

        list_of_pools.stream() // this is all of your rules:
                .map(x->provider.getMethodsAnnotatedWith(x,Rule.class))
                .flatMap(List::stream)
                .forEach(rule->{
                    TicBot bot = instancesOfBots.getOrDefault(rule.getAnnotation(Rule.class).forBot(),null);
                    if(bot==null){
                        AtomicLogger.getInstance().warning("requested Bot DoesntExist: "+ rule.getAnnotation(Rule.class).forBot().getName() +" at: " + rule.getDeclaringClass().getName()+"."+rule.getName());
                        return;
                    }

                    // if bot exist
                    BasicListener bs = listeners.computeIfAbsent(bot,crap->new BasicListener());
                    provider.getFactoryOf(rule.getDeclaringClass()).generate().ifPresent(obj->{
                        bs.addRule(rule,obj);
                    });
                });
        listeners.forEach((bot,lis)->bot.provideJDA().addEventListener(lis));
    }
}
