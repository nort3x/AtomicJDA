package me.nort3x.commands;

import me.nort3x.atomic.annotation.Exclude;
import me.nort3x.implementations.MySimpleBot;
import me.nort3x.master.BotCommandPool;
import me.nort3x.master.Rule;
import me.nort3x.atomic.annotation.Atom;
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;

@BotCommandPool
public class VerificationOnReaction {
    @Atom
    MySimpleBot bot;

    @Rule(forBot = MySimpleBot.class)
    void verifyPressed(MessageReceivedEvent messageReceivedEvent){
        System.out.println(messageReceivedEvent.getMessage().getContentDisplay());
    }

    @Rule(forBot = {MySimpleBot.class}) // and many others?
    void onReactionAdded(MessageReactionAddEvent event){
        System.out.println(event.getReactionEmote().getEmoji());
    }

    @Exclude
    @Rule(forBot = MySimpleBot.class)
    void onSlashCommandX(SlashCommandEvent event){
        //todo
    }
}
