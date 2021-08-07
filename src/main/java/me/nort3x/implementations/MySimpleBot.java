package me.nort3x.implementations;

import me.nort3x.interfaces.BasicBot;
import me.nort3x.atomic.annotation.Atomic;
import net.dv8tion.jda.api.JDABuilder;

@Atomic
public class MySimpleBot extends BasicBot {

    public MySimpleBot(){
        super("MyToken");
    }

    @Override
    public void configure(JDABuilder jdaBuilder) {

    }

    @Override
    public String provideName() {
        return "MySimpleBotName";
    }
}
