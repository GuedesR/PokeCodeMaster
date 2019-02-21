package org.academiadecodigo.bootcamp.Game;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;


/**
 * --Player Screen--
 *
 * Novo nome de CatchScreen
 * Uma vez que este vai ser onde se vai colocar todas as opções do Jogador não só apanhar.
 */
public class PlayerScreen implements KeyboardHandler{

    private Picture backGround;
    private Background bG;
    private boolean isChangeScreen=false;
    private boolean caught=false;
    private Pokeball ball;


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

                ball = new Pokeball();
                ball.init();

                KeyboardEvent leftPressed = new KeyboardEvent();
                leftPressed.setKey(KeyboardEvent.KEY_LEFT);
                leftPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
                keyboard.addEventListener(leftPressed);

                KeyboardEvent rightPressed = new KeyboardEvent();
                rightPressed.setKey(KeyboardEvent.KEY_RIGHT);
                rightPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
                keyboard.addEventListener(rightPressed);


                ThrowingBar throwingBar = new ThrowingBar();
                int barStrength = throwingBar.init();
                System.out.println("  -  " + barStrength + "    ..   ");

                if (barStrength > 6) {
                    barStrength = 1;//closer
                } else if (barStrength > 3) {
                    barStrength = 2;
                } else {
                    barStrength = 3;//farthest
                }

                System.out.println(barStrength);
                int pos = ball.throwP(barStrength);


                 /*if (barStrength == 3) {
                    barStrength = 1;
                } else if (barStrength == 2) {
                    barStrength = 2;
                } else {
                    barStrength = 3;
                }*/

                System.out.println(barStrength + "  -  " + poke1.getY());
                System.out.println(pos + "  _  " + poke1.getX());

                if (barStrength == poke1.getY() && pos == poke1.getX()) {
                    System.out.println("----__---HIT---__----");
                    poke1.hidePokemon();
                    if(((int)(Math.random()*10)+1)<poke1.getCatchRate()) {
                        ball.hit(3);                                //---Se conseguir apanhar, vai repetir o movimento 3x
                        ball.catchSuccess();
                        poke1.caught();//deletes pokemon
                        caught = true;
                        //Changing Screen
                        //bG.stageInc();
                        return true;
                        //isChangeScreen = true;
                    } else {
                        //poke1.hidePokemon();
                        ball.hit(2);                                //---Se o pokemon resistir só repete o movimento 2x
                        ball.catchFail();
                        poke1.showPokemon();
                    }
                } else {
                    System.out.println("____--__FAIL___--____");
                    ball.hidePokeball();
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
            ball.moveBallLeft();
            System.out.println("Left pressed");
        }

        if(keyboardEvent.getKey() == keyboardEvent.KEY_RIGHT){
            ball.moveBallRight();
            System.out.println("Right pressed");
        }

    }


    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}