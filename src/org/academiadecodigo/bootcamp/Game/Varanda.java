package org.academiadecodigo.bootcamp.Game;

import org.academiadecodigo.bootcamp.Game.UtilitiesPack.Utilities;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 20/02/2019.
 */
public class Varanda extends Utilities implements KeyboardHandler {


    Picture varanda = new Picture(10, 10, "bg copy 2.jpg"); // foto do antonio sem nada
    Picture textOne = new Picture(10, 10, "bg2.jpg"); // mesma foto com o balão de fala

    private boolean unlocked = false;
    //private boolean spacePressed = false;

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

        /*
        Keyboard keyboard = new Keyboard(this);

        KeyboardEvent space = new KeyboardEvent();
        space.setKey(KeyboardEvent.KEY_SPACE);
        space.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        while(!spacePressed){
            keyboard.addEventListener(space);
        }

        System.out.println("space pressed");
        keyboard.removeEventListener(space);
*/
        try {
            Thread.sleep(100); // tempo suficiente para ler
            //spacePressed = false;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return true;
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        //spacePressed = true;
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
