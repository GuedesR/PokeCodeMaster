package org.academiadecodigo.bootcamp.Game;

import org.academiadecodigo.simplegraphics.pictures.Picture;

// 1 - When you’re on the corridor use your mouse
// to click on the stage you want to go to.

// 2 - To catch a Pokémon, use the left and right keys and
// the space bar to throw the ball the distance you want.

// Press S to start the game.

public class Rules {

    Picture rulesOne = new Picture(10, 10, "bg3.jpg");

    public void showRules() {

        rulesOne.draw();

        try {
            Thread.sleep(200);

        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
