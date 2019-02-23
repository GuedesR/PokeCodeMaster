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
    public static int currentAmount = 5;

    public void init(){

        pokeball = new Picture(192,625,"Pokeball1.png");
        pokeball.draw();
    }

    public void reset(){
        pokeball.draw();
    }

    public int throwP(int barStrength) throws InterruptedException{
        currentAmount--;
        if(barStrength == 1){
            frames = 10;
            x = 8;
            for (int i = 0; i < frames ; i++){
                if(i < frames/2){

                    pokeball.translate(x , -12);
                    pokeball.grow(-4,-4);
                    x-= 0.4;
                    Thread.sleep(ballThrowAnimationDelay);
                } else {
                    pokeball.translate(-x , -12);
                    pokeball.grow(-4,-4);
                    x+= 1;
                    Thread.sleep(ballThrowAnimationDelay);
                }
            }

        } else if( barStrength == 2){
            frames = 14;
            x=10;
            for (int i = 0; i < frames ; i++){
                if(i < frames/2){
                    pokeball.translate(x , -15);
                    pokeball.grow(-3,-3);
                    x-= 1;
                    Thread.sleep(ballThrowAnimationDelay);
                } else {
                    pokeball.translate(-x , -15);
                    pokeball.grow(-3,-3);
                    x+= 2;
                    Thread.sleep(ballThrowAnimationDelay);
                }
            }

        } else {
            frames = 20;
            x = 15;
            for (int i = 0; i < frames ; i++){
                if(i < frames/2){
                    pokeball.translate(x , -18);
                    pokeball.grow(-2,-2);
                    x-= 1;
                    Thread.sleep(ballThrowAnimationDelay);
                } else {
                    pokeball.translate(-x , -18);
                    pokeball.grow(-2,-2);
                    x+= 2;
                    Thread.sleep(ballThrowAnimationDelay);
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
        pokeball.translate(110,0);
        System.out.println("----" + pokeball.getX() + " pos: " + pos);
        pos++;
        System.out.println("After pos: " + pos);

    }

    public void moveBallLeft() {
        if(pos == 1){
            return;
        }
        pokeball.translate(-110,0);
        System.out.println("----" + pokeball.getX() + " pos " + pos);
        pos--;

        System.out.println("After pos: " + pos);
    }

    /**
     *  Coloquei a animação de tilt á parte para que corra em separado do catch.
     *  Assim podemos rapidamente repetir as vezes que quisermos mudando a variavel repetition na implementação do method.
     *  Nomeadamente, se o pokemon resiste ou não.
     */

    public void hit(int repetition) throws InterruptedException{
        pokeball.grow(10,10);
        pokeball.translate(-5,-5);
        Thread.sleep(ballCatchAnimationDelay);

        int repeat = 0;

        while(repeat < repetition){
            pokeball.translate(10,0);
            pokeball.load("Pokeball2.png");
            pokeball.draw();
            Thread.sleep(ballCatchAnimationDelay+100);

            pokeball.translate(-10,0);
            pokeball.load("Pokeball1.png");
            pokeball.draw();
            Thread.sleep(ballCatchAnimationDelay);

            pokeball.translate(-10,0);
            pokeball.load("Pokeball3.png");
            pokeball.draw();
            Thread.sleep(ballCatchAnimationDelay+100);

            pokeball.translate(10,0);
            pokeball.load("Pokeball1.png");
            pokeball.draw();
            Thread.sleep(ballCatchAnimationDelay);



            repeat ++;
        }

    }

    public void catchSuccess() throws InterruptedException{

        Picture gotcha = new Picture(65,320,"gotcha.png");
        gotcha.draw();
        Thread.sleep(ballCatchAnimationDelay+20);

        pokeball.delete();
        Thread.sleep(ballCatchAnimationDelay+20);
        gotcha.delete();

    }

    public void catchFail() throws InterruptedException{
        Picture fail = new Picture(65,320,"fail.png");
        pokeball.delete();
        fail.draw();
        Thread.sleep(ballCatchAnimationDelay+20);
        fail.delete();
        pos = 2;
    }

    public void hidePokeball(){
        pokeball.delete();
    }


    public int getX(){
        return pokeball.getX();
    }

    public void setPos(int pos){
        this.pos= pos;
    }

    public static int getCurrentAmount() {
        return currentAmount;
    }

    public static void removeBall(){
        currentAmount--;
    }

    public static void addCurrentAmount(int amount) {
        currentAmount += amount;
    }
}