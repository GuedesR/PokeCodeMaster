package org.academiadecodigo.bootcamp.Game.StagesPack;

import org.academiadecodigo.bootcamp.Game.Corridor;
import org.academiadecodigo.bootcamp.Game.Pokemons.PokeList;
import org.academiadecodigo.bootcamp.Game.Pokemons.Pokes;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 20/02/2019.
 */
public class Base extends Stages {

    private Corridor corridor = new Corridor();

    private Picture background = new Picture(10,10,"bg.jpg");
    private boolean isUnlocked=true;
    private Pokes[] pokeList = corridor.getList();

    public Base() throws InterruptedException {
    }


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
        int random = (int) Math.floor(Math.random() * 4);

        if(!pokeList[random].isCaptured()){
            Pokes poke = pokeList[random];
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
