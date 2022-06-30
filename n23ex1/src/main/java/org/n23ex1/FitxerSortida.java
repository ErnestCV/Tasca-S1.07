package org.n23ex1;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface FitxerSortida {
    String path() default "C:\\Users\\formacio\\IdeaProjects\\Tasca-S1.07\\objecte1.json";
}
