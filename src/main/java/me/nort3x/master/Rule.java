package me.nort3x.master;

import me.nort3x.interfaces.TicBot;
import me.nort3x.atomic.annotation.AtomicMethod;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * each
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@AtomicMethod
public @interface Rule {
    Class<? extends TicBot>[] forBot();
}
