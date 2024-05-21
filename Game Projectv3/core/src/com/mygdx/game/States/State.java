package com.mygdx.game.States;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.MyGdxGame;

public abstract class State {
    protected GameStateManager gsm;
    protected Vector3 touchPoint;
    protected MyGdxGame game;
    protected OrthographicCamera camera;
    protected SpriteBatch batch;

    protected State(GameStateManager gsm) {
        this.gsm = gsm;
        game = gsm.getGame();
        camera = game.getCamera();
        touchPoint = new Vector3();
        batch = game.getSpriteBatch();
    }

    protected abstract void handleInput();
    public abstract void update(float dt);
    public abstract void render(SpriteBatch sb);
    public abstract void dispose();


}
