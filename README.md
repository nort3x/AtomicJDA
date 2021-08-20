[![CodeFactor](https://www.codefactor.io/repository/github/nort3x/atomicdi/badge/master)](https://www.codefactor.io/repository/github/nort3x/atomicjda/overview/master)
[![](https://jitpack.io/v/nort3x/AtomicJDA.svg)](https://jitpack.io/#nort3x/AtomicJDA)
# AtomicJDA

`AtomicJDA` is an IoC and Dependency-Injection wrapper around [JDA](https://github.com/DV8FromTheWorld/JDA) `JavaDiscordAPI` library,<br/>
you can develop bots and organize them more easily with `AtomicJDA` 

It's a simple use case for more general library [AtomicDI](https://github.com/nort3x/AtomicDI) dedicated for developing IoC based modularized systems


if you want to use it directly and don't want to follow all of this jargon use [example1](https://github.com/nort3x/AtomicJDA/tree/master/src/test/java/example1) as your project base  

## Installation

### gradle
Add it in your root build.gradle at the end of repositories: (if not already!)

```gradle
allprojects {
    repositories {
        maven { url 'https://jitpack.io' }
    }
}

```
Step 2. Add the dependency
```gradle
dependencies {
    implementation 'com.github.nort3x:AtomicJDA:1.0.1'
}
```

### maven
Step 1. Add the JitPack repository to your build file (if not already!)

```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
```
Step 2. Add the dependency
```xml
<dependency>
    <groupId>com.github.nort3x</groupId>
    <artifactId>AtomicJDA</artifactId>
    <version>1.0.1</version>
</dependency>
```



## Usage
+ **Define Bots**
```java
// a simple one
@Atomic
public class MySimpleBot extends BasicBot {

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


// a lazy load custom provided one
@Atomic
public class MyLazyLoadCustomBot implements AtomicJDABot {

  // if instantiation of your bot depends on another bot, or any other Atomic component feel free
  @Atom
  MySimpleBot otherBot;

  // you can even load variables on runtime with AtomicDI
  // it should be AtomicDI.ini file
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

```
+ **define your commands in any order and and anywhere:**

```java

@BotCommandPool
public class VerificationOnReaction {
    
    @Atom
    MySimleBot bot; // if you need 

    @Rule(forBot = {MySimpleBot.class, MyLazyLoadCustomBot.class}) // and any other bot!
    void verifyPressed(MessageReceivedEvent messageReceivedEvent){
        System.out.println(messageReceivedEvent.getMessage().getContentDisplay());
    }

    @Rule(forBot = MySimpleBot.class)
    void onReactionAdded(MessageReactionAddEvent event){
        System.out.println(event.getReactionEmote().getEmoji());
    }

    @Exclude
    @Rule(forBot = MySimpleBot.class)
    void onSlashCommandX(SlashCommandEvent event){
        //todo
    }
}

```

+ **hit the run button:**
```java
public class Main {
  static {
    AtomicJDA atomicJDA = new AtomicJDA(); // forces jvm to add them to AtomicDI
  }
  
  public static void main(String[] args) {
    AtomicLogger.setVerbosityLevel(Priority.DEBUG);
    AtomicDI.run(Main.class,args);
  }
  
}

```

## Pros and Cons
+ **pros**:
    + fully decoupled dependency management
    + organize rules (events) based on their semantics
    + use same rule on multiple bots
    + easier approach for connecting multiple bots and monitor everything
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
