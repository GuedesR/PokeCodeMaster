package org.academiadecodigo.bootcamp.Game.UtilitiesPack;

import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 23/02/2019.
 */
public class NoPokemonScreen extends Utilities {

    Picture copaVazia = new Picture(10, 10, "noPokes.jpg");

    Picture copaCheia = new Picture(10, 10, "noPokes.jpg");

    private boolean unlocked = true;

    private boolean actionComplete =false;

    @Override
    public void drawStage() {
        copaCheia.draw();
    }

    @Override
    public void hideStage() {
        copaCheia.delete();
        copaVazia.delete();
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
    public boolean action() { // mete as cervejas no máximo

        try {
            Thread.sleep(200);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        copaVazia.draw();

        try {
            Thread.sleep(200);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return true;
    }


}
