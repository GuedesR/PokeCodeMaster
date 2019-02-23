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

    public Attic(){
        pokes = new Pokes[3];
        for(int i = 4; i < 7; i++) {
            for(int j=0;j<3;j++) {
                pokes[j] = pokeList.getElement(i);
            }
        }
    }


    @Override
    public boolean action() {
        return false;
    }

    @Override
    public void unlockPokemons() {
        for(int i = 4; i < 7; i++) {
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
                int random = (int) Math.floor(Math.random() * 3) + 4;
                System.out.println(random);

                if (!pokes[random].isCaptured() && pokes[random].isUnlocked()) {
                    Pokes poke = pokes[random];
                    return poke;
                }
                if((pokes[4].isCaptured() || !pokes[4].isUnlocked()) && (pokes[5].isCaptured() || !pokes[5].isUnlocked()) &&
                        (pokes[6].isCaptured()|| !pokes[6].isUnlocked())){
                    Pokes poke = pokeList.getElement(9);//invisible pokemon
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
