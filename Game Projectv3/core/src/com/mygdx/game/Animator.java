package com.mygdx.game;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Animator implements ApplicationListener {
    private float time;
    private float delay;
    private int frame;
    private TextureRegion[] frames;

    public Animator(){}
    public Animator(TextureRegion[] frames){
        this(frames,1/12f);
    }
    public Animator(TextureRegion[] frames, float delay){
        setAnimation(delay,frames);
    }
    public void setAnimation (float delay,TextureRegion[] frames) {
        this.frames = frames;
        this.delay = delay;
        this.time = 0;
        this.frame = 0;
    }
    public TextureRegion getFrame(){
        return frames[frame];
    }
    public void update(float dt){
        time += dt;
        while(time >= delay){
            step();
        }
    }
    public void step(){
        time -= delay;
        frame++;
        if(frame >= frames.length){
            frame = 0;
        }
    }
    @Override
    public void create() {

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void render() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }
}
