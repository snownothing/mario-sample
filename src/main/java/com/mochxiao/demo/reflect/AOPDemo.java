package com.mochxiao.demo.reflect;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by Moch on 3/20/16.
 */
public class AOPDemo {

    @Test
    public void testAop() {
        Inter proxy = new InterProxy(new InterImpl()).getInterProxy();
        int result = proxy.add(10, 1);
        System.out.println("result: " + result);
    }
}

interface Inter {
    int add(int lhs, int rhs);
}

 class InterImpl implements Inter {
    @Override
    public int add(int lhs, int rhs) {
        return lhs + rhs;
    }
}

class InterProxy {
    private Inter object;
    public InterProxy(Inter object) {
        this.object = object;
    }

    public Inter getInterProxy() {
        return (Inter)Proxy.newProxyInstance(
                object.getClass().getClassLoader(),
                object.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("starting AOP....");
                        Object result = method.invoke(object, args);
                        System.out.println("ending AOP....");
                        return result;
                    }
                }
        );

    }
}