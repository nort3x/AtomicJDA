package me.nort3x.master;

import me.nort3x.atomic.core.AtomicEnvironment;
import me.nort3x.atomic.wrappers.AtomicAnnotation;
import me.nort3x.atomic.wrappers.AtomicType;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Set;

public class AtomicEnvReleaser{
    AtomicEnvironment atomicEnvironment;
    Method m1,m2;
    public AtomicEnvReleaser(AtomicEnvironment atomicEnvironment){
        this.atomicEnvironment = atomicEnvironment;

        for (Method declaredMethod : atomicEnvironment.getClass().getDeclaredMethods()) {
            declaredMethod.setAccessible(true);
            if(declaredMethod.getName().equals("getAllAtomicTypesDerivedFromAtomicType"))
                m1 = declaredMethod;
            else if(declaredMethod.getName().equals("getAllAtomicTypesAnnotatedWith"))
                m2 = declaredMethod;
        }


    }

    Set<AtomicType> getAllAtomicTypesDerivedFromAtomicType(AtomicType atomicType){
        try {

            return (Set<AtomicType>) m1.invoke(atomicEnvironment,atomicType);
        } catch (IllegalAccessException | InvocationTargetException  e) {
            e.printStackTrace();
            return null;
        }
    }


    Set<AtomicType> getAllAtomicTypesAnnotatedWith(AtomicAnnotation atomicAnnotation){
        try {
            return (Set<AtomicType>) m2.invoke(atomicEnvironment,atomicAnnotation);
        } catch (IllegalAccessException | InvocationTargetException  e) {
            e.printStackTrace();
            return null;
        }
    }
}








