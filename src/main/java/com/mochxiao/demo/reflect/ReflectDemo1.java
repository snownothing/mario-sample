package com.mochxiao.demo.reflect;

import com.mochxiao.demo.jdbc.JDBCExample;
import org.junit.Test;

import java.lang.reflect.Method;

/**
 * Created by Moch on 3/20/16.
 */
public class ReflectDemo1 {

    private String name;
    private int age;

    @Test
    public void testGetMethod() {
        Method[] methods = JDBCExample.class.getMethods();

        for(Method method : methods){
            System.out.println("method: " + method.getName());
        }
    }
}
