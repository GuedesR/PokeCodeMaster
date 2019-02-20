package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.StagesPack.Attic;
import org.academiadecodigo.bootcamp.StagesPack.Base;
import org.academiadecodigo.bootcamp.StagesPack.Stages;
import org.academiadecodigo.bootcamp.StagesPack.Unicornios;
import org.academiadecodigo.bootcamp.UtilitiesPack.Copa;
import org.academiadecodigo.bootcamp.UtilitiesPack.PingPong;
import org.academiadecodigo.bootcamp.UtilitiesPack.Utilities;
import org.academiadecodigo.bootcamp.UtilitiesPack.Varanda;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 19/02/2019.
 *
 * Instantiate all the backgrounds and shows them in a switch case with the 1,2,3,4,5,6 keys
 *
 *
 */
public class Corridor implements KeyboardHandler {

    //Instantiate backgrounds
    private Stages attic = new Attic();
    private Stages base = new Base();
    private Stages unicornios = new Unicornios();
    private Utilities pingPong = new PingPong();
    private Utilities copa = new Copa();
    private Utilities varanda = new Varanda();
    CatchScreen catchScreen;
    private GameScreens stages;


    private Picture corridor1 = new Picture(10,10,"corr1.jpg");
    private Picture corridor2 = new Picture(10,10,"corr2.jpg");
    private Picture corridor3 = new Picture(10,10,"corr3.jpg");

    private boolean stageIsOngoing=false;

    //chooses witch corridor to show

    public Corridor() throws InterruptedException{


        corridor1.draw();
        boolean bool;


        Keyboard keyboard = new Keyboard(this);

        KeyboardEvent onePressed = new KeyboardEvent();
        onePressed.setKey(KeyboardEvent.KEY_1);
        onePressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(onePressed);

        KeyboardEvent twoPressed = new KeyboardEvent();
        twoPressed.setKey(KeyboardEvent.KEY_2);
        twoPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(twoPressed);

        KeyboardEvent threePressed = new KeyboardEvent();
        threePressed.setKey(KeyboardEvent.KEY_3);
        threePressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(threePressed);

        KeyboardEvent fourPressed = new KeyboardEvent();
        fourPressed.setKey(KeyboardEvent.KEY_4);
        fourPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(fourPressed);

        KeyboardEvent fivePressed = new KeyboardEvent();
        fivePressed.setKey(KeyboardEvent.KEY_5);
        fivePressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(fivePressed);

        KeyboardEvent sixPressed = new KeyboardEvent();
        sixPressed.setKey(KeyboardEvent.KEY_6);
        sixPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(sixPressed);

        while (true) {
            System.out.print("");
            if (stageIsOngoing) {
                if(stages instanceof Stages) {
                    stages.drawStage();
                    catchScreen = new CatchScreen();
                    bool = catchScreen.init();
                    if (bool) {
                        stages.hideStage();
                    }
                    stageIsOngoing = false;
                }else{
                    stages.drawStage();
                    stages.hideStage();
                    stageIsOngoing = false;
                    /*
                    if (bool) {
                        stages.hideStage();
                    }*/
                }
            }
        }

    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_1) {
            //Go to base
            stages=base;
            stageIsOngoing=true;

        }
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_2) {
            //Go to attic
            stages=attic;
            stageIsOngoing=true;

        }
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_3 && pingPong.isUnlocked()) {
            //Go to attic
            stages=pingPong;
            stageIsOngoing=true;

        }
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_4 && copa.isUnlocked()) {
            //Go to attic
            stages=copa;
            stageIsOngoing=true;

        }
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_5 && varanda.isUnlocked()) {
            //Go to attic
            stages=varanda;
            stageIsOngoing=true;

        }
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_6 && unicornios.isUnlocked()) {
            //Go to attic
            stages=unicornios;
            stageIsOngoing=true;

        }
    }
    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
