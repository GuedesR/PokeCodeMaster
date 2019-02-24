package org.academiadecodigo.bootcamp.Game.Items;

import org.academiadecodigo.bootcamp.Game.Music;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 16/02/2019.
 */
public class ThrowingBar implements KeyboardHandler{

    private Rectangle background;
    private Rectangle square;
    private Picture backBar;
    private Picture squareBar;
    private boolean isGoingDown=true;
    boolean stop=false;
    private int throwNumber;
    private int barX=30;
    private int barY=50;
    private int pos=0;

    public int init() throws InterruptedException{

        backBar = new Picture(barX,barY+20,"bar.png");
        backBar.draw();
        squareBar = new Picture(barX,barY-20,"barBall.png");
        squareBar.draw();

        //background= new Rectangle(barX,barY+20,40,200);
        //background.setColor(Color.WHITE);
        //background.fill();

        square = new Rectangle(barX+10,barY-10,20,20);
        square.setColor(Color.BLUE);
        //square.fill();

        Keyboard keyboard = new Keyboard(this);
        KeyboardEvent spacePressed = new KeyboardEvent();
        spacePressed.setKey(KeyboardEvent.KEY_SPACE);
        spacePressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(spacePressed);

        while(!stop) {
            moveSquare();
        }
        throwNumber=square.getY()/square.getHeight();

        backBar.delete();

        //background.delete();
        square.delete();
        squareBar.delete();

        return pos;
    }

    public void moveSquare() throws InterruptedException{

        if(isGoingDown){
            goDown();

            int temp1=9*square.getHeight();
            int temp=barY+temp1;


            if(square.getY()==temp+10){
                isGoingDown=false;
            }
        }else {
            Thread.sleep(200);
            goUp();
            if(square.getY()==(barY+10)){
                isGoingDown=true;
            }
        }
    }

    public void goDown(){
        squareBar.translate(0,squareBar.getHeight()/2);
        square.translate(0,square.getHeight());
        pos++;

    }

    public void goUp(){
        squareBar.translate(0,-squareBar.getHeight()/2);
        square.translate(0,-square.getHeight());
        pos--;

    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        if(keyboardEvent.getKey()==KeyboardEvent.KEY_SPACE){
            stop=true;
            //ball throwing sound
            Music music = new Music();
            music.musicplay("ball");
        }

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}