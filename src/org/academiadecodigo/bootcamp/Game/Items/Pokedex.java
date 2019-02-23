package org.academiadecodigo.bootcamp.Game.Items;

import org.academiadecodigo.bootcamp.Game.Corridor;
import org.academiadecodigo.bootcamp.Game.StagesPack.Stages;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Pokedex {

    private static Rectangle backGround;
    private static boolean opened = false;
    private static Rectangle poke1;

    public static void show(){
        backGround = new Rectangle(85,100,370,500);
        backGround.setColor(Color.WHITE);
        backGround.fill();

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
