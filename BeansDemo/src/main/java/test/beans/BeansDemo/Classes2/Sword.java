package test.beans.BeansDemo.Classes2;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Qualifier(value = "swordnnnnn, swordTwo")
public class Sword implements FactoryBean<Object> {
    private String name;
    @Override
    public Class<Sword> getObjectType() {
        return Sword.class;
    }

    @Override
    public Object getObject() throws Exception {
        return new Sword();
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSingleton() {
        return true;
    }
}
