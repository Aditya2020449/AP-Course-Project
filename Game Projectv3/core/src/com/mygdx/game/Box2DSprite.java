package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.Body;

public class Box2DSprite {
    public Animator animator;
    public Body body;
    public float width;
    public float height;
    public Box2DSprite(Body body){
        this.body = body;
        animator = new Animator();
    }
    public Body getBody() {
        return body;
    }
    public void setAnimator(TextureRegion[] frames, float delay){
        animator.setAnimation(delay, frames);
        height = frames[0].getRegionHeight();
        width = frames[0].getRegionWidth();

    }
    public float getWidth() {
        return width;
    }
    public float getHeight() {
        return height;
    }
    public void update(float dt ){
        animator.update(dt);
    }
    public void render(SpriteBatch batch){
        batch.begin();
        batch.draw(animator.getFrame(),body.getPosition().x-(width/2),body.getPosition().y-(height/2),width,height);
        batch.end();

    }

}
