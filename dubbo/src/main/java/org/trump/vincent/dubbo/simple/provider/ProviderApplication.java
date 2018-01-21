package org.trump.vincent.dubbo.simple.provider;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProviderApplication {

    ApplicationContext applicationContext;

    public void initialize(){
        ClassPathXmlApplicationContext context
                = new ClassPathXmlApplicationContext("./dubbo-provider-config.xml");
//                (new String[] {"http://10.20.160.198/wiki/display/dubbo/provider.xml"});
        applicationContext = context;
        context.start();
    }
}
