package com.data.algo.inter;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class Person {
    private String name = "suthan";
    public void greet(){
        System.out.println("Welcome, "+name);
    }
}

public class ReflectionExample {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        Class<?> clazz = Class.forName("com.data.algo.inter.Person");
        Object obj = clazz.getDeclaredConstructor().newInstance();
        Class<?> clazz2 = Person.class;

        Field[] fields = clazz.getDeclaredFields();
        Field singleField = clazz.getDeclaredField("name");
        singleField.setAccessible(true);
        singleField.set(obj, "Raja");
        Method method = clazz.getDeclaredMethod("greet");
        method.invoke(obj);
        System.out.println(singleField.getName());

    }
}
