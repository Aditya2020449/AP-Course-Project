package com.mygdx.game;

public class InputListener {
    public static boolean[] keys;
    public static boolean[] pkeys;
    public static final int totalKeys = 15;
    public static final int W = 0;
    public static final int A = 1;
    public static final int S = 2;
    public static final int D = 3;
    public static final int UP = 4;
    public static final int DOWN = 5;
    public static final int LEFT = 6;
    public static final int RIGHT = 7;
    public static final int ESC = 8;
    public static final int ENTER = 9;
    public static final int SPACE = 10;
    public static final int O=11;
    public static final int K=12;
    public static final int EIGHT =13;
    public static final int TWO =14;

    static {
        keys = new boolean[totalKeys];
        pkeys = new boolean[totalKeys];
    }
    public static void update(){
        for(int i = 0; i < totalKeys; i++){
            pkeys[i] = keys[i];
        }
    }
    public static void setKey(int i, boolean b){
        keys[i] = b;
    }
    public static boolean isPressed(int i){
        return keys[i] && !pkeys[i];
    }
    public static boolean isDown(int i){
        return keys[i];
    }

}
