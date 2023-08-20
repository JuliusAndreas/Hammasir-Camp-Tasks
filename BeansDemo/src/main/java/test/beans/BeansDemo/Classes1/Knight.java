package test.beans.BeansDemo.Classes1;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.stereotype.Component;
import test.beans.BeansDemo.Classes2.Sword;
@Component
@ConditionalOnMissingBean(Sword.class)
public class Knight {
    private String name;
    private Sword sword;

    public Knight(@Autowired Sword sword) {
        this.name = "Sir Knight";
        this.sword = sword;
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("Knight created");
    }
    @PreDestroy
    public void preDestroy() {
        System.out.println("Closed the knight bean");
    }
}
