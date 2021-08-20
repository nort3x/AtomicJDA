package me.nort3x.internal;

import me.nort3x.atomic.logger.AtomicLogger;
import me.nort3x.atomic.logger.Priority;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class InvokableRule {
    Method m;
    Object instance;

    public InvokableRule(Method m, Object instance) {
        this.m = m;
        this.instance = instance;
    }

    void invoke(Object parameter) {
        try {
            m.invoke(instance, parameter);
        } catch (IllegalAccessException | InvocationTargetException e) {
            AtomicLogger.getInstance().warning(
                    "Cannot Invoke Rule: " + m.getDeclaringClass().getName() + "." + m.getName() + " Thrown Exception: " + AtomicLogger.exceptionToString(e)
                    , Priority.VERY_IMPORTANT, InvokableRule.class
            );
        }
    }
}
