package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.States.GameStateManager;
import com.mygdx.game.States.Menu;

public class MyGdxGame extends ApplicationAdapter {
	private SpriteBatch batch;
	Texture img;
	public static final int HEIGHT = 1080;
	public static final int WIDTH = 1920;
//	public static final String TITLE = "Tank Stars";
	private GameStateManager gsm;


	
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
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
