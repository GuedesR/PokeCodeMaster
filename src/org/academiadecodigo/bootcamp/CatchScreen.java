package org.academiadecodigo.bootcamp;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import javax.sound.midi.Soundbank;

/**
 * Created by codecadet on 16/02/2019.
 */
public class CatchScreen implements KeyboardHandler{

    private Picture backGround;
    private Background bG;
    private boolean isChangeScreen=false;
    private boolean caught=false;
    private Pokeball p;


    public boolean init()  throws InterruptedException {
/*
        backGround = new Picture(10,10,"bg.jpg");
        backGround.draw();
*/
        ///////bG = new Background();
        ///////bG.init();
        int yPokeCoord=100;
        PokePlacement poke1= null;



        Keyboard keyboard = new Keyboard(this);

        KeyboardEvent wPressed = new KeyboardEvent();
        wPressed.setKey(KeyboardEvent.KEY_W);
        wPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(wPressed);

        while (!isChangeScreen) {
            isChangeScreen=false;
            if(!caught) {
                poke1 = new PokePlacement();
                yPokeCoord = poke1.init();

            }else{

            }
            while (!caught) {

                p = new Pokeball();
                p.init();

                KeyboardEvent leftPressed = new KeyboardEvent();
                leftPressed.setKey(KeyboardEvent.KEY_LEFT);
                leftPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
                keyboard.addEventListener(leftPressed);

                KeyboardEvent rightPressed = new KeyboardEvent();
                rightPressed.setKey(KeyboardEvent.KEY_RIGHT);
                rightPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
                keyboard.addEventListener(rightPressed);


                ThrowingBar t = new ThrowingBar();
                int tN = t.init();
                System.out.println("  -  " + tN + "    ..   ");

                if (tN > 6) {
                    tN = 1;//closer
                } else if (tN > 3) {
                    tN = 2;
                } else {
                    tN = 3;//farthest
                }

                System.out.println(tN);
                int pos = p.throwP(tN);


                 /*if (tN == 3) {
                    tN = 1;
                } else if (tN == 2) {
                    tN = 2;
                } else {
                    tN = 3;
                }*/

                System.out.println(tN + "  -  " + poke1.getY());
                System.out.println(pos + "  _  " + poke1.getX());

                if (tN == poke1.getY() && pos == poke1.getX()) {
                    System.out.println("----__---HIT---__----");
                    poke1.hidePokemon();
                    if(((int)(Math.random()*10)+1)<poke1.getCatchRate()) {
                        p.catchSuccess();
                        poke1.caught();//deletes pokemon
                        caught = true;
                        /*
                        while (!isChangeScreen){
                            System.out.println();
                            keyboard.addEventListener(wPressed);
                         }*/
                        //Changing Screen
                        //bG.stageInc();
                        return true;
                        //isChangeScreen = true;
                    } else {
                        poke1.hidePokemon();
                        p.catchFail();
                        poke1.showPokemon();
                    }
                } else {
                    System.out.println("____--__FAIL___--____");
                    p.hidePokeball();
                    caught = false;
                }

            }
        }
        System.out.println("Something went terribly wrong");

        return false;
    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_W) {
            // bG.stageInc();
            System.out.println("W pressed ");
            isChangeScreen=true;

        }

        if(keyboardEvent.getKey() == keyboardEvent.KEY_LEFT){
            p.moveBallLeft();
            System.out.println("Left pressed");
        }

        if(keyboardEvent.getKey() == keyboardEvent.KEY_RIGHT){
            p.moveBallRight();
            System.out.println("Right pressed");
        }

    }


    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}