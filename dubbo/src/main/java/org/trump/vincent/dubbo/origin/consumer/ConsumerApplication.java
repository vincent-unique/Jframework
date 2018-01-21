package org.trump.vincent.dubbo.origin.consumer;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import org.trump.vincent.dubbo.origin.OriginService;

import java.util.concurrent.ConcurrentHashMap;

public class ConsumerApplication {
    //享元模式，建立远程服务的引用池
    private static ConcurrentHashMap<String,Object> serviceCache = new ConcurrentHashMap<String, Object>(20);

    public OriginService remoteOriginService(){
        ApplicationConfig applicationConfig = new ApplicationConfig("dubbo-consumer");

        RegistryConfig registryConfig = new RegistryConfig("127.0.0.1:9090");
        registryConfig.setUsername("sa");
        registryConfig.setPassword("sa");

        //引用远程服务
        ReferenceConfig<OriginService> referenceConfig = new ReferenceConfig<OriginService>();
        referenceConfig.setApplication(applicationConfig);
        referenceConfig.setRegistry(registryConfig);
        referenceConfig.setInterface(OriginService.class);
        referenceConfig.setVersion("V0.0.1");

        OriginService originService = referenceConfig.get();
        serviceCache.put("originService",originService);
        return originService;
    }

    public void consumeOringinService(){
        OriginService originService = (OriginService) serviceCache.get("originService");
        if(originService==null){
            originService = remoteOriginService();
        }
        originService.handle("boom");

    }


}
