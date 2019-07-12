package com.iaasimov.Yarn;

import com.iaasimov.Yarn.workflow.ConstructGraph;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import com.iaasimov.Yarn.workflow.GlobalConstantsNew;

/**
 * Created by USER on 11-07-2019.
 */
@SpringBootApplication
public class InitYarn {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(InitYarn.class, args);
        GlobalConstantsNew.getInstance().initGlobalConstants(ctx);
        ConstructGraph.constructDAG();

        System.out.println("********** Print the Bean Store");
        for(String beanName :ctx.getBeanDefinitionNames())
            System.out.println(beanName);


    }
}
