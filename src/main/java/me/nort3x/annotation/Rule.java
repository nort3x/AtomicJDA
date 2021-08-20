package me.nort3x.annotation;

import me.nort3x.atomic.annotation.Interaction;
import me.nort3x.interfaces.AtomicJDABot;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * each
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Interaction
public @interface Rule {
    Class<? extends AtomicJDABot>[] forBot();
}
