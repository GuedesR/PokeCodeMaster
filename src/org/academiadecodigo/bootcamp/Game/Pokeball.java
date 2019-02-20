package org.academiadecodigo.bootcamp.Game;

import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.ArrayList;
import java.util.Collection;
import java.util.PriorityQueue;

/**
 * Created by codecadet on 16/02/2019.
 */
public class Pokeball {

    private Picture pokeball;
    private final int ballThrowAnimationDelay=50;
    private final int ballCatchAnimationDelay=200;
    private int frames;
    private int x;
    private int pos = 2;

    public void init(){

        pokeball = new Picture(192,625,"Pokeball1.png");
        pokeball.draw();
    }

    public int throwP(int ammount) throws InterruptedException{

        if(ammount == 1){
            frames = 10;
            x = 8;
            for (int i = 0; i < frames ; i++){
                if(i < frames/2){
                    Thread.sleep(ballThrowAnimationDelay);
                    pokeball.translate(x , -12);
                    pokeball.grow(-4,-4);
                    x-= 0.4;
                } else {
                    Thread.sleep(ballThrowAnimationDelay);
                    pokeball.translate(-x , -12);
                    pokeball.grow(-4,-4);
                    x+= 1;
                }
            }

        } else if( ammount == 2){
            frames = 14;
            x=10;
            for (int i = 0; i < frames ; i++){
                if(i < frames/2){
                    Thread.sleep(ballThrowAnimationDelay);
                    pokeball.translate(x , -15);
                    pokeball.grow(-3,-3);
                    x-= 1;
                } else {
                    Thread.sleep(ballThrowAnimationDelay);
                    pokeball.translate(-x , -15);
                    pokeball.grow(-3,-3);
                    x+= 2;
                }
            }

        } else {
            frames = 20;
            x = 15;
            for (int i = 0; i < frames ; i++){
                if(i < frames/2){
                    Thread.sleep(ballThrowAnimationDelay);
                    pokeball.translate(x , -18);
                    pokeball.grow(-2.3,-2.3);
                    x-= 1.5;
                } else {
                    Thread.sleep(ballThrowAnimationDelay);
                    pokeball.translate(-x , -18);
                    pokeball.grow(-2.3,-2.3);
                    x+= 2;
                }
            }


        }
        //pokeball.delete();
        return pos;

    }

    public void moveBallRight(){
        if(pos == 3){
            return;
        }
        pokeball.translate(120,0);
        pos++;

    }

    public void moveBallLeft() {
        if(pos == 1){
            return;
        }
        pokeball.translate(-120,0);
        pos--;
    }

    public void catchSuccess() throws InterruptedException{
        pokeball.grow(10,10);
        pokeball.translate(-5,0);
        Thread.sleep(ballCatchAnimationDelay);
        pokeball.translate(10,0);
        Thread.sleep(ballCatchAnimationDelay+20);
        pokeball.translate(-10,0);
        Thread.sleep(ballCatchAnimationDelay);
        pokeball.translate(10,0);
        Thread.sleep(ballCatchAnimationDelay+20);
        pokeball.translate(-10,0);
        Thread.sleep(ballCatchAnimationDelay);
        pokeball.translate(10,0);
        Thread.sleep(ballCatchAnimationDelay+20);
        Picture gotcha = new Picture(65,320,"gotcha.png");
        gotcha.draw();
        Thread.sleep(ballCatchAnimationDelay+20);
        pokeball.delete();
        Thread.sleep(ballCatchAnimationDelay+20);
        gotcha.delete();

    }

    public void catchFail() throws InterruptedException{
        pokeball.grow(10,10);
        pokeball.translate(-5,0);
        Thread.sleep(ballCatchAnimationDelay);
        pokeball.translate(10,0);
        Thread.sleep(ballCatchAnimationDelay+20);
        pokeball.translate(-10,0);
        Thread.sleep(ballCatchAnimationDelay);
        pokeball.translate(10,0);
        Thread.sleep(ballCatchAnimationDelay+20);
        Picture fail = new Picture(65,320,"fail.png");
        pokeball.delete();
        fail.draw();
        Thread.sleep(ballCatchAnimationDelay+20);
        fail.delete();
    }

    public void hidePokeball(){
        pokeball.delete();
    }


}