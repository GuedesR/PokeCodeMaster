package org.academiadecodigo.bootcamp.Game.StagesPack;

import org.academiadecodigo.bootcamp.Game.Pokemons.PokeList;
import org.academiadecodigo.bootcamp.Game.Pokemons.Pokes;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class EasterEgg extends Stages {

    private Picture background = new Picture(10,10,"bg.jpg");
    private boolean isUnlocked=false;
    private PokeList pokeList = new PokeList();
    private Pokes pokes;
    private boolean[] baseDex = new boolean[1];

    public EasterEgg(){
        pokes = pokeList.getElement(8);
    }

    @Override
    public boolean allCaptured() {
        return pokes.isCaptured();
    }

    @Override
    public boolean[] dex() {
        return new boolean[0];
    }

    @Override
    public boolean isDevoidOfPPokemon() {
        return pokes.isCaptured();
    }

    @Override
    public void unlockPokemons() {
        pokes.unlock();
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
    public void setUnlocked() {
        isUnlocked = true;
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
}
