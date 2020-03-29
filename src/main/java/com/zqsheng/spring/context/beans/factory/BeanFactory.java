package com.zqsheng.spring.context.beans.factory;

public interface BeanFactory {

    Object getBean(String name);

    <T> T  getBean(String name,Class<T> clazz);

    Object getBean(String name,Object... args);

    <T> T getBean(Class<T> clazz);

    boolean isSingleton(String name);

    boolean isPrototype(String name);
}
