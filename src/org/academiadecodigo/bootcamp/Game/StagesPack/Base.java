package org.academiadecodigo.bootcamp.Game.StagesPack;

import org.academiadecodigo.bootcamp.Game.Corridor;
import org.academiadecodigo.bootcamp.Game.Menu;
import org.academiadecodigo.bootcamp.Game.Pokemons.PokeList;
import org.academiadecodigo.bootcamp.Game.Pokemons.Pokes;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 20/02/2019.
 */
public class Base extends Stages {

    private Corridor corridor;

    private Picture background = new Picture(10,10,"bg.jpg");
    private boolean isUnlocked=true;
    private PokeList pokeList = new PokeList();
    private Pokes[] pokes;

    public Base() {
        pokes = new Pokes[4];
        for(int i = 0; i < 4; i++)
            pokes[i] = pokeList.getElement(i);
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
        int count = 0;
        if (count < 4){
            while(true) {
                int random = (int) Math.floor(Math.random() * 4);
                System.out.println(random);

                if (!pokes[random].isCaptured()) {
                    Pokes poke = pokes[random];
                    count++;
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
