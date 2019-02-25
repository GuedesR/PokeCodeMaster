package org.academiadecodigo.bootcamp.Game;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Menu implements KeyboardHandler, MouseHandler {

    private Rectangle backgroung;
    private Picture back;
    private Picture start;
    private Picture rules;
    private boolean up = false;
    private boolean stop = false;
    private boolean notExit = false;
    private boolean rKey = false;
    private Rules menuRules;
    private Music music = new Music();

    public void init() throws InterruptedException {



        back = new Picture(10,10,"menu.png");
        back.draw();

        start = new Picture(30, 270, "start.jpg");
        //start.draw();

        rules = new Picture(30, 470, "rules.jpg");
        //rules.draw();

        Keyboard keyboard = new Keyboard(this);
        Mouse mouse = new Mouse(this);

        KeyboardEvent sPressed = new KeyboardEvent();
        sPressed.setKey(KeyboardEvent.KEY_P);
        sPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(sPressed);

        KeyboardEvent rPressed = new KeyboardEvent();
        rPressed.setKey(KeyboardEvent.KEY_R);
        rPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(rPressed);

        KeyboardEvent sePressed = new KeyboardEvent();
        sePressed.setKey(KeyboardEvent.KEY_S);
        sePressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(sePressed);

        mouse.addEventListener(MouseEventType.MOUSE_CLICKED);

        //menu song show


        music.musicplay("menu");

        do {
            System.out.print("");
            if (up) {
                Corridor corridor = new Corridor();
                up = false;
                keyboard.removeEventListener(sPressed);
                keyboard.removeEventListener(sPressed);
            }

        } while (!stop);


    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_P) {
            //Corridor corridor= new Corridor();
            System.out.println("start key");
            up = true;
            notExit = true;
            music.stop();
        }
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE) {
            stop = true;
        }
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_R) { // trocar para click do rato
            menuRules = new Rules();
            menuRules.showRules();
        }
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_S) { // trocar para click do rato
            menuRules = new Rules();
            menuRules.showRules();
        }

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        System.out.println("menu X: " + mouseEvent.getX() + " menu Y: " + mouseEvent.getY());

    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }
}