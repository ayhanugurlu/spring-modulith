package com.au.example;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.modulith.core.ApplicationModules;
import org.springframework.modulith.docs.Documenter;

@SpringBootTest
class SpringModulithApplicationTests {

    @Test
    void contextLoads() {
        var modules = ApplicationModules.of(SpringModulithApplication.class);

        for(var module : modules){
            System.out.println("module: "+ module.getName()+ " -> "+ module.getBasePackage());
        }
        new Documenter(modules)
                .writeIndividualModulesAsPlantUml()
                .writeModulesAsPlantUml();
    }

}
