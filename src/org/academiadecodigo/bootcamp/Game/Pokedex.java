package org.academiadecodigo.bootcamp.Game;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Pokedex {

    private static Rectangle backGround;
    private static boolean opened = false;

    public static void show(){
        backGround = new Rectangle(85,100,370,500);
        backGround.setColor(Color.WHITE);
        backGround.fill();
        opened = true;
        System.out.println("bag initializesd");
    }

    public static void hide(){
        backGround.delete();
        opened = false;
    }

    public static boolean isOpened(){
        return opened;
    }
}
