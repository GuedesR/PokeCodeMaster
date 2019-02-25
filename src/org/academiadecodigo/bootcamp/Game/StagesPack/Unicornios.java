package org.academiadecodigo.bootcamp.Game.StagesPack;

import org.academiadecodigo.bootcamp.Game.Pokemons.PokeList;
import org.academiadecodigo.bootcamp.Game.Pokemons.Pokes;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 20/02/2019.
 */
public class Unicornios extends Stages {

    private Picture background = new Picture(10, 10, "uni.jpg");
    private boolean isUnlocked = false;
    private PokeList pokeList = new PokeList();
    private Pokes pokes;
    private boolean[]uniDex = new boolean[1];


    public Unicornios(){
        pokes = pokeList.getElement(7);
        pokes.unlock();
    }

    @Override
    public boolean allCaptured() {
        return pokes.isCaptured();
    }

    @Override
    public boolean[] dex(){
        uniDex[0]=pokes.isCaptured();
        return uniDex;
    }


    @Override
    public boolean isDevoidOfPPokemon() {

        if(pokes.isCaptured() || !pokes.isUnlocked()){
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
        //TODO:CENAS
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
        if (count < 1) {
            while (true) {
                if (!pokes.isCaptured()) {
                    Pokes poke = pokes;
                    count++;
                    return poke;
                }
            }
        }
        return null;
    }

    public void setUnlocked(){
        isUnlocked=true;
    }
}
