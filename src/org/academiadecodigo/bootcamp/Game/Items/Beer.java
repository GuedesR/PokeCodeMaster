package org.academiadecodigo.bootcamp.Game.Items;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

/**
 * Created by codecadet on 23/02/2019.
 */
public class Beer {
    private static Rectangle beer;
    private static int currentAmount = 5;

    public static void show(){
        beer = new Rectangle(300,300,100,200);
        beer.setColor(Color.DARK_GRAY);
        beer.fill();
        currentAmount--;

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            System.out.println("só que não");
        }

        hide();

        System.out.println("Drank Beer");
    }

    public static void addBeer(int addAmount){
        currentAmount += addAmount;
    }

    public static void removeBeer(){
        currentAmount--;
    }

    public static int getCurrentAmount() {
        return currentAmount;
    }

    public static void hide(){
        beer.delete();
    }

}
