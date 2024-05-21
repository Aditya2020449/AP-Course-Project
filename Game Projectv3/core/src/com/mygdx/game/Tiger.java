package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.physics.box2d.Body;

public class Tiger extends Tank{
    public Tiger(Body body) {
        super(body);
        Texture tankPic=(MyGdxGame.assetManager.getTexture(1));
    }
}
