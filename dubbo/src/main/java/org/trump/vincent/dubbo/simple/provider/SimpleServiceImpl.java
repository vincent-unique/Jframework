package org.trump.vincent.dubbo.simple.provider;

import org.trump.vincent.dubbo.simple.SimpleService;

public class SimpleServiceImpl implements SimpleService {

    public String hello(String name) {
        return "Hello ,"+name;
    }
}
