package org.academiadecodigo.bootcamp.Game.StagesPack;

import org.academiadecodigo.bootcamp.Game.GameScreens;
import org.academiadecodigo.bootcamp.Game.Pokemons.Pokes;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 19/02/2019.
 */
public abstract class Stages extends GameScreens{

    private Picture background;

    //pokemon list

    public void setUnlocked(boolean unlocked) {
        isUnlocked = unlocked;
    }

    public abstract boolean isDevoidOfPPokemon();

    public abstract void unlockPokemons();

    public abstract boolean isUnlocked();

    private boolean isUnlocked;

    public abstract void init();


    public abstract void drawStage();

    public abstract void hideStage();

    public abstract Pokes startPokemon();





}
