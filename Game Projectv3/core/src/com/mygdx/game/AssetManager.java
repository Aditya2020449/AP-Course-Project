package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;

public class AssetManager {
    private Texture Sherman;
    public Texture []texturesArr = new Texture[100];
    public AssetManager() {
        Texture ShermanPic = new Texture("M4 Sherman.png");
        Texture TigerPic = new Texture("Tiger.png");
        Texture ChurchillPic = new Texture("Churchill.png");
        Texture MissilePic = new Texture("missileanimation.png");
        Texture MatchBackgroundPic = new Texture("MatchStarts.png");
        Texture ChurchillMirrorPic = new Texture("ChurchillMirror.png");
        Texture MissileMirrorPic = new Texture("missileanimationmirror.png");
        Texture TigerMirrorPic = new Texture("TigerMirror.png");
        Texture ShermanMirrorPic = new Texture("M4 ShermanMirror.png");
        texturesArr[0] = ShermanPic;
        texturesArr[1] = ShermanMirrorPic;
        texturesArr[2] = TigerPic;
        texturesArr[3] = TigerMirrorPic;
        texturesArr[4] = ChurchillPic;
        texturesArr[5] = ChurchillMirrorPic;
        texturesArr[6] = MissilePic;
        texturesArr[7] = MatchBackgroundPic;
        texturesArr[8] = MissileMirrorPic;

    }
    public Texture getTexture(int i) {
        return texturesArr[i];
    }
    public void disposeTexture(int i){
        texturesArr[i].dispose();
    }

}
