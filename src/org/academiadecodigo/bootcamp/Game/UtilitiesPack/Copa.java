package org.academiadecodigo.bootcamp.Game.UtilitiesPack;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 20/02/2019.
 */
public class Copa extends Utilities implements KeyboardHandler {

    Picture copaVazia = new Picture(10, 10, "bg.jpg");

    Picture copaCheia = new Picture(10, 10, "bg3.jpg");

    private boolean unlocked = true;

    private boolean actionComplete = false;

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

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        copaVazia.draw();

        try {
            Thread.sleep(200);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return true;
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_X) {
            actionComplete = true;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

    /*@Override
    public void mouseClicked(MouseEvent mouseEvent) {
        if (mouseEvent.getY() > 0) {
            actionComplete = true;
        }
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }*/
}
