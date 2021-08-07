package me.nort3x.master;

import me.nort3x.atomic.bean.DependencyGrapher;
import me.nort3x.atomic.logger.AtomicLogger;

public class Runner {
    public static void run(Class<?> entryPoint,String[] args){
        // do something with args maybe or change some pre-configs here like outputstream for AtomicLogger
        AtomicLogger.setOutputStream(System.out);
        DependencyGrapher.getInstance().graphUsingThisEntryPoint(entryPoint);
    }
}
