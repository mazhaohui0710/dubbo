package org.apache.dubbo.demo.consumer;

import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.demo.DemoService;

public class Test {
    public static void main(String[] args) {
        ApplicationConfig applicationConfig=new ApplicationConfig();
        applicationConfig.setName("test");
        RegistryConfig registryConfig=new RegistryConfig();
        registryConfig.setAddress("zookeeper://127.0.0.1:2181");

        //DemoService
        ReferenceConfig<DemoService> reference=new ReferenceConfig<DemoService>();
        reference.setApplication(applicationConfig);
        reference.setRegistry(registryConfig);
        reference.setInterface(DemoService.class);
        DemoService server =reference.get();
        for(int i=0;i<100;i++){
            System.out.println(server.sayHello("11"));
        }

    }
}
