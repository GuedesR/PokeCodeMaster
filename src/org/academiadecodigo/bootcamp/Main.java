package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.Game.Menu;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

/**
 * Created by codecadet on 16/02/2019.
 */
public class Main {

    public static void main(String[] args) throws InterruptedException{

        Menu menu = new Menu();
        Exit e = new Exit();
        e.exit();
        menu.init();
    }

    public static class Exit implements KeyboardHandler{

        public void exit(){
            Keyboard keyboard = new Keyboard(this);

            KeyboardEvent event = new KeyboardEvent();
            event.setKey(KeyboardEvent.KEY_Q);
            event.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            keyboard.addEventListener(event);
        }



        @Override
        public void keyPressed(KeyboardEvent keyboardEvent) {
            if(keyboardEvent.getKey() == KeyboardEvent.KEY_Q){
                System.exit(0);
            }
        }

        @Override
        public void keyReleased(KeyboardEvent keyboardEvent) {

        }
    }
}
