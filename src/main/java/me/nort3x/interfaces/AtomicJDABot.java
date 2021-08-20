package me.nort3x.interfaces;

import net.dv8tion.jda.api.JDA;

public interface AtomicJDABot {
    String provideName();
    JDA provideJDA();
}
