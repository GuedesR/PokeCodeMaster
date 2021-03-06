package org.academiadecodigo.bootcamp.Game.Pokemons;

import org.academiadecodigo.bootcamp.Game.Pokemons.Pokes;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 16/02/2019.
 */
public class PokePlacement {

    private Picture pokemonPicture;
    private int x=150; //poke on the middle
    private int y;
    private Pokes pokemon;
    private String [] imageNameWithExt;
    private String imageName;



    public int init(Pokes pokemon){

        this.pokemon = pokemon;
        int verticalPlacement=((int)(Math.random()*3)+1);

        imageNameWithExt = pokemon.getImageName().split("\\.");
        imageName = imageNameWithExt[0];

        System.out.println(imageName);

        switch (verticalPlacement){
            case 1: y=220;
                pokemonPicture = new Picture (x, y, pokemon.getImageName());
                pokemonPicture.grow(-20,-20);
                pokemonPicture.translate(10,10);
                y = 3;
                break;
            case 2: y=350;
                pokemonPicture = new Picture(x, y, pokemon.getImageName());
                pokemonPicture.grow(-10,-10);
                pokemonPicture.translate(5,5);
                y = 2;
                break;
            default:y=470;
                pokemonPicture = new Picture(x, y, pokemon.getImageName());
                y = 1;
                break;
        }

        int horizontalPlacement=((int)(Math.random()*3)+1);

        switch (horizontalPlacement){
            case 1: x=70;
                pokemonPicture.translate(-110,0);
                x=1;
                break;
            case 2: x=150;
                x=2;
                break;
            default: x=230;
                pokemonPicture.translate(110,0);
                x=3;
                break;
        }
        pokemonPicture.draw();
        return verticalPlacement;
    }

    public Picture getPokemonPicture() {
        return pokemonPicture;
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