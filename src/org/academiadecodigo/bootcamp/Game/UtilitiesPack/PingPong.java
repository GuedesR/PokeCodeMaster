package org.academiadecodigo.bootcamp.Game.UtilitiesPack;

import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 20/02/2019.
 */
public class PingPong extends Utilities {

    private Picture background = new Picture(10,10,"bg.jpg");

    private boolean unlocked=true;

    public boolean isUnlocked() {
        return unlocked;
    }

    @Override
    public boolean action() { //give pokeballs


        return true;
    }

    public void setUnlocked() {
        unlocked = true;
    }

    @Override
    public void drawStage() {
        background.draw();
    }


    @Override
    public void hideStage() {
        background.delete();
    }
}
