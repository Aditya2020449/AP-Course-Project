package com.mygdx.game.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class SavedGames extends State {
    private Texture savedGame;
    public SavedGames(GameStateManager gsm) {
        super(gsm);
        savedGame = new Texture("SelectSavedGame.png");
    }

    @Override
    public void handleInput() {
        if(Gdx.input.justTouched()) {
            gsm.set(new MatchStarts(gsm));
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.begin();
        batch.draw(savedGame, 0, 0, 1920, 1080);
        batch.end();
    }

    @Override
    public void dispose() {

    }
}