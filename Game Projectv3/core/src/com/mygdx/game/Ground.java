package com.mygdx.game;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

public class Ground {
    int upperBound = 10;
    int vertices = 10;
    Float var;
    static int[] verticesArr = new int[10];
    public double getX() {
        for (int i = 0; i < 100; i++) {
            float x = i / 99 * 10;
            return getNoiseFunc(x);
        }
        return 0;
    }
    public void fillVerticesArr(int[] arr) {
        for (int i = 0; i < vertices; i++) {
            arr[i] = MyGdxGame.random.nextInt(upperBound);
        }
    }

    public static float lerp(int min, int max, Float var) {
        return min * (1 - var) + var * max;
    }

    public float getNoiseFunc(float x) {
        fillVerticesArr(verticesArr);
        int min = (int) x;
        if (min <= vertices - 1) {
            var = x - min;
        }
        return lerp(verticesArr[min], verticesArr[min + 1], var);
    }
//
//    public Body createGround(World world) {
//        BodyDef ground = new BodyDef();
//        ground.type = BodyDef.BodyType.StaticBody;
//        ground.position.set(new Vector2(0.0F, 0.0F));
//        Body body = world.createBody(ground);
//        PolygonShape groundShape = new PolygonShape();
//        groundShape.setAsBox(16.01F, 2.0F);
//        body.createFixture(groundShape, 0.5F);
//        groundShape.dispose();
//        return body;
//    }
//
//    public Body createLeftWall(World world) {
//
//        BodyDef leftWall = new BodyDef();
//        leftWall.type = BodyDef.BodyType.StaticBody;
//        leftWall.position.set(new Vector2(-1.0F, 12.0F));
//        Body body = world.createBody(leftWall);
//        PolygonShape leftWallShape = new PolygonShape();
//        leftWallShape.setAsBox(1.0F, 11.0F);
//        body.createFixture(leftWallShape, 0.5F);
//        leftWallShape.dispose();
//        return body;
//
//    }
//
//    public Body createRightWall(World world) {
//
//        BodyDef rightWall = new BodyDef();
//        rightWall.type = BodyDef.BodyType.StaticBody;
//        rightWall.position.set(new Vector2(17F, 12.0F));
//        Body body = world.createBody(rightWall);
//        PolygonShape rightWallShape = new PolygonShape();
//        rightWallShape.setAsBox(0.999F, 11.0F);
//        body.createFixture(rightWallShape, 0.5F);
//        rightWallShape.dispose();
//        return body;
//
//    }

}

