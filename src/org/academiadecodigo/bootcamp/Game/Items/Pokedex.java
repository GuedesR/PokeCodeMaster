package org.academiadecodigo.bootcamp.Game.Items;

import org.academiadecodigo.bootcamp.Game.Corridor;
import org.academiadecodigo.bootcamp.Game.Pokemons.PokeList;
import org.academiadecodigo.bootcamp.Game.Pokemons.Pokes;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Pokedex {

    private static Rectangle backGround;
    private static boolean opened = false;

    private static Picture sergio = new Picture();
    private static Picture mariana;
    private static Picture christina;
    private static Picture benny;
    private static Picture rolo;
    private static Picture sara;
    private static Picture audrey;
    private static Picture catarina;
    private static Picture ferrao;
    private static boolean[] dex = new boolean[9];
    private static boolean[] baseDex = new boolean[4];
    private static boolean[] atticDex = new boolean[3];
    private static boolean[] unicorniosDex = new boolean[2];

    public static void refreshDex(Corridor corridor) {
        baseDex = corridor.getBase().dex();
        atticDex = corridor.getAttic().dex();
        unicorniosDex = corridor.getUnicornios().dex();

        if (baseDex[0]){
            sergio.load("sergioP.png");
            sergio.draw();
        }

        if (baseDex[1]){
            mariana.load("marianaP.png");
            mariana.draw();
        }

        if (baseDex[2]){
            christina.load("christinaP.png");
            christina.draw();
        }

        if (baseDex[3]){
            benny.load("bennyP.png");
            benny.draw();
        }

        if (atticDex[0]){
            rolo.load("roloP.png");
            rolo.draw();
        }

        if (atticDex[1]){
            sara.load("saraP.png");
            sara.draw();
        }

        if (atticDex[2]){
            audrey.load("audreyP.png");
            audrey.draw();
        }

        if (unicorniosDex[0]){
            ferrao.load("ferraoP.png");
            ferrao.draw();
        }

    }

    public static void putInDex(int dexNum) {
        dex[dexNum] = true;
    }

    public static void show() {
        backGround = new Rectangle(85, 100, 360, 360);
        backGround.setColor(Color.WHITE);
        backGround.fill();

        for (int i = 0; i < baseDex.length; i++) {
            System.out.println(baseDex[i]);
        }

        System.out.println("pokedex initialized");

        sergio = new Picture(110, 125, "sergio copy.png");
        sergio.draw();

        mariana = new Picture(220, 125, "mariana copy.png");
        mariana.draw();

        christina = new Picture(330, 125, "christina copy.png");
        christina.draw();

        benny = new Picture(110, 235, "benny copy.png");
        benny.draw();

        rolo = new Picture(220, 235, "rolo copy.png");
        rolo.draw();

        sara = new Picture(330, 235, "sara copy.png");
        sara.draw();

        audrey = new Picture(110, 345, "audrey copy.png");
        audrey.draw();

        ferrao = new Picture(220, 345, "ferrao copy.png");
        ferrao.draw();

        opened = true;

    }

    public static void hide() {
        backGround.delete();
        sergio.delete();
        mariana.delete();
        christina.delete();
        benny.delete();
        rolo.delete();
        sara.delete();
        audrey.delete();
        ferrao.delete();

        opened = false;
    }

    public static boolean isOpened() {
        return opened;
    }
}
