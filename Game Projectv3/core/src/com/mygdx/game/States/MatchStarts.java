package com.mygdx.game.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Box2D;

public class MatchStarts extends State {
    private Texture matchStarts;
    public MatchStarts(GameStateManager gsm) {
        super(gsm);
        matchStarts = new Texture("StartOfMatch.png");
    }

    @Override
    public void handleInput() {
        if(Gdx.input.justTouched()) {
            gsm.push(new Box2D(gsm));
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.begin();
        batch.draw(matchStarts, 0, 0, 1920, 1080);
        batch.end();
    }

    @Override
    public void dispose() {
        matchStarts.dispose();
    }
}
