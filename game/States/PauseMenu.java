package com.mygdx.game.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.awt.*;

public class PauseMenu extends State {
    private Texture pauseMenu;
    Rectangle resumeGameB;
    Rectangle saveGameB;
    Rectangle exitGameB;
    public PauseMenu(GameStateManager gsm) {
        super(gsm);
        pauseMenu = new Texture("Pause Menu.png");
        resumeGameB = new Rectangle(700,440,500,100);
        saveGameB = new Rectangle(700,280,500,100);
        exitGameB = new Rectangle(700,130,500,100);
    }

    @Override
    public void handleInput() {
        if(Gdx.input.justTouched()) {
            if(resumeGameB.contains(Gdx.input.getX(),1080-Gdx.input.getY()))
                gsm.set(new MatchStarts(gsm));
            else if(saveGameB.contains(Gdx.input.getX(),1080-Gdx.input.getY()))
                gsm.set(new SavedGames(gsm));
            else if(exitGameB.contains(Gdx.input.getX(),1080-Gdx.input.getY()))
                Gdx.app.exit();
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.begin();
        batch.draw(pauseMenu, 0, 0, 1920, 1080);
        batch.end();
    }
}