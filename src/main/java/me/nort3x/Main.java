package me.nort3x;

import Module1.MainLoader;
import me.nort3x.atomic.core.AtomicDI;
import me.nort3x.master.Runner;

public class Main {
    public static void main(String[] args) {
//        Runner.run(Main.class,args);
        AtomicDI.getInstance().resolve(MainLoader.class);
    }
}
