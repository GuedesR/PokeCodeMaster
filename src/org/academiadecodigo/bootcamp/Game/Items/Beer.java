package org.academiadecodigo.bootcamp.Game.Items;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

/**
 * Created by codecadet on 23/02/2019.
 */
public class Beer {
    private static Rectangle beer;
    private static int currentAmount = 0;

    public static void show(){
        beer = new Rectangle(85,100,100,200);
        beer.setColor(Color.WHITE);
        beer.fill();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
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
