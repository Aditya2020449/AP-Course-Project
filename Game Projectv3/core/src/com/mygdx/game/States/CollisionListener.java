package com.mygdx.game.States;

import com.badlogic.gdx.physics.box2d.*;
import com.mygdx.game.Missile;

import java.util.ArrayList;

public class CollisionListener implements ContactListener {
    boolean bulletHitTank1 = false;
    boolean bulletHitTank2 = false;
    private ArrayList<Body> missilesRemove = new ArrayList<Body>();

    public CollisionListener(){
        missilesRemove = new ArrayList<Body>();
    }
    public ArrayList<Body> getBodiesToRemove() {
        return missilesRemove;
    }

    public void beginContact(Contact contact) {
        Fixture a = contact.getFixtureA();
        Fixture b = contact.getFixtureB();
        if(a==null || b==null) return;
        if(a.getUserData() != null && a.getUserData() == "BulletBody2" && b.getUserData() == "tank1"){
            bulletHitTank1 = true;
            System.out.println("Bullet hit tank1");
            missilesRemove.add(a.getBody());
        }
        if(b.getUserData()!=null && a.getUserData() == "tank1" && b.getUserData() == "BulletBody2"){
            bulletHitTank1 = true;
            System.out.println("Bullet hit tank1");

            missilesRemove.add(b.getBody());
        }
        if(a.getUserData() != null && a.getUserData() == "BulletBody1" && b.getUserData() == "tank2"){
            bulletHitTank2 = true;
            System.out.println("Bullet hit tank1");

            missilesRemove.add(a.getBody());
        }
        if(b.getUserData()!=null && a.getUserData() == "tank2" && b.getUserData() == "BulletBody1"){
            bulletHitTank2 = true;
            System.out.println("Bullet hit tank1");
            missilesRemove.add(b.getBody());
        }
        if(a.getUserData() != null && a.getUserData() == "BulletBody2" && b.getUserData() == "block"){
            missilesRemove.add(a.getBody());
            System.out.println("Bullet hit tank1");

        }
        if(b.getUserData()!=null && a.getUserData() == "block" && b.getUserData() == "BulletBody2"){
            missilesRemove.add(b.getBody());
            System.out.println("Bullet hit tank1");

        }
        if(a.getUserData() != null && a.getUserData() == "BulletBody1" && b.getUserData() == "block"){
            System.out.println("Bullet hit tank1");
            missilesRemove.add(a.getBody());
        }
        if(b.getUserData()!=null && a.getUserData() == "block" && b.getUserData() == "BulletBody1"){
            missilesRemove.add(b.getBody());
            System.out.println("Bullet hit tank1");

        }


    }
    public void endContact(Contact contact) {
    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {

    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {

    }

    public boolean getBulletHitTank1() {
        return bulletHitTank1;
    }
    public boolean getBulletHitTank2() {
        return bulletHitTank2;
    }

    public void setBulletHitTank1() {
        bulletHitTank1 = false;
    }

    public void setBulletHitTank2() {
        bulletHitTank2=false;
    }
}
