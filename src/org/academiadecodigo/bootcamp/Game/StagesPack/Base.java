package org.academiadecodigo.bootcamp.Game.StagesPack;

import org.academiadecodigo.bootcamp.Game.Corridor;
import org.academiadecodigo.bootcamp.Game.Menu;
import org.academiadecodigo.bootcamp.Game.Pokemons.PokeList;
import org.academiadecodigo.bootcamp.Game.Pokemons.Pokes;
import org.academiadecodigo.simplegraphics.pictures.Picture;


public class Base extends Stages {

    private Corridor corridor;

    private Picture background = new Picture(10,10,"bg.jpg");
    private boolean isUnlocked=true;
    private PokeList pokeList = new PokeList();
    private Pokes[] pokes;
    private boolean[] baseDex = new boolean[4];

    public Base() {
        pokes = new Pokes[4];
        for(int i = 0; i < 4; i++) {
            pokes[i] = pokeList.getElement(i);
        }
    }


    @Override
    public boolean allCaptured() {
        if(pokes[0].isCaptured() && pokes[1].isCaptured() && pokes[2].isCaptured() && pokes[3].isCaptured()){
            return true;
        }
        return false;
    }

    @Override
    public boolean[] dex(){
        baseDex[0]=pokes[0].isCaptured();
        baseDex[1]=pokes[1].isCaptured();
        baseDex[2]=pokes[2].isCaptured();
        baseDex[3]=pokes[3].isCaptured();
        return baseDex;
    }



    @Override
    public boolean isDevoidOfPPokemon() {

        if((pokes[0].isCaptured() || !pokes[0].isUnlocked()) && (pokes[1].isCaptured() || !pokes[1].isUnlocked()) &&
                (pokes[2].isCaptured()|| !pokes[2].isUnlocked()) && (pokes[3].isCaptured()|| !pokes[3].isUnlocked())){
            return true;
        }
        return false;
    }

    @Override
    public void unlockPokemons(){
        for(int i = 0; i < 4; i++) {
            pokes[i].unlock();
        }
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

                if (!pokes[random].isCaptured() && pokes[random].isUnlocked()) {
                    Pokes poke = pokes[random];
                    count++;
                    return poke;
                }
                if((pokes[0].isCaptured() || !pokes[0].isUnlocked()) && (pokes[1].isCaptured() || !pokes[1].isUnlocked()) &&
                        (pokes[2].isCaptured()|| !pokes[2].isUnlocked()) && (pokes[3].isCaptured()|| !pokes[3].isUnlocked())){
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
