package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.graphics.Texture;


public class Churchill extends Box2DSprite{
    Texture tankPic;
    String tankName;
    private int health;
    public Churchill(Body body, String tankName) {
        super(body);
        this.tankName = tankName;
        AssetManager assetManager = new AssetManager();
        tankPic=(assetManager.getTexture(2));
        TextureRegion[] frames = TextureRegion.split(tankPic,120,48)[0];
        setAnimator(frames, 1);
        health = 100;

    }
    public void setSpritePic(Texture tankPic){
        TextureRegion[] frames = TextureRegion.split(tankPic,120,48)[0];
        setAnimator(frames, 1);
    }
    public void setName(String name) {
        name = "Churchill";
    }

    public void setFuel(float fuel) {
        fuel = 100;
    }

    public void setHealth(int health) {
        this.health += health;
    }

    public void setDamage(float damage) {
        damage = 30;
    }

//    public void setSpecialMissilesHeavenly(SpecialMissile[] Missiles) {
//        SpecialMissilesCount+=1;
//        HeavenlyNukeCount+=1;
//        specialMissiles[SpecialMissilesCount] = HeavenlyNuke;
//    }
//    public void setSpecialMissilesLightning(SpecialMissile[] Missiles) {
//        SpecialMissilesCount+=1;
//        LightningBoltCount+=1;
//        specialMissiles[SpecialMissilesCount] = LightningBolt;
//    }



    public void setSpecialMissilesCount(int specialMissilesCount) {
        specialMissilesCount=0;
    }


    public void setHeavenlyNukeCount(int heavenlyNukeCount) {
        heavenlyNukeCount=(heavenlyNukeCount);
    }


    public void setLightningBoltCount(int lightningBoltCount) {
        lightningBoltCount = 0;
    }


    public void setDescription(String description) {
        description=(description);
    }


    public int getHealth() {
        return health;
    }
}
