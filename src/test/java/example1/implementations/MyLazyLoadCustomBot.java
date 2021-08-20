package example1.implementations;

import me.nort3x.atomic.annotation.Atom;
import me.nort3x.atomic.annotation.Atomic;
import me.nort3x.atomic.annotation.PostConstruction;
import me.nort3x.atomic.annotation.Predefined;
import me.nort3x.interfaces.AtomicJDABot;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

import javax.security.auth.login.LoginException;

@Atomic
public class MyLazyLoadCustomBot implements AtomicJDABot {

    // if instantiation of your bot depends on another bot, or any other Atomic component feel free
    @Atom
    MySimpleBot otherBot;

    // you can even load variables on runtime with AtomicDI
    @Predefined("lazyLoadToken")
    String token;

    JDA instance;

    @PostConstruction
    void construct() {
        try {
            instance = JDABuilder.createDefault(token).build();
        } catch (LoginException e) {
            e.printStackTrace();
        }
    }


    @Override
    public String provideName() {
        return otherBot.provideName();
    }

    @Override
    public JDA provideJDA() {

        return instance;
    }
}
