package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.States.GameStateManager;
import com.mygdx.game.States.Menu;

import java.util.Random;

public class MyGdxGame extends ApplicationAdapter {
	static Random random = new Random();
	private SpriteBatch batch;
	private Controls controls;
	Texture img;
	public static final int HEIGHT = 1080;
	public static final int WIDTH = 1920;
	private GameStateManager gsm;
	Ground ground;
//	ground.getX();
	@Override
	public void create () {
		gsm = new GameStateManager();
		batch = new SpriteBatch();
		gsm.push(new Menu(gsm));
	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 0, 0, 1);
		gsm.peek(Gdx.graphics.getDeltaTime());
		gsm.render(batch);
	}
	public void handleInput(){
	}
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
