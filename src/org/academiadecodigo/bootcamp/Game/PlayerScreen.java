package org.academiadecodigo.bootcamp.Game;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.bootcamp.Game.Pokemons.Pokes;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.simplegraphics.graphics.Ellipse;


/**
 * --Player Screen--
 *
 * Novo nome de CatchScreen
 * Uma vez que este vai ser onde se vai colocar todas as opções do Jogador não só apanhar.
 */
public class PlayerScreen implements KeyboardHandler, MouseHandler {

    private Picture backGround;
    private Background bG;
    private boolean isChangeScreen=false;
    private boolean caught=false;
    private Pokeball ball;
    private Ellipse pokedexBtn;
    private String remainingBalls = Integer.toString(Pokeball.getCurrentAmount());
    private Ellipse remainingBallsBtn;
    private Text remainingBallsNum;
    private Ellipse beerBtn;
    private Text remainingBeersNum;
    private Ellipse escapeBtn;


    public boolean init(Pokes pokemon)  throws InterruptedException {

        int yPokeCoord=100;
        PokePlacement pokePlacement= null;




        Keyboard keyboard = new Keyboard(this);

        KeyboardEvent wPressed = new KeyboardEvent();
        wPressed.setKey(KeyboardEvent.KEY_W);
        wPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(wPressed);

        Mouse mouse = new Mouse(this);

        mouse.addEventListener(MouseEventType.MOUSE_MOVED);
        mouse.addEventListener(MouseEventType.MOUSE_CLICKED);


        while (!isChangeScreen) {
            isChangeScreen=false;


            pokedexBtn = new Ellipse(30, 290, 40,40);
            pokedexBtn.setColor(Color.LIGHT_GRAY);
            pokedexBtn.fill();

            remainingBallsBtn = new Ellipse(30, 340, 40,40);
            remainingBallsBtn.setColor(Color.LIGHT_GRAY);
            remainingBallsBtn.fill();

            remainingBallsNum = new Text(60, 375, Integer.toString(Pokeball.getCurrentAmount()));
            remainingBallsNum.setColor(Color.BLACK);
            remainingBallsNum.grow(5,5);
            remainingBallsNum.draw();

            beerBtn = new Ellipse(30, 390, 40,40);
            beerBtn.setColor(Color.LIGHT_GRAY);
            beerBtn.fill();

            remainingBeersNum = new Text(60, 425, "1");
            remainingBeersNum.setColor(Color.BLACK);
            remainingBeersNum.grow(5,5);
            remainingBeersNum.draw();

            escapeBtn = new Ellipse(30, 440, 40,40);
            escapeBtn.setColor(Color.LIGHT_GRAY);
            escapeBtn.fill();

            if(!caught) {
                pokePlacement = new PokePlacement();
                yPokeCoord = pokePlacement.init(pokemon);

            }



            //ball = new Pokeball();
            //ball.show();

            while (!caught && Pokeball.getCurrentAmount() > 0) {
                ball = new Pokeball();
                ball.init();
                ball.setPos(2);
                System.out.println(" CENAS");
                //ball.reset();

                KeyboardEvent leftPressed = new KeyboardEvent();
                leftPressed.setKey(KeyboardEvent.KEY_LEFT);
                leftPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
                keyboard.addEventListener(leftPressed);

                KeyboardEvent rightPressed = new KeyboardEvent();
                rightPressed.setKey(KeyboardEvent.KEY_RIGHT);
                rightPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
                keyboard.addEventListener(rightPressed);


                ThrowingBar throwingBar = new ThrowingBar();
                int barStrength = throwingBar.init();
                System.out.println("  -  " + barStrength + "    ..   ");

                if (barStrength > 6) {
                    barStrength = 1;//closer
                } else if (barStrength > 3) {
                    barStrength = 2;
                } else {
                    barStrength = 3;//farthest
                }

                System.out.println(barStrength);
                int pos = ball.throwP(barStrength);


                System.out.println(barStrength + "  -  " + pokePlacement.getY());
                System.out.println(pos + "  _  " + pokePlacement.getX());

                if (barStrength == pokePlacement.getY() && pos == pokePlacement.getX()) {
                    System.out.println("----__---HIT---__----");
                    pokePlacement.hidePokemon();
                    if(((int)(Math.random()*10)+1)<pokePlacement.getCatchRate()) {
                        ball.hit(3);                                //---Se conseguir apanhar, vai repetir o movimento 3x
                        ball.catchSuccess();
                        pokePlacement.caught();                                       //deletes pokemon
                        hideUI();
                        caught = true;
                        return true;
                    } else {
                        pokePlacement.hidePokemon();
                        ball.hit(2);                                //---Se o pokemon resistir só repete o movimento 2x
                        ball.catchFail();
                        pokePlacement.showPokemon();
                        ball.hidePokeball();
                        keyboard.removeEventListener(leftPressed);
                        keyboard.removeEventListener(rightPressed);

                    }
                } else {
                    remainingBallsNum.setText(Integer.toString(Pokeball.getCurrentAmount()));
                    System.out.println("____--__FAIL___--____");
                    ball.hidePokeball();
                    caught = false;
                    keyboard.removeEventListener(leftPressed);
                    keyboard.removeEventListener(rightPressed);

                }

                if(Pokeball.getCurrentAmount() == 0){
                    pokePlacement.hidePokemon();
                    caught=true;
                    hideUI();
                    return true;
                }

            }
        }
        System.out.println("Something went terribly wrong");

        return false;
    }

    public void hideUI(){
        pokedexBtn.delete();
        remainingBallsBtn.delete();
        remainingBallsNum.delete();
        beerBtn.delete();
        remainingBeersNum.delete();
        escapeBtn.delete();
    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_W) {
            // bG.stageInc();
            System.out.println("W pressed ");
            isChangeScreen=true;
        }

        if(keyboardEvent.getKey() == KeyboardEvent.KEY_LEFT){
            //System.out.println("LEFT POKE X: " + ball.getX());
            ball.moveBallLeft();
            System.out.println("Left pressed");
        }

        if(keyboardEvent.getKey() == KeyboardEvent.KEY_RIGHT){
            //System.out.println("RIGHT POKE X: " + ball.getX());
            ball.moveBallRight();
            System.out.println("Right pressed");
        }


    }


    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        Double mouseX = mouseEvent.getX();
        Double mouseY = mouseEvent.getY();

        System.out.println("Mouse X: " + mouseX);
        System.out.println("Mouse Y: " + mouseY);


        if(mouseX > 30 && mouseX < 70 && mouseY > 320 && mouseY < 360){
            if(!Pokedex.isOpened()){
                Pokedex.show();
            }else {
                Pokedex.hide();
            }
        }
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }
}