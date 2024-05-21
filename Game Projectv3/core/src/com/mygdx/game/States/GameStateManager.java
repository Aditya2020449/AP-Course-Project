package com.mygdx.game.States;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Box2D;
import com.mygdx.game.MyGdxGame;

import java.util.Stack;

public class GameStateManager {
    private MyGdxGame game;
    private Stack<State> states;
    public static final int PLAY = 6543461;
    public GameStateManager(MyGdxGame game) {
        states = new Stack<State>();
        this.game= game;
        pushState(PLAY);
    }
    public MyGdxGame getGame(){
        return game;
    }
    public void pushState(int state){
        states.push(getState(state));
    }

    public State getState(int state){
        if(state==PLAY) return new Box2D(this);
        return null;
    }
    public void push(State state) {
        states.push(state);
    }
    public void popState() {
        states.pop();
    }
    public void set(State state) {
        states.pop();
        states.push(state);
    }
    public void peek(float dt) {
        states.peek().update(dt);
    }
    public void render(SpriteBatch sb) {
        states.peek().render(sb);
    }



}
