package com.mygdx.game;

public class Ground {
    public float groundMax;
    public float groundMin;
    int width;
    int height;
    int x;
    int y;
    int upperBound = 10;
    int vertices = 10;
    Float min;
    Float max;
    Float var;
    static int[] verticesArr = new int[10];
    public double getX() {
        for (int i = 0; i < 100; i++) {
            float x = i / 99 * 10;
            return getNoiseFunc(x);
        }
        return 0;
    }
    public void fillVerticesArr(int[] arr) {
        for (int i = 0; i < vertices; i++) {
            arr[i] = MyGdxGame.random.nextInt(upperBound);
        }
    }

    public static float lerp(int min, int max, Float var) {
        return min * (1 - var) + var * max;
    }

    public float getNoiseFunc(float x) {
        fillVerticesArr(verticesArr);
        int min = (int) x;
        if (min <= vertices - 1) {
            var = x - min;
        }
        return lerp(verticesArr[min], verticesArr[min + 1], var);
    }

}

