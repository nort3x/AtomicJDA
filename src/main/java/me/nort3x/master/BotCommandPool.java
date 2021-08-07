package me.nort3x.master;

import me.nort3x.atomic.annotation.Atomic;
import me.nort3x.atomic.annotation.Exclude;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


/** annotate classes containing {@link Rule}
*  with this annotation
*/
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Atomic
@Exclude
public @interface BotCommandPool {
}
