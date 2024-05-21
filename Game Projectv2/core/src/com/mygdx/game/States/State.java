package com.mygdx.game.States;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

public abstract class State {
    protected GameStateManager gsm;
    protected Vector3 touchPoint;
    protected OrthographicCamera camera;

    protected State(GameStateManager gsm) {
        this.gsm = gsm;
        camera = new OrthographicCamera();
        touchPoint = new Vector3();
    }

    protected abstract void handleInput();
    public abstract void update(float dt);
    public abstract void render(SpriteBatch sb);


}
