package org.trump.vincent.dubbo.origin.provider;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.ServiceConfig;
import org.trump.vincent.dubbo.origin.OriginService;

public class ProviderApplication {

    public void publish(){
        pubOriginService();

    }

    public void pubOriginService(){
        OriginService originService = new OriginServiceImpl();
        ApplicationConfig application = new ApplicationConfig();
        application.setName("dubbo-provider");

        //注册中心
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress("127.0.0.1:9090");
        registryConfig.setUsername("sa");
        registryConfig.setPassword("sa");

        //服务发布协议
        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setName("hessian");
        protocolConfig.setPort(1024);
        protocolConfig.setThreads(100);

        //封装服务发布配置
        ServiceConfig<OriginService> serviceConfig = new ServiceConfig<OriginService>();
        serviceConfig.setApplication(application);
        serviceConfig.setRegistry(registryConfig);
        serviceConfig.setProtocol(protocolConfig);
        serviceConfig.setInterface(OriginService.class);
        serviceConfig.setRef(originService);
        serviceConfig.setVersion("V0.0.1");

        //服务发布
        serviceConfig.export();
    }

    public static void main(String[] args) {
        new ProviderApplication().publish();
    }
}
