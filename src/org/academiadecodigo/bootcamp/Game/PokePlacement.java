package org.academiadecodigo.bootcamp.Game;

import org.academiadecodigo.bootcamp.Game.Pokemons.Pokes;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 16/02/2019.
 */
public class PokePlacement {

    private Picture pokemonPicture;
    private int x=220; //poke on the middle
    private int y;
    private Pokes pokemon;
    private String [] imageNameWithExt;
    private String imageName;



    public int init(Pokes pokemon){

        this.pokemon = pokemon;
        int upDown=((int)(Math.random()*3)+1);

        imageNameWithExt = pokemon.getImageName().split("\\.");
        imageName = imageNameWithExt[0];

        System.out.println(imageName);

        switch (upDown){
            case 1: y=265;
                pokemonPicture = new Picture (x, y, pokemon.getImageName());
                pokemonPicture.grow(-20,-20);
                pokemonPicture.translate(10,10);
                y = 3;
                break;
            case 2: y=400;
                pokemonPicture = new Picture(x, y, pokemon.getImageName());
                pokemonPicture.grow(-10,-10);
                pokemonPicture.translate(5,5);
                y = 2;
                break;
            default:y=505;
                pokemonPicture = new Picture(x, y, pokemon.getImageName());
                y = 1;
                break;
        }

        int leftRight=((int)(Math.random()*3)+1);

        switch (leftRight){
            case 1: x=110;
                pokemonPicture.translate(-110,0);
                x=1;
                break;
            case 2: x=220;
                x=2;
                break;
            default: x=330;
                pokemonPicture.translate(110,0);
                x=3;
                break;
        }



        pokemonPicture.draw();
        return upDown;
    }

    public void drunkImage(){
        pokemonPicture.load(imageName+"D.png");
        pokemonPicture.draw();
    }

    public void caught(){
        pokemonPicture.delete();
    }

    public int getY(){
        return y;
    }

    public int getX() {
        return x;
    }

    public int getCatchRate(){
        return pokemon.getCatchRate();
    }

    public void hidePokemon(){
        pokemonPicture.delete();
    }

    public void showPokemon(){
        pokemonPicture.draw();
    }
}