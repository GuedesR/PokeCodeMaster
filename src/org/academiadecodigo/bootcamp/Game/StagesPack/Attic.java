package org.academiadecodigo.bootcamp.Game.StagesPack;

import org.academiadecodigo.bootcamp.Game.Pokemons.PokeList;
import org.academiadecodigo.bootcamp.Game.Pokemons.Pokes;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 19/02/2019.
 */
public class Attic extends Stages {

    private Picture background = new Picture(10,10,"bg2.jpg");
    private boolean isUnlocked=true;
    private PokeList pokeList = new PokeList();
    private Pokes[] pokes;
    private boolean[] atticDex = new boolean[3];

    public Attic(){
        pokes = new Pokes[3];
        //for(int i = 4; i < 7; i++) {
        int i = 4;
            for(int j=0;j<3;j++) {
                pokes[j] = pokeList.getElement(i + j);
            }
        //}
    }

    @Override
    public boolean allCaptured() {
        if(pokes[0].isCaptured() && pokes[1].isCaptured() && pokes[2].isCaptured()){
            return true;
        }
        return false;
    }

    @Override
    public boolean[] dex(){
        atticDex[0]=pokes[0].isCaptured();
        atticDex[1]=pokes[1].isCaptured();
        atticDex[2]=pokes[2].isCaptured();
        return atticDex;
    }

    @Override
    public boolean isDevoidOfPPokemon() {

         if((pokes[0].isCaptured() || !pokes[0].isUnlocked()) && (pokes[1].isCaptured() || !pokes[1].isUnlocked()) &&
                (pokes[2].isCaptured() || !pokes[2].isUnlocked())){
            return true;
        }
        return false;
    }

    @Override
    public boolean action() {
        return false;
    }

    @Override
    public void unlockPokemons() {
        for(int i = 0; i < pokes.length; i++) {
            pokes[i].unlock();
        }
    }

    @Override
    public boolean isUnlocked() {
        return isUnlocked;
    }

    @Override
    public void init() {
        drawStage();


    }

    @Override
    public void drawStage() {
        background.draw();

    }

    @Override
    public void hideStage() {
        background.delete();

    }

    @Override
    public Pokes startPokemon() {
        int count = 0;
        if(count < 3) {
            while(true) {
                int random = (int) Math.floor(Math.random() * 3);
                System.out.println(random);

                if (!(pokes[random].isCaptured()) && pokes[random].isUnlocked()) {
                    Pokes poke = pokes[random];
                    return poke;
                }

            }
        }
        return null;
    }

    @Override
    public void setUnlocked(){
        isUnlocked=true;
    }
}
