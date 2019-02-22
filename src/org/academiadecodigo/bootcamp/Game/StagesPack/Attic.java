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


    @Override
    public boolean action() {
        return false;
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
        int random = (int) Math.floor(Math.random() * 3) + 4;

        if(!pokes[random].isCaptured()){
            Pokes poke = pokes[random];
            return poke;
        }
        else
            return null;
    }

    @Override
    public void setUnlocked(){
        isUnlocked=true;
    }
}
