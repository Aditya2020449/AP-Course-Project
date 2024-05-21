package com.mygdx.game.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.awt.*;

public class TankSelection extends State {
    private Texture tankSelection;
    Rectangle startGameB;
    public TankSelection(GameStateManager gsm) {
        super(gsm);
        tankSelection = new Texture("TankSelection.png");
        startGameB = new Rectangle(1300,100,487,100);
    }

    @Override
    public void handleInput() {
        if(Gdx.input.justTouched()) {
            if(startGameB.contains(Gdx.input.getX(),1080-Gdx.input.getY())) {
                gsm.set(new MatchStarts(gsm));
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
        batch.draw(tankSelection, 0, 0, 1920, 1080);
        batch.end();
    }
}
