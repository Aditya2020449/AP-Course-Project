package com.mygdx.game.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Box2D;

import java.awt.*;

public class TankSelection extends State {
    private Texture tankSelection;
    Rectangle tank1Sherman;
    Rectangle tank1Tiger;
    Rectangle tank1Churchill;
    Box2D box2D;
    public TankSelection(GameStateManager gsm) {
        super(gsm);
        tankSelection = new Texture("TankSelectionPlayer1.png");
        tank1Sherman = new Rectangle(5,80,400,800);
        tank1Tiger = new Rectangle(660,80,400,800);
        tank1Churchill = new Rectangle(1300,80,400,800);
        box2D = new Box2D(gsm);
    }

    @Override
    public void handleInput() {
        if(Gdx.input.justTouched()) {
            if(tank1Sherman.contains(Gdx.input.getX(),1080-Gdx.input.getY())) {
                gsm.push(new TankSelectionPlayer2(gsm));
                box2D.createTank1("Sherman");
            }
            else if(tank1Tiger.contains(Gdx.input.getX(),1080-Gdx.input.getY())) {
                gsm.push(new TankSelectionPlayer2(gsm));
                box2D.createTank1("Tiger");
            }
            else if(tank1Churchill.contains(Gdx.input.getX(),1080-Gdx.input.getY())) {
                gsm.push(new TankSelectionPlayer2(gsm));
                box2D.createTank1("Churchill");
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

    @Override
    public void dispose() {

    }
}
