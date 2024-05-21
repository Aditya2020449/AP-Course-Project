package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.Body;

public class Tank extends Box2DSprite {

    String Name="Churchill";
    float Fuel;
    float Health;
    float Damage;
    SpecialMissile[] Missile = new SpecialMissile[10];
    int SpecialMissilesCount;
    int HeavenlyNukeCount;
    int LightningBoltCount;
    Missile HeavenlyNuke;
    Missile LightningBolt;
    String Description;
    Texture TankPic;
    public Tank(Body body) {
    super(body);

    }

    public void setName(String name) {
        Name = name;
    }

    public void setFuel(float fuel) {
        Fuel = fuel;
    }

    public void setHealth(float health) {
        Health = health;
    }

    public void setDamage(float damage) {
        Damage = damage;
    }

//    public void setSpecialMissiles(SpecialMissile[] specialMissiles) {
//        SpeicalMissiles[specialMissilesCount] =Missiles;
//    }

    public void setSpecialMissilesCount(int specialMissilesCount) {
        SpecialMissilesCount = specialMissilesCount;
    }

    public void setHeavenlyNukeCount(int heavenlyNukeCount) {
        HeavenlyNukeCount = heavenlyNukeCount;
    }

    public void setLightningBoltCount(int lightningBoltCount) {
        LightningBoltCount = lightningBoltCount;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setTankPic(Texture tankPic) {
        TankPic = tankPic;
    }
//    public void createFixture(){
//        bodyDef.position.set(20,30);


}


