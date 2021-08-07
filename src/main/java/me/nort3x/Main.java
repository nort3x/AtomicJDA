package me.nort3x;

import me.nort3x.atomic.bean.DependencyGrapher;

public class Main {
    public static void main(String[] args) {
        DependencyGrapher.getInstance().graphUsingThisEntryPoint(Main.class);
    }
}
