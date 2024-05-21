package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.physics.box2d.Body;

public class Sherman extends Tank{
    public Sherman(Body body) {
        super(body);
        Texture tankPic=(MyGdxGame.assetManager.getTexture(0));
    }
}
