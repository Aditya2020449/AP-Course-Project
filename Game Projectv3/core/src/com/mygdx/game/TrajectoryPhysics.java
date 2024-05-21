package com.mygdx.game;

import com.badlogic.gdx.math.Vector2;

public class TrajectoryPhysics {
    public static final float gravity = 9.8f;
    public Vector2 initialVelocity = new Vector2();
    public Vector2 initialPosition = new Vector2();

    public float getXPositions(float time) {
        float x = initialPosition.x + initialVelocity.x * time;
        return x;
    }
    public float getYPositions(float time){
        float y = initialPosition.y + initialVelocity.y * time - 0.5f * gravity * time * time;
        return y;
    }
}

