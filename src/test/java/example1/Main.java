package example1;

import me.nort3x.AtomicJDA;
import me.nort3x.atomic.AtomicDI;
import me.nort3x.atomic.logger.AtomicLogger;
import me.nort3x.atomic.logger.Priority;

public class Main {
    static {
        AtomicJDA atomicJDA = new AtomicJDA(); // make one to enforce jvm to do their static block and add them to classpath
        AtomicDI.addAsScannablePath(Main.class);
    }

    public static void main(String[] args) {
        AtomicLogger.setVerbosityLevel(Priority.DEBUG);
        AtomicDI.run(Main.class,args);
    }
}
