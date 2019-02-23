package org.academiadecodigo.bootcamp.Game.Pokemons;

public class Pokes {

    private String name;
    private int catchRate;
    private boolean captured;
    private String imageName;
    private boolean isDrunk;

    public boolean isUnlocked() {
        return isUnlocked;
    }

    private boolean isUnlocked;

    public Pokes(Enum name, int catchRate, String imageName){
        this.name = name.toString();
        this.catchRate = catchRate;
        captured = false;
        this.imageName = imageName;
        isDrunk = false;
        isUnlocked = false;
    }

    public  void lock(){ isUnlocked = false;}
    public void unlock(){
        isUnlocked = true;
    }

    public String getImageName(){
        return imageName;
    }

    public boolean giveBeer(){
        if(!isDrunk){
            isDrunk = true;
            catchRate += 30;
            return true;
        }
        else{
            System.out.println("Already drunk");
            return false;
        }
    }
    public void undrunk(){isDrunk = false;}

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