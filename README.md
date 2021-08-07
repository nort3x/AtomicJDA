[![CodeFactor](https://www.codefactor.io/repository/github/nort3x/atomicdi/badge/master)](https://www.codefactor.io/repository/github/nort3x/atomicjda/overview/master)

# AtomicJDA

AtomicJDA is an IoC and Dependency-Injection approach to wonderful [JDA](https://github.com/DV8FromTheWorld/JDA) discord bot library for java, it makes develop and maintenance of cluster of Bots easier!

its also an example for [AtomicDI](https://github.com/nort3x/AtomicDI) library

## Usage
+ **define your Bots in multiple classes:**
```java
@Atomic
public class MySimleBot extends BasicBot {

    public MySimleBot(){
        super("MyToken"); // your token
    }

    @Override
    public void configure(JDABuilder jdaBuilder) {
       // any configurations before build
    }

    @Override
    public String provideName() {
        return "MySimpleBotName"; // name your bot
    }
}
```
+ **define your commands in any order:**

```java

@BotCommandPool
public class VerificationOnReaction {
    @Atom
    MySimleBot bot;

  @Rule(forBot = {MySimpleBot.class}) // and any others
    void verifyPressed(MessageReceivedEvent messageReceivedEvent){
        System.out.println(messageReceivedEvent.getMessage().getContentDisplay());
    }

    @Rule(forBot = MySimleBot.class)
    void onReactionAdded(MessageReactionAddEvent event){
        System.out.println(event.getReactionEmote().getEmoji());
    }

    @Exclude
    @Rule(forBot = MySimleBot.class)
    void onSlashCommandX(SlashCommandEvent event){
        //todo
    }
}

```

+ **hit the run button:**
```java

public class Main {
    public static void main(String[] args) {
        Runner.run(Main.class,args);
    }
}
```

## Pros and Cons
+ **pros**:
    + fully decoupled dependency management
    + easier approach for organizing multiple bots
    + easier approach for integration with everything else
+ **cons**:
    + utilizing pretty young library [AtomicDI](https://github.com/nort3x/AtomicDI) and might undergo some changes
    + only continued by community pull requests


## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.

## License
[MIT](https://choosealicense.com/licenses/mit/)
