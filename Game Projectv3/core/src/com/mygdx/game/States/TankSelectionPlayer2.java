package com.mygdx.game.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Box2D;

import java.awt.*;

public class TankSelectionPlayer2 extends State{

    private Texture tankSelectionPlayer2;
    Rectangle tank2Sherman;
    Rectangle tank2Tiger;
    Rectangle tank2Churchill;
    Box2D box2D;
    public TankSelectionPlayer2(GameStateManager gsm) {
        super(gsm);
        tankSelectionPlayer2 = new Texture("TankSelectionPlayer2.png");
        tank2Sherman = new Rectangle(5,80,400,800);
        tank2Tiger = new Rectangle(660,80,400,800);
        tank2Churchill = new Rectangle(1300,80,400,800);
        box2D = new Box2D(gsm);
    }

    @Override
    public void handleInput() {
        if(Gdx.input.justTouched()) {
            if(tank2Sherman.contains(Gdx.input.getX(),1080-Gdx.input.getY())) {
                gsm.push(new Box2D(gsm));
                box2D.createTank2("Sherman");
            }
            else if(tank2Tiger.contains(Gdx.input.getX(),1080-Gdx.input.getY())) {
                gsm.push(new Box2D(gsm));
                box2D.createTank2("Tiger");
            }
            else if(tank2Churchill.contains(Gdx.input.getX(),1080-Gdx.input.getY())) {
                gsm.push(new Box2D(gsm));
                box2D.createTank2("Churchill");
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
        batch.draw(tankSelectionPlayer2, 0, 0, 1920, 1080);
        batch.end();
    }

    @Override
    public void dispose() {

    }
}

