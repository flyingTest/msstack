package com.grydtech.msstack.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Treats a class as a Framework Component in MSStack.
 * Classes annotated with {@link FrameworkComponent} supports runtime dependency injection
 * for declared fields with {@link InjectInstance} annotation.
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface FrameworkComponent {
}
