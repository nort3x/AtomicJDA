package Module1;

import Module1.sina.SinaObject;
import me.nort3x.atomic.annotation.Atom;
import me.nort3x.atomic.annotation.Atomic;
import me.nort3x.atomic.basic.AtomicModule;
import me.nort3x.atomic.core.AtomicEnvironment;

@Atomic
public class MainLoader extends AtomicModule {


    @Atom
    SinaObject sinaObject;

    @Override
    public String getName() {
        return "Sina Module";
    }

    @Override
    public int getVersion() {
        return 1;
    }

    @Override
    public void whenScannedFinished(AtomicEnvironment atomicEnvironment) {
        sinaObject.sayHi();
    }

    @Override
    public void whenModuleStarted(AtomicEnvironment atomicEnvironment) {

    }

    @Override
    public void whenModuleStopped(AtomicEnvironment atomicEnvironment) {

    }
}
