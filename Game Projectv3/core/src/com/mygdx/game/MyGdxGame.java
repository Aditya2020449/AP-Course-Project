package com.mygdx.game;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.States.GameStateManager;
import com.mygdx.game.States.Menu;

import java.util.Random;

public class MyGdxGame implements ApplicationListener {
    static Random random = new Random();
	private SpriteBatch batch;
	private MyGdxGame game;
	private OrthographicCamera camera;
	private Music music;
	public static final int HEIGHT = 1080;
	public static final int WIDTH = 1920;
	private GameStateManager gsm;
	public static AssetManager assetManager;
	public SpriteBatch getSpriteBatch() {
		return batch;
	}
	public OrthographicCamera getCamera() {
		return camera;
	}
	public MyGdxGame getGame() {
		return game;
	}
	@Override
	public void create () {
		gsm = new GameStateManager(this);
		batch = new SpriteBatch();
		camera = new OrthographicCamera();
		assetManager = new AssetManager();
		Gdx.input.setInputProcessor(new Controls());
		camera.setToOrtho(false, WIDTH, HEIGHT);
		music = Gdx.audio.newMusic(Gdx.files.internal("soundtrack.mp3"));
		music.setLooping(true);
		gsm.push(new Box2D(gsm));
		show();
	}

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void render () {
		ScreenUtils.clear(0, 0, 0, 1);
		gsm.peek(Gdx.graphics.getDeltaTime());
		gsm.render(batch);
		InputListener.update();

	}

	public void show(){
		music.play();
	}
	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}

	public void handleInput(){
	}
	public void update(float dt){

	}
	@Override
	public void dispose () {
//		batch.dispose();
//		img.dispose();
		music.dispose();
	}
}
