package org.academiadecodigo.bootcamp.Game.StagesPack;

import org.academiadecodigo.bootcamp.Game.Pokemons.PokeList;
import org.academiadecodigo.bootcamp.Game.Pokemons.Pokes;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 20/02/2019.
 */
public class Unicornios extends Stages {

    private Picture background = new Picture(10, 10, "bg3.jpg");
    private boolean isUnlocked = false;
    private PokeList pokeList = new PokeList();
    private Pokes[] pokes;


    @Override
    public boolean isDevoidOfPPokemon() {

        //TODO:CENAS
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
        if (count < 2) {
            while (true) {
                int random = (int) Math.floor(Math.random() * 2) + 7;

                if (!pokes[random].isCaptured()) {
                    Pokes poke = pokes[random];
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
