package org.academiadecodigo.bootcamp.StagesPack;

import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 20/02/2019.
 */
public class Unicornios extends Stages {

    private Picture background = new Picture(10, 10, "bg3.jpg");
    private boolean isUnlocked = false;


    @Override
    public boolean isUnlocked() {
        return isUnlocked;
    }

    @Override
    public void init() {
        drawStage();


    }

    @Override
    public void drawStage() {
        background.draw();

    }

    @Override
    public void hideStage() {
        background.delete();

    }

    @Override
    public void startPokemon() {


    }

    public void setUnlocked(){
        isUnlocked=true;
    }
}
