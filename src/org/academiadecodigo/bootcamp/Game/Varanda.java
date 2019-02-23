package org.academiadecodigo.bootcamp.Game;

import org.academiadecodigo.bootcamp.Game.UtilitiesPack.Utilities;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 20/02/2019.
 */
public class Varanda extends Utilities {


    Picture varanda = new Picture(10, 10, "bg copy 2.jpg"); // foto do antonio sem nada
    Picture textOne = new Picture(10, 10, "bg2.jpg"); // mesma foto com o balão de fala

    private boolean unlocked = true;

    @Override
    public void drawStage() {
        varanda.draw();
    }

    @Override
    public void hideStage() {
        varanda.delete();
        textOne.delete();
    }

    @Override
    public void setUnlocked() {
        unlocked = true;
    }

    @Override
    public boolean isUnlocked() {
        return unlocked;
    }

    @Override
    public boolean action() {

        try {
            Thread.sleep(500);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        textOne.draw();

        try {
            Thread.sleep(1000); // tempo suficiente para ler
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return true;
    }
}
