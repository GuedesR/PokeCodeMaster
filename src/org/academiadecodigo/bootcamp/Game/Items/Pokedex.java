package org.academiadecodigo.bootcamp.Game.Items;

import org.academiadecodigo.bootcamp.Game.Corridor;
import org.academiadecodigo.bootcamp.Game.Pokemons.PokeList;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Pokedex {

    private static Rectangle backGround;
    private static boolean opened = false;
    private static Rectangle sergio;
    private static Rectangle mariana;
    private static Rectangle christina;
    private static Rectangle benny;
    private static Rectangle rolo;
    private static Rectangle sara;
    private static Rectangle audrey;
    private static Rectangle catarina;
    private static Rectangle ferrao;
    private static boolean[] dex = new boolean[9];
    private static boolean[] baseDex = new boolean[4];
    private static boolean[] atticDex = new boolean[3];
    private static boolean[] unicorniosDex = new boolean[2];

    public static void refreshDex(Corridor corridor){
        baseDex=corridor.getBase().dex();
        atticDex=corridor.getAttic().dex();
        unicorniosDex=corridor.getUnicornios().dex();

    }

    public static void putInDex(int dexNum){
        dex[dexNum]=true;
    }

    public static void show(){
        backGround = new Rectangle(85,100,360,360);
        backGround.setColor(Color.WHITE);
        backGround.fill();

        for(int i=0; i<baseDex.length; i++){
            System.out.println(baseDex[i]);
        }

        opened = true;
        System.out.println("pokedex initialized");

        sergio = new Rectangle(110, 125, 90, 90);
        sergio.setColor(Color.DARK_GRAY);
        sergio.fill();

        mariana = new Rectangle(220, 125, 90, 90);
        mariana.setColor(Color.DARK_GRAY);
        mariana.fill();

        christina = new Rectangle(330, 125, 90, 90);
        christina.setColor(Color.DARK_GRAY);
        christina.fill();

        benny = new Rectangle(110, 235, 90, 90);
        benny.setColor(Color.DARK_GRAY);
        benny.fill();

        rolo = new Rectangle(220, 235, 90, 90);
        rolo.setColor(Color.DARK_GRAY);
        rolo.fill();

        sara = new Rectangle(330, 235, 90, 90);
        sara.setColor(Color.DARK_GRAY);
        sara.fill();

        audrey = new Rectangle(110, 345, 90, 90);
        audrey.setColor(Color.DARK_GRAY);
        audrey.fill();

    }

    public static void hide(){
        backGround.delete();
        sergio.delete();
        mariana.delete();
        christina.delete();
        benny.delete();
        rolo.delete();
        sara.delete();
        audrey.delete();
        catarina.delete();
        ferrao.delete();

        opened = false;
    }

    public static boolean isOpened(){
        return opened;
    }
}
