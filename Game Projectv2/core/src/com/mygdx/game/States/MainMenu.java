package com.mygdx.game.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.MyGdxGame;

import java.awt.*;

public class MainMenu extends State {
    private Texture mainMenu;
    Rectangle newGameB;
    Rectangle resumeGameB;
    Rectangle exitGameB;
    public MainMenu(GameStateManager gsm) {
        super(gsm);
        mainMenu = new Texture("MainScreen.png");
        newGameB = new Rectangle(700, 440 , 500, 100);
        resumeGameB = new Rectangle(700,280,500,100);
        exitGameB = new Rectangle(700,130, 500, 100);
    }

    @Override
    public void handleInput() {
        if(Gdx.input.justTouched()) {
            if (resumeGameB.contains(Gdx.input.getX(), 1080 - Gdx.input.getY())) {
                gsm.set(new SavedGames(gsm));
            } else if (newGameB.contains(Gdx.input.getX(), 1080 - Gdx.input.getY())) {
                gsm.set(new SelectMode(gsm));
            } else if (exitGameB.contains(Gdx.input.getX(), 1080 - Gdx.input.getY())) {
                Gdx.app.exit();
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
        batch.draw(mainMenu, 0, 0, 1920, 1080);
        batch.end();
    }
}
