package org.academiadecodigo.bootcamp.Game;

import org.academiadecodigo.bootcamp.Game.Items.Pokeball;
import org.academiadecodigo.bootcamp.Game.Pokemons.PokeList;
import org.academiadecodigo.bootcamp.Game.StagesPack.*;
import org.academiadecodigo.bootcamp.Game.UtilitiesPack.Copa;
import org.academiadecodigo.bootcamp.Game.UtilitiesPack.NoPokemonScreen;
import org.academiadecodigo.bootcamp.Game.UtilitiesPack.PingPong;
import org.academiadecodigo.bootcamp.Game.UtilitiesPack.Utilities;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 19/02/2019.
 * <p>
 * Instantiate all the backgrounds and shows them in a switch case with the 1,2,3,4,5,6 keys
 */
public class Corridor implements MouseHandler {

    //Instantiate backgrounds
    private Stages currentStage;
    private Utilities nopokemon = new NoPokemonScreen();
    private Stages attic = new Attic();
    private Stages base = new Base();
    private Stages unicornios = new Unicornios();
    private Utilities pingPong = new PingPong();
    private Utilities copa = new Copa();
    private Utilities varanda = new Varanda();
    private Stages easterEgg = new EasterEgg();
    Music music;
    PlayerScreen playerScreen;
    private GameScreens stages;
    private Picture varandaLock=new Picture(90,325,"lock.png");
    private Picture copaLock=new Picture(90,400,"lock.png");
    private Picture pingpongLock=new Picture(90,475,"lock.png");
    private Picture unicorniosLock=new Picture(90,550,"lock.png");

    Rectangle highligth = new Rectangle(40, 180, 100, 100);
    ;
    private PokeList pokeList = new PokeList();


    private Picture corridor = new Picture(10, 10, "corridor.png");
    Mouse m = new Mouse(this);

    private boolean stageIsOngoing = false;

    //chooses witch corridor to show

    public Corridor() throws InterruptedException {
        music = new Music();
        music.musicplay("music");

        corridor.draw();
        System.out.println("Corredor woop woop!");
        boolean bool;



        m.addEventListener(MouseEventType.MOUSE_CLICKED);

        m.addEventListener(MouseEventType.MOUSE_MOVED);



        while (true) {
            System.out.print("");
            if (stageIsOngoing) {
                System.out.println("New Stage!!!!!!!!!!");
                if (stages instanceof Stages) {
                    stages.drawStage();
                    playerScreen = new PlayerScreen();
                    bool = playerScreen.init(currentStage.startPokemon(),this);
                    if (bool) {
                        stages.hideStage();
                        m.addEventListener(MouseEventType.MOUSE_CLICKED);
                        m.addEventListener(MouseEventType.MOUSE_MOVED);
                    }
                    stageIsOngoing = false;
                } else {
                    stages.drawStage();
                    bool = stages.action();
                    if (bool) {
                        stages.hideStage();
                        m.addEventListener(MouseEventType.MOUSE_CLICKED);
                        m.addEventListener(MouseEventType.MOUSE_MOVED);
                    }
                    stageIsOngoing = false;
                }
            }
        }


    }

    public Stages getBase(){
        return base;
    }
    public Stages getAttic(){
        return attic;
    }
    public Stages getUnicornios(){
        return unicornios;
    }

    public GameScreens getStages() {
        return stages;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        System.out.println(mouseEvent.getY() + " : Y corr");
        System.out.println(mouseEvent.getX() + " : X corr");

        if (mouseEvent.getY() > 190 && mouseEvent.getY() < 270 && Pokeball.getCurrentAmount()>0) {
            //Go to base
            copa.setUnlocked();
            varanda.setUnlocked();
            pingPong.setUnlocked();
            if(!base.isDevoidOfPPokemon()) {
                stages = base;
                currentStage = base;
                stageIsOngoing = true;
                m.removeEventListener(MouseEventType.MOUSE_CLICKED);
                m.removeEventListener(MouseEventType.MOUSE_MOVED);
            }else{
                stages = nopokemon;
                stageIsOngoing = true;
                m.removeEventListener(MouseEventType.MOUSE_CLICKED);
                m.removeEventListener(MouseEventType.MOUSE_MOVED);
            }

        }
        if (mouseEvent.getY() > 270 && mouseEvent.getY() < 350 && Pokeball.getCurrentAmount()>0) {
            //Go to attic
            copa.setUnlocked();
            varanda.setUnlocked();
            pingPong.setUnlocked();
            if(!attic.isDevoidOfPPokemon()) {
                stages = attic;
                currentStage = attic;
                stageIsOngoing = true;
                m.removeEventListener(MouseEventType.MOUSE_CLICKED);
                m.removeEventListener(MouseEventType.MOUSE_MOVED);
            }else{
                stages = nopokemon;
                stageIsOngoing = true;
                m.removeEventListener(MouseEventType.MOUSE_CLICKED);
                m.removeEventListener(MouseEventType.MOUSE_MOVED);
            }

        }
        if ((mouseEvent.getY() > 490 && mouseEvent.getY() < 560) && pingPong.isUnlocked()) {
            //Go to pingpong
            System.out.println("PINGPONG");
            System.out.println(Pokeball.getCurrentAmount());
            stages = pingPong;
            Pokeball.addCurrentAmount(5);
            stageIsOngoing = true;
            m.removeEventListener(MouseEventType.MOUSE_CLICKED);
            m.removeEventListener(MouseEventType.MOUSE_MOVED);
        }
        if (mouseEvent.getY() > 420 && mouseEvent.getY() < 490 && copa.isUnlocked()) {
            //Go to copa
            stages = copa;
            stageIsOngoing = true;
            m.removeEventListener(MouseEventType.MOUSE_CLICKED);
            m.removeEventListener(MouseEventType.MOUSE_MOVED);
        }
        if (mouseEvent.getY() > 350 && mouseEvent.getY() < 420 && varanda.isUnlocked()) {
            //Go to varanda
            stages = varanda;
            base.unlockPokemons();
            attic.unlockPokemons();
            stageIsOngoing = true;
            m.removeEventListener(MouseEventType.MOUSE_CLICKED);
            m.removeEventListener(MouseEventType.MOUSE_MOVED);
        }
        if (mouseEvent.getY() > 560 && mouseEvent.getY() < 624 && Pokeball.getCurrentAmount()>0 && base.allCaptured() && attic.allCaptured()) {
            //Go to unicornios
            System.out.println("Unicornios");
            if(!unicornios.isDevoidOfPPokemon()) {
                stages = unicornios;
                currentStage = unicornios;
                stageIsOngoing = true;
                m.removeEventListener(MouseEventType.MOUSE_CLICKED);
                m.removeEventListener(MouseEventType.MOUSE_MOVED);
            }else{
                stages = nopokemon;
                stageIsOngoing = true;
                m.removeEventListener(MouseEventType.MOUSE_CLICKED);
                m.removeEventListener(MouseEventType.MOUSE_MOVED);
            }
        }
        if(mouseEvent.getY() > 650 && mouseEvent.getY() < 725 &&
                mouseEvent.getX() > 325 && mouseEvent.getX() < 430 &&
                base.allCaptured() && attic.allCaptured() && unicornios.allCaptured()){
            music.stop();
            music.musicplay("e");
            //Go to easter egg
            System.out.println("Easter Egg");
            stages=easterEgg;
            currentStage=easterEgg;
            stageIsOngoing=true;
            m.removeEventListener(MouseEventType.MOUSE_CLICKED);
            m.removeEventListener(MouseEventType.MOUSE_MOVED);
        }

    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

        if (mouseEvent.getY() > 420 && mouseEvent.getY() < 490 && !copa.isUnlocked() && !stageIsOngoing) {
            //show copa locked
            copaLock.draw();
            varandaLock.delete();
            pingpongLock.delete();
            unicorniosLock.delete();
        }
        else if (mouseEvent.getY() > 350 && mouseEvent.getY() < 420 && !varanda.isUnlocked() && !stageIsOngoing) {
            //show varanda locked
            varandaLock.draw();
            copaLock.delete();
            pingpongLock.delete();
            unicorniosLock.delete();
        }
        else if ((mouseEvent.getY() > 490 && mouseEvent.getY() < 560) && !pingPong.isUnlocked() && !stageIsOngoing) {
            //show pingpong locked
            pingpongLock.draw();
            varandaLock.delete();
            copaLock.delete();
            unicorniosLock.delete();
        }
        else if (mouseEvent.getY() > 560 && mouseEvent.getY() < 624 && !base.allCaptured() && !attic.allCaptured() && !stageIsOngoing) {
            //show unicornios locked
            unicorniosLock.draw();
            varandaLock.delete();
            copaLock.delete();
            pingpongLock.delete();
        }
        else {
            varandaLock.delete();
            copaLock.delete();
            pingpongLock.delete();
            unicorniosLock.delete();
        }

    }
}
