package example1.implementations;

import me.nort3x.interfaces.AbstractAtomicBot;
import me.nort3x.atomic.annotation.Atomic;
import net.dv8tion.jda.api.JDABuilder;

@Atomic
public class MySimpleBot extends AbstractAtomicBot {

    public MySimpleBot(){
        super("token"); // its exposed and burnt away
    }

    @Override
    public void configure(JDABuilder jdaBuilder) {

    }

    @Override
    public String provideName() {
        return "MySimpleBotName";
    }
}
