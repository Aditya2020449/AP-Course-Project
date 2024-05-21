package com.mygdx.game;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;

public class Controls implements InputProcessor {
    public boolean w,a,s,d,up,down,left,right,esc,enter;
    @Override
    public boolean keyDown(int keycode) {
        boolean keyProcessed= false;
        if(keycode == Input.Keys.W){
            w = true;
            keyProcessed=true;}
        else if(keycode == Input.Keys.A){
            a = true;
            keyProcessed=true;}
        else if(keycode == Input.Keys.S){
            s = true;
            keyProcessed=true;}
        else if(keycode == Input.Keys.D){
            d = true;
            keyProcessed=true;}
        else if(keycode == Input.Keys.UP){
            up = true;
            keyProcessed=true;}
        else if(keycode == Input.Keys.DOWN){
            down = true;
            keyProcessed=true;}
        else if(keycode == Input.Keys.LEFT){
            left = true;
            keyProcessed=true;}
        else if(keycode == Input.Keys.RIGHT){
            right = true;
            keyProcessed=true;}
        else if(keycode == Input.Keys.ESCAPE){
            esc = true;
            keyProcessed=true;}
        else if(keycode == Input.Keys.ENTER){
            enter = true;
            keyProcessed=true;}
        return keyProcessed;
        }
    @Override
    public boolean keyUp(int keycode) {
        boolean keyProcessed= false;
        if(keycode == Input.Keys.W){
            w = false;
            keyProcessed=true;}
        else if(keycode == Input.Keys.A){
            a = false;
            keyProcessed=true;}
        else if(keycode == Input.Keys.S){
            s = false;
            keyProcessed=true;}
        else if(keycode == Input.Keys.D){
            d = false;
            keyProcessed=true;}
        else if(keycode == Input.Keys.UP){
            up = false;
            keyProcessed=true;}
        else if(keycode == Input.Keys.DOWN){
            down = false;
            keyProcessed=true;}
        else if(keycode == Input.Keys.LEFT){
            left = false;
            keyProcessed=true;}
        else if(keycode == Input.Keys.RIGHT){
            right = false;
            keyProcessed=true;}
        else if(keycode == Input.Keys.ESCAPE){
            esc = false;
            keyProcessed=true;}
        else if(keycode == Input.Keys.ENTER){
            enter = false;
            keyProcessed=true;}
        return keyProcessed;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
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
