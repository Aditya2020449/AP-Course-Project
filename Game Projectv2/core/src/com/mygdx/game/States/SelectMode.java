package com.mygdx.game.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.awt.*;

public class SelectMode extends State {
    private Texture selectMode;
    Rectangle pvpB;
    Rectangle pvcB;
    public SelectMode(GameStateManager gsm) {
        super(gsm);
        selectMode = new Texture("ModeSelection.png");
        pvpB = new Rectangle(750, 320, 487, 118);
        pvcB = new Rectangle(750,100 , 487, 118);
    }

    @Override
    public void handleInput() {
        if(Gdx.input.justTouched()) {
            if(pvpB.contains(Gdx.input.getX(),1080-Gdx.input.getY())) {
                gsm.set(new TankSelection(gsm));
            }
            else if(pvcB.contains(Gdx.input.getX(),1080-Gdx.input.getY())) {
                gsm.set(new TankSelection(gsm));
            }
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.begin();
        batch.draw(selectMode, 0, 0, 1920, 1080);
        batch.end();
    }
}
