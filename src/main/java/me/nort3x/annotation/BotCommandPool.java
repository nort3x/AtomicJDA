package me.nort3x.annotation;

import me.nort3x.atomic.annotation.Atomic;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


/** annotate classes containing {@link Rule}
*  with this annotation
*/
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Atomic
public @interface BotCommandPool {
}
