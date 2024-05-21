package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.Body;

public class Missile extends Box2DSprite {
    Texture missilePic;
    float velocityX;
    float velocityY;
    float angle;
    float velocity;
    AssetManager assetManager = new AssetManager();


    public Missile(Body body, float angle, float velocity) {
        super(body);
        missilePic=(assetManager.getTexture(6));
        TextureRegion[] frames = TextureRegion.split(missilePic,65,28)[0];
        setAnimator(frames, 1/12f);
        this.velocity=velocity;
        this.angle=angle;

    }
    public void setVelocityX(float velocityX) {
        this.velocityX = velocityX;
    }
    public void setVelocityY(float velocityY) {
        this.velocityY = velocityY;
    }
    public void setBodyPic(Texture missilePic){
        TextureRegion[] frames = TextureRegion.split(missilePic,65,28)[0];
        setAnimator(frames, 1/12f);
    }
    public void update(float dt){
        missilePic=(assetManager.getTexture(6));
        TextureRegion[] frames = TextureRegion.split(missilePic,65,28)[0];
        setAnimator(frames, 1/12f);
        velocityY -= dt*10;
        body.applyForceToCenter(velocityX,velocityY,true);

    }
    public void setAngle(float angle){
        this.angle = angle;
    }
    public void setVelocity(float velocity){
        this.velocity = velocity;
    }
}
