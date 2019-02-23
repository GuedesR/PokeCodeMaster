package org.academiadecodigo.bootcamp.Game.Items;

import org.academiadecodigo.bootcamp.Game.Corridor;
import org.academiadecodigo.bootcamp.Game.StagesPack.Stages;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Pokedex {

    private static Rectangle backGround;
    private static boolean opened = false;
    private static Rectangle poke1;
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
        backGround = new Rectangle(85,100,370,500);
        backGround.setColor(Color.WHITE);
        backGround.fill();

        for(int i=0; i<baseDex.length; i++){
            System.out.println(baseDex[i]);
        }

        opened = true;
        System.out.println("pokedex initialized");

        poke1 = new Rectangle(120, 145, 100, 100);
        poke1.setColor(Color.DARK_GRAY);
        poke1.fill();

    }

    public static void hide(){
        backGround.delete();
        opened = false;
    }

    public static boolean isOpened(){
        return opened;
    }
}
