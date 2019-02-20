package org.academiadecodigo.bootcamp.Game;

import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 16/02/2019.
 */
public class PokePlacement {

    private Picture pokemon;
    private int x=220; //poke on the middle
    private int y;
    private int catchRate=7;

    public int init(){


        int upDown=((int)(Math.random()*3)+1);

        switch (upDown){
            case 1: y=320;
                pokemon = new Picture(x,y,"pika.png");
                pokemon.grow(-20,-20);
                y = 3;
                break;
            case 2: y=420;
                pokemon = new Picture(x,y,"pika.png");
                pokemon.grow(-10,-10);
                y = 2;
                break;
            default:y=520;
                pokemon = new Picture(x,y,"pika.png");
                y = 1;
                break;
        }

        int leftRight=((int)(Math.random()*3)+1);

        switch (leftRight){
            case 1: x=110;
                pokemon.translate(-110,0);
                x=1;
                break;
            case 2: x=220;
                x=2;
                break;
            default: x=330;
                pokemon.translate(110,0);
                x=3;
                break;
        }



        pokemon.draw();
        return upDown;
    }

    public void caught(){
        pokemon.delete();
    }

    public int getY(){
        return y;
    }

    public int getX() {
        return x;
    }

    public int getCatchRate(){
        return catchRate;
    }

    public void hidePokemon(){
        pokemon.delete();
    }

    public void showPokemon(){
        pokemon.draw();
    }
}