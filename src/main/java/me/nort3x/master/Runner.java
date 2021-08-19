package me.nort3x.master;

import me.nort3x.atomic.core.AtomicDI;

public class Runner {
    public static void run(Class<?> entryPoint,String[] args){
        AtomicDI.getInstance().resolve(Runner.class);
    }
}
