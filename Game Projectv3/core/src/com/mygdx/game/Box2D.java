package com.mygdx.game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.scenes.scene2d.utils.DragListener;
import com.mygdx.game.InputListener;
import com.mygdx.game.States.CollisionListener;
import com.mygdx.game.States.GameStateManager;
import com.mygdx.game.States.PauseMenu;
import com.mygdx.game.States.State;

import java.awt.dnd.DragGestureListener;
import java.util.ArrayList;


public class Box2D extends State {
    public World world;
    private AssetManager assetManager = new AssetManager();
    private final Box2DDebugRenderer box2dDebug;
    private Controls controls;
    private ArrayList<Missile> missilesArr = new ArrayList<Missile>();
    private Churchill tank1;
    private Churchill tank2;
    private Missile bullet1;
    private Missile bullet2;
    private TiledMap ground;
    private OrthogonalTiledMapRenderer groundRenderer;
    public CollisionListener collisionListener;
    public static final short GROUND_BIT = 8;
    public static final short TANK_BIT = 2;
    public static final short BULLET_BIT = 4;
    public static AssetManager asset;

    public Box2D(GameStateManager gsm) {
        super(gsm);
        Animator animator = new Animator();
        world = new World(new Vector2(0, -10f), true);
        world.setContactListener(new CollisionListener());
        collisionListener = new CollisionListener();
        world.setContactListener(collisionListener);
        box2dDebug = new Box2DDebugRenderer();
        Controls controls = new Controls();
        Gdx.input.setInputProcessor(controls);
        InputMultiplexer inputMultiplexer = new InputMultiplexer();
        createTank1("Churchill");
        createTank2("Churchill");
        createBullet1();
        createBullet2();
        tiles();

    }

        //tankBody1
    public void createTank1(String name) {
        BodyDef bodyDef = new BodyDef();
        bodyDef.position.set(40, 300);
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        Body body1 = world.createBody(bodyDef);


        FixtureDef fixtureDef = new FixtureDef();
        PolygonShape shapeTank = new PolygonShape();
        fixtureDef.filter.categoryBits = TANK_BIT;
        fixtureDef.filter.maskBits = GROUND_BIT | BULLET_BIT;
        shapeTank.setAsBox(50, 24);
        fixtureDef.shape = shapeTank;
        body1.createFixture(fixtureDef);
        Fixture fixture = body1.createFixture(fixtureDef);
        fixture.setUserData("tank1");
        tank1 = new Churchill(body1, name);

    }
        //tankBody2
    public void createTank2(String name) {
        BodyDef bodyDef = new BodyDef();
        bodyDef.position.set(1875, 400);
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        Body body2 = world.createBody(bodyDef);
        FixtureDef fixtureDef = new FixtureDef();
        PolygonShape shapeTank = new PolygonShape();
        fixtureDef.filter.categoryBits = TANK_BIT;
        fixtureDef.filter.maskBits = GROUND_BIT | BULLET_BIT;
        shapeTank.setAsBox(50, 24);
        fixtureDef.shape = shapeTank;
        body2.createFixture(fixtureDef);
        Fixture fixture = body2.createFixture(fixtureDef);
        fixture.setUserData("tank2");
        tank2 = new Churchill(body2, name);
        tank2.setSpritePic(assetManager.getTexture(5));

    }
        //tankBody2 end

    public void tiles() {
        BodyDef bodyDef = new BodyDef();
        FixtureDef fixtureDef = new FixtureDef();
        ground = new TmxMapLoader().load((Gdx.files.internal("core/res/Groundv2.tmx").file().getAbsolutePath()));
        groundRenderer = new OrthogonalTiledMapRenderer(ground);

        //layers

        TiledMapTileLayer layer = (TiledMapTileLayer) ground.getLayers().get("block");
        float tileSize = layer.getTileWidth();
        for (int i = 0; i < layer.getHeight(); i++) {
            for (int j = 0; j < layer.getWidth(); j++) {
                TiledMapTileLayer.Cell cell = layer.getCell(j, i);
                if (cell == null) continue;
                if (cell.getTile() == null) continue;
                bodyDef.type = BodyDef.BodyType.StaticBody;
                bodyDef.position.set((j + 0.5f) * tileSize, (i + 0.5f) * tileSize);
                ChainShape groundShape = new ChainShape();
                Vector2[] vector = new Vector2[8];
                vector[0] = new Vector2((-tileSize * 0.5f), (-tileSize * 0.5f));
                vector[1] = new Vector2((-tileSize * 0.5f), (tileSize * 0.5f));
                vector[2] = new Vector2((tileSize * 0.5f), (tileSize * 0.5f));
                vector[3] = new Vector2((tileSize * 0.5f), (-tileSize * 0.5f));
                vector[4] = new Vector2((-tileSize), (-tileSize * 0.5f));
                vector[5] = new Vector2((-tileSize * 0.5f), (tileSize));
                vector[6] = new Vector2((tileSize * 0.5f), (tileSize));
                vector[7] = new Vector2((tileSize), (-tileSize * 0.5f));
                groundShape.createChain(vector);
                fixtureDef.friction = 0;
                fixtureDef.shape = groundShape;
                fixtureDef.filter.categoryBits = GROUND_BIT;
                fixtureDef.filter.maskBits = TANK_BIT | BULLET_BIT;
                world.createBody(bodyDef).createFixture(fixtureDef);
            }
        }
    }

    public Body createBullet1() {
        //groundEnd
        //bulletBody1
        BodyDef bodyDef = new BodyDef();
        FixtureDef fixtureDef = new FixtureDef();
        bodyDef.position.set(tank1.getBody().getPosition().x + 50, tank1.getBody().getPosition().y + 20);
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        Body bulletBody1 = world.createBody(bodyDef);

        PolygonShape shapeBullet = new PolygonShape();
        fixtureDef.filter.categoryBits = BULLET_BIT;
        fixtureDef.filter.maskBits = GROUND_BIT | TANK_BIT;
        shapeBullet.setAsBox(32.5f, 14);
        fixtureDef.shape = shapeBullet;
        bulletBody1.createFixture(fixtureDef);
        Fixture fixture = bulletBody1.createFixture(fixtureDef);
        fixture.setUserData("BulletBody1");
        //bulletBody1 end
        return bulletBody1;
    }
    public Body createBullet2() {
        //bulletBody2
        BodyDef bodyDef = new BodyDef();
        FixtureDef fixtureDef = new FixtureDef();
        bodyDef.position.set(tank2.getBody().getPosition().x-50,tank2.getBody().getPosition().y+20);
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        Body bulletBody2 = world.createBody(bodyDef);

        PolygonShape shapeBullet = new PolygonShape();
        fixtureDef.filter.categoryBits = BULLET_BIT;
        fixtureDef.filter.maskBits = GROUND_BIT | TANK_BIT;
        shapeBullet.setAsBox(32.5f, 14);
        fixtureDef.shape = shapeBullet;
        bulletBody2.createFixture(fixtureDef);
        Fixture fixture = bulletBody2.createFixture(fixtureDef);
        fixture.setUserData("BulletBody2");

        return bulletBody2;
        //bulletBody2 end
    }

    public void handleInput() {
        if(reduceHealth()){
            System.out.println("Health reduced");
            gsm.set(new PauseMenu(gsm));
        }
        if (InputListener.isPressed(InputListener.W)) {
            tank1.getBody().applyForceToCenter(0, 1000, true);
        }
        if (InputListener.isPressed(InputListener.A)) {
            tank1.getBody().applyForceToCenter(-1000, 0, true);
        }
        if (InputListener.isPressed(InputListener.S)) {
            tank1.getBody().applyForceToCenter(0, -1000, true);
        }
        if (InputListener.isPressed(InputListener.D)) {
            tank1.getBody().applyForceToCenter(1000, 0, true);
        }
        if (InputListener.isPressed(InputListener.UP)) {
            tank2.getBody().applyForceToCenter(0, 1000, true);
        }
        if (InputListener.isPressed(InputListener.LEFT)) {
            tank2.getBody().applyForceToCenter(-1000, 0, true);
        }
        if (InputListener.isPressed(InputListener.RIGHT)) {
            tank2.getBody().applyForceToCenter(1000, 0, true);
        }
        if (InputListener.isPressed(InputListener.DOWN)) {
            tank2.getBody().applyForceToCenter(0, -1000, true);
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            int velocity = 100;
            int angle = 20;
            if (InputListener.isPressed(InputListener.O)) {
                angle += 20;
            }
            if (InputListener.isPressed(InputListener.K)) {
                angle -= 20;
            }
            bullet1 = new Missile(createBullet1(), angle, velocity);
            bullet1.setVelocityX(bullet1.velocity * (float) Math.cos(Math.toRadians(bullet1.angle)));
            bullet1.setVelocityY(bullet1.velocity * (float) Math.sin(Math.toRadians(bullet1.angle)));
            missilesArr.add(bullet1);
        }
        if(InputListener.isDown(InputListener.ENTER)){
                int velocity = -100;
                int angle = -20;
                if (InputListener.isPressed(InputListener.O)) {
                    angle -= 20;
                }
                if (InputListener.isPressed(InputListener.K)) {
                    angle += 20;
                }
                bullet2 = new Missile(createBullet2(),angle,velocity);
                bullet2.setVelocityX(bullet2.velocity * (float) Math.cos(Math.toRadians(bullet2.angle)));
                bullet2.setVelocityY(bullet2.velocity * (float) Math.sin(Math.toRadians(bullet2.angle)));
                bullet2.setBodyPic(assetManager.getTexture(8));
                missilesArr.add(bullet2);
        }
    }
    public boolean reduceHealth(){
        if(tank1.getHealth()<=0||tank2.getHealth()<=0){
            System.out.println("Game Over");
            return true;
        }
        if(collisionListener.getBulletHitTank1()){
            tank1.setHealth(-50);
            System.out.println("Health decreased");
            collisionListener.setBulletHitTank1();
        }
        if(collisionListener.getBulletHitTank2()){
            tank2.setHealth(-50);
            System.out.println("Health decreased");
            collisionListener.setBulletHitTank2();
        }
        return false;}
    public void update(float dt) {
        handleInput();
        world.step(dt, 6, 2);
        ArrayList<Body>MissilesToRemove =collisionListener.getBodiesToRemove();
        for(int i = 0; i <MissilesToRemove.size(); i++){
            world.destroyBody(MissilesToRemove.get(i));
        }
        MissilesToRemove.clear();
        tank1.update(dt);
        tank2.update(dt);
        for(int i = 0; i<missilesArr.size();i++){
            missilesArr.get(i).update(dt);
        }
    }


    public void render(SpriteBatch batch) {

        groundRenderer.setView(camera);
        groundRenderer.render();
        batch.setProjectionMatrix(camera.combined);
        tank1.render(batch);
        tank2.render(batch);
        for(int i = 0; i<missilesArr.size();i++){
            missilesArr.get(i).render(batch);
        }
//        box2dDebug.render(world, camera.combined);
    }

    @Override
    public void dispose() {

    }
}
