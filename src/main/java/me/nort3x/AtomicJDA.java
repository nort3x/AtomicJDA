package me.nort3x;


import me.nort3x.atomic.AtomicDI;

public class AtomicJDA {
    static {
        AtomicDI.addAsScannablePath(AtomicJDA.class);
    }
}
