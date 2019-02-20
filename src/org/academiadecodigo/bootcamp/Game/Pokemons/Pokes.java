package org.academiadecodigo.bootcamp.Game.Pokemons;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Pokes {

    private String name;
    private int catchRate;
    private boolean captured;
    private Picture image;
    private boolean isDrunk;
    private boolean isUnlocked;


    public Pokes(Enum name, int catchRate, Picture image){
        this.name = name.toString();
        this.catchRate = catchRate;
        captured = false;
        this.image = image;
        isDrunk = false;
        isUnlocked = false;
    }

    public void unlock(){
        isUnlocked = true;
    }

    public boolean giveBeer(){
        if(!isDrunk){
            isDrunk = true;
            return true;
        }
        else{
            System.out.println("Already drunk");
            return false;
        }
    }

    public String getName(){return name;}
    public int getCatchRate(){return catchRate;}
    public boolean isCaptured(){
        return captured;
    }
    public void captured(){
        captured = true;
    }
    public boolean isDrunk() { return isDrunk; }
}