package org.academiadecodigo.bootcamp.Game.Pokemons;

import org.academiadecodigo.bootcamp.Game.Pokemons.Pokes;
import org.academiadecodigo.bootcamp.Game.Pokemons.Pokes;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class PokeList {

    private Pokes[] pokelist = new Pokes[names.values().length];

    public Pokes[] getList() {
        return pokelist;
    }
    public Pokes getElement(int i){
        return pokelist[i];
    }

    public void addToList(names name){
        int catchR = names.catchRate(name);
        Picture foto = names.imagem(name);
        int i = names.number(name);
        pokelist[i] = new Pokes(name, catchR, foto);
    }

    public void addToList(int i) {
        if (i < 0 || i > names.values().length) {
            System.out.println("Out of bounds");
            return;
        }
        int catchR = names.catchRate(names.values()[i]);
        Picture foto = names.imagem(names.values()[i]);
        pokelist[i] = new Pokes(names.values()[i], catchR, foto);

    }

    public enum names {
        // MasterCoders
        SERGIO (0),
        MARIANA (1),
        CHRISTINA (2),
        BENNY (3),

        ROLO (4),
        SARA (5),
        AUDREY (6),

        // FinalBosses
        CATARINA (7),
        FERRAO (8);

        int i;
        names(int i){
            this.i = i;
        }

        public static int number(names name){
            switch (name){
                case SERGIO:
                    return 0;
                case MARIANA:
                    return 1;
                case CHRISTINA:
                    return 2;
                case BENNY:
                    return 3;

                case ROLO:
                    return 4;
                case SARA:
                    return 5;
                case AUDREY:
                    return 6;
                case CATARINA:
                    return 7;
                case FERRAO:
                    return 8;
                default:
                    return -1;
            }
        }

        public static Picture imagem(names name) {
            switch (name) {
                case SERGIO:
                    return null; //new Picture(10, 10, "sergio.jpg");
                case MARIANA:
                    return new Picture(10, 10, "mariana.jpg");
                case CHRISTINA:
                    return new Picture(10, 10, "christina.jpg");
                case BENNY:
                    return new Picture(10, 10, "benny.jpg");

                case ROLO:
                    return new Picture(10, 10, "rolo.jpg");
                case SARA:
                    return new Picture(10, 10, "sara.jpg");
                case AUDREY:
                    return new Picture(10, 10, "audrey.jpg");

                case CATARINA:
                    return new Picture(10, 10, "catarina.jpg");
                case FERRAO:
                    return new Picture(10, 10, "ferrao.jpg");
                default:
                    return null;
            }

        }

        public static int catchRate(names name) {
            switch (name) {
                case SERGIO:
                case MARIANA:
                case CHRISTINA:
                case BENNY:
                case ROLO:
                case SARA:
                case AUDREY:
                    return 80;
                case CATARINA:
                case FERRAO:
                    return 20;
                default:
                    return 100;
            }
        }
    }

     /*
    // Tester
    public static void main(String[] args) {
        PokeList testList = new PokeList();
         testList.addToList(names.SERGIO);
        System.out.println(testList.getList()[0].getName());
    }
    */
}