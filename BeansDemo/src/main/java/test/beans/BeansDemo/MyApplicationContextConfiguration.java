package test.beans.BeansDemo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import test.beans.BeansDemo.Classes1.DualWieldingKnight;
import test.beans.BeansDemo.Classes2.Sword;
@AutoConfiguration
@ComponentScan
public class MyApplicationContextConfiguration {
    @Bean
    public Sword sword(){
        return new Sword();
    }
    @Bean
    public PersonFactoryPostProcessor PersonFactoryPostProcessor() {
        return new PersonFactoryPostProcessor();
    }
//    @Bean
//    public DualWieldingKnight dualWieldingKnight() {
//        return new DualWieldingKnight();
//    }

}
