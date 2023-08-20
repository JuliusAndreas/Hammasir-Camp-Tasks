package test.beans.BeansDemo.Classes1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import test.beans.BeansDemo.Classes2.Sword;

public class DualWieldingKnight {
    private Sword sword1;
    private Sword sword2;
    @Autowired
//    @Qualifier(value = )
    public void setSword1(Sword sword1) {
        this.sword1 = sword1;
        this.sword1.setName("longsword");
    }

    @Autowired
    public void setSword2(Sword sword2) {
        this.sword2 = sword2;
        this.sword2.setName("curved sword");
    }
}
