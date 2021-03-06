package org.academiadecodigo.bootcamp.Game.Items;

import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 16/02/2019.
 */
public class Pokeball {

    private Picture pokeball;
    private final int ballThrowAnimationDelay=30;
    private final int ballCatchAnimationDelay=200;
    private int pos = 2;
    private static int currentAmount = 5;

    public void init(){
        pokeball = new Picture(192,625, "pokeball1.png");
        pokeball.draw();
    }

    public void reset(){
        pokeball.draw();
    }

    public int throwP(int barStrength) throws InterruptedException{
        currentAmount--;
        int frames;
        int x;
        if(barStrength == 1){
            frames = 10;
            x = 8;
            for (int i = 0; i < frames; i++){
                if(i < frames /2){

                    pokeball.translate(x, -12);
                    pokeball.grow(-4,-4);
                    x -= 0.5;
                    Thread.sleep(ballThrowAnimationDelay);
                } else {
                    pokeball.translate(-x, -12);
                    pokeball.grow(-4,-4);
                    x += 0.9;
                    Thread.sleep(ballThrowAnimationDelay);
                }
            }

        } else if( barStrength == 2){
            frames = 14;
            x =10;
            for (int i = 0; i < frames; i++){
                if(i < frames /2){
                    pokeball.translate(x, -15);
                    pokeball.grow(-3,-3);
                    x -= 1;
                    Thread.sleep(ballThrowAnimationDelay);
                } else {
                    pokeball.translate(-x, -15);
                    pokeball.grow(-3,-3);
                    x += 1.8;
                    Thread.sleep(ballThrowAnimationDelay);
                }
            }

        } else {
            frames = 20;
            x = 10;
            for (int i = 0; i < frames; i++){
                if(i < frames /2){
                    pokeball.translate(x, -18);
                    pokeball.grow(-2,-2);
                    x -= 1;
                    Thread.sleep(ballThrowAnimationDelay);
                } else {
                    pokeball.translate(-x, -18);
                    pokeball.grow(-2,-2);
                    x += 1.8;
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

    /*
     *  A animação de tilt deve ficar à parte para que corra em separado do catch.
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
            pokeball.load("pokeball2.png");
            pokeball.draw();
            Thread.sleep(ballCatchAnimationDelay+100);

            pokeball.translate(-10,0);
            pokeball.load("pokeball1.png");
            pokeball.draw();
            Thread.sleep(ballCatchAnimationDelay);

            pokeball.translate(-10,0);
            pokeball.load("pokeball3.png");
            pokeball.draw();
            Thread.sleep(ballCatchAnimationDelay+100);

            pokeball.translate(10,0);
            pokeball.load("pokeball1.png");
            pokeball.draw();
            Thread.sleep(ballCatchAnimationDelay);

            repeat ++;
        }

    }

    public void catchSuccess() throws InterruptedException{

        Picture gotcha = new Picture(65,320,"gotcha.png");


        pokeball.grow(30,30);
        pokeball.translate(-15,-15);
        pokeball.load("pokebal4.png");
        pokeball.draw();
        gotcha.draw();

        Thread.sleep(500);
        pokeball.delete();
        gotcha.delete();

    }

    public void catchFail() throws InterruptedException{
        Picture fail = new Picture(65,320,"fail.png");
        pokeball.grow(30,30);
        pokeball.load("pokeball5.png");
        pokeball.draw();
        Thread.sleep(300);
        pokeball.delete();
        fail.draw();
        Thread.sleep(500);
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