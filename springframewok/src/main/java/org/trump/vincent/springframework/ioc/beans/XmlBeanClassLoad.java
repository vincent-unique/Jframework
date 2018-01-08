package org.trump.vincent.springframework.ioc.beans;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.ResourceUtils;

import java.io.FileNotFoundException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class XmlBeanClassLoad {

    private BeanFactory beanFactory;

    private String beanDefinition = "./beans.xml";

    public XmlBeanClassLoad(){

    }
    public XmlBeanClassLoad(String benaDefinitionFile){
        this.beanDefinition = benaDefinitionFile;
    }

    public void initilizeBeans() {
        Resource beansResource = new ClassPathResource(beanDefinition, this.getClass().getClassLoader());
        XmlBeanFactory beanFactory = new XmlBeanFactory(beansResource);
        this.beanFactory = beanFactory;
    }

    public <T>T getBean(String name,Class<T> tClass){
        if(this.beanFactory==null){
            Lock lock = new ReentrantLock(false);
            if(this.beanFactory == null){
                initilizeBeans();
            }
            lock.unlock();
        }
        Object bean = this.beanFactory.getBean(name);

        return (T)bean;
    }
}
