package com.data.algo.inter;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface MaxLength {
    int value();
}


class PersonForThis {
    @MaxLength(10)
    String name = "king";
}

public class CustomAnnotation {
    public static void main(String[] args) throws IllegalAccessException {
        PersonForThis p = new PersonForThis();
        Class<?> clazz = p.getClass();
        for (Field f : clazz.getDeclaredFields()) {
            if (f.isAnnotationPresent(MaxLength.class)) {
                MaxLength ann = f.getAnnotation(MaxLength.class);
                f.setAccessible(true);
                String val = (String) f.get(p);
                System.out.println("Field: " + f.getName());
                System.out.println("Max allowed: " + ann.value());
                System.out.println("Actual length: " + val.length());
            }
        }
    }
}
