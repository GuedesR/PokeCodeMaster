package org.academiadecodigo.bootcamp.Game;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Menu implements KeyboardHandler {

    private Rectangle backgroung;
    private Picture start;
    private Picture rules;
    private boolean up=false;
    private boolean stop=false;
    private boolean notexit=false;


    public void init() throws InterruptedException{

        backgroung = new Rectangle(10,10,465,730);
        backgroung.setColor(Color.CYAN);
        backgroung.fill();

        start = new Picture(30,270,"start.jpg");
        start.draw();

        rules = new Picture(30,470,"rules.jpg");
        rules.draw();

        Keyboard keyboard = new Keyboard(this);

        KeyboardEvent upPressed = new KeyboardEvent();
        upPressed.setKey(KeyboardEvent.KEY_UP);
        upPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(upPressed);

        KeyboardEvent downPressed = new KeyboardEvent();
        downPressed.setKey(KeyboardEvent.KEY_DOWN);
        downPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(downPressed);


        //menu song init
/*
        Music music = new Music();
        music.musicplay("menu");
*/
        do{
            System.out.print("");
            if (up) {
                Corridor corridor = new Corridor();
                up=false;
                keyboard.removeEventListener(upPressed);
                keyboard.removeEventListener(downPressed);
            }

        }while (!stop);


    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        if(keyboardEvent.getKey()==KeyboardEvent.KEY_UP){
            //Corridor corridor= new Corridor();
            System.out.println("start key");
            up=true;

            notexit=true;
        }if(keyboardEvent.getKey()==KeyboardEvent.KEY_DOWN && !notexit){
            System.out.println("down key");
            System.exit(1);
        }
        if(keyboardEvent.getKey()==KeyboardEvent.KEY_SPACE){
            stop=true;
        }

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

}