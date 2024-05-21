package com.mygdx.game.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.MyGdxGame;
import jdk.tools.jmod.Main;

import java.awt.*;

public class Menu extends State {
    private Texture menu;

    public Menu(GameStateManager gsm) {
        super(gsm);
        menu = new Texture("LoadingMainPagev3.png");

    }

    @Override
    public void handleInput() {
        if(Gdx.input.justTouched()) {
            gsm.set(new MainMenu(gsm));
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.begin();
        batch.draw(menu, 0, 0, 1920, 1080);
        batch.end();
    }
}

