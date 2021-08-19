package Module1.sina;

import Module1.CoffeeMachine;
import Module1.SmartCoffeeMachine;
import me.nort3x.atomic.annotation.Atom;
import me.nort3x.atomic.annotation.Atomic;
import me.nort3x.atomic.annotation.PostConstruction;
import me.nort3x.atomic.annotation.Predefined;

@Atomic
public class SinaObject {

    @Atom(concreteType = SmartCoffeeMachine.class)
    CoffeeMachine coffeeMachine;

    @Predefined("kilid1")
    EnumType enumType;

    @PostConstruction
    void cons(){
        System.out.println(coffeeMachine.getName());
        System.out.println(enumType.name());
    }

    public void sayHi(){
        System.out.println("hi!");
    }


    enum EnumType{
        SINA,
        HUMAN
    }


}
