package org.academiadecodigo.bootcamp.Game.UtilitiesPack;

import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 20/02/2019.
 */
public class PingPong extends Utilities {

    private Picture background = new Picture(10,10,"pingPong.jpg");

    private boolean unlocked=false;

    public boolean isUnlocked() {
        return unlocked;
    }

    @Override
    public boolean action() { //give pokeballs

        background.draw();
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
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
