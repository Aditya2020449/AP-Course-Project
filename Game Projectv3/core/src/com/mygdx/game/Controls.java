package com.mygdx.game;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;

public class Controls implements InputProcessor {
    @Override
    public boolean keyDown(int keycode) {
        if(keycode == Input.Keys.W){
            InputListener.setKey(InputListener.W,true);}
        else if(keycode == Input.Keys.A){
            InputListener.setKey(InputListener.A,true);}
        else if(keycode == Input.Keys.S){
            InputListener.setKey(InputListener.S,true);}
        else if(keycode == Input.Keys.D){
            InputListener.setKey(InputListener.D,true);}
        else if(keycode == Input.Keys.UP){
            InputListener.setKey(InputListener.UP,true);}
        else if(keycode == Input.Keys.DOWN){
            InputListener.setKey(InputListener.DOWN,true);}
        else if(keycode == Input.Keys.LEFT){
            InputListener.setKey(InputListener.LEFT,true);}
        else if(keycode == Input.Keys.RIGHT){
            InputListener.setKey(InputListener.RIGHT,true);}
        else if(keycode == Input.Keys.ESCAPE){
            InputListener.setKey(InputListener.ESC,true);}
        else if(keycode == Input.Keys.ENTER){
            InputListener.setKey(InputListener.ENTER,true);}
        else if(keycode == Input.Keys.K){
            InputListener.setKey(InputListener.K,true);}
        else if(keycode == Input.Keys.O){
            InputListener.setKey(InputListener.O,true);}
        else if(keycode == Input.Keys.SPACE){
            InputListener.setKey(InputListener.SPACE,true);}
        else if(keycode == Input.Keys.NUM_8){
            InputListener.setKey(InputListener.EIGHT,true);}
        else if(keycode == Input.Keys.NUM_2){
            InputListener.setKey(InputListener.TWO,true);}
        return true;
        }
    @Override
    public boolean keyUp(int keycode) {
        if(keycode == Input.Keys.W){
            InputListener.setKey(InputListener.W,false);}
        else if(keycode == Input.Keys.A){
            InputListener.setKey(InputListener.A,false);}
        else if(keycode == Input.Keys.S){
            InputListener.setKey(InputListener.S,false);}
        else if(keycode == Input.Keys.D){
            InputListener.setKey(InputListener.D,false);}
        else if(keycode == Input.Keys.UP){
            InputListener.setKey(InputListener.UP,false);}
        else if(keycode == Input.Keys.DOWN){
            InputListener.setKey(InputListener.DOWN,false);}
        else if(keycode == Input.Keys.LEFT){
            InputListener.setKey(InputListener.LEFT,false);}
        else if(keycode == Input.Keys.RIGHT){
            InputListener.setKey(InputListener.RIGHT,false);}
        else if(keycode == Input.Keys.ESCAPE){
            InputListener.setKey(InputListener.ESC,false);}
        else if(keycode == Input.Keys.ENTER){
            InputListener.setKey(InputListener.ENTER,false);}
        else if(keycode == Input.Keys.K){
        InputListener.setKey(InputListener.K,false);}
        else if(keycode == Input.Keys.O){
        InputListener.setKey(InputListener.O,false);}
        else if(keycode == Input.Keys.SPACE){
        InputListener.setKey(InputListener.SPACE,false);}
        else if(keycode == Input.Keys.NUM_8){
            InputListener.setKey(InputListener.EIGHT,false);}
        else if(keycode == Input.Keys.NUM_2){
            InputListener.setKey(InputListener.TWO,false);}
        return true;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return true;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {

        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {

        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }
}
