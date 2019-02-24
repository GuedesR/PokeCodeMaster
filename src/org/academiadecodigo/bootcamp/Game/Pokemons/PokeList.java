package org.academiadecodigo.bootcamp.Game.Pokemons;

//import com.sun.org.apache.xpath.internal.operations.String;

public class PokeList {

    private Pokes[] pokelist = new Pokes[names.values().length];

    public Pokes[] getList() {
        return pokelist;
    }
    public Pokes getElement(int i){
        return pokelist[i];
    }

    public PokeList(){

        for(int i = 0; i < pokelist.length; i++){
            addToList(i);
            pokelist[i].lock();
        }
        pokelist[names.AUDREY.i].unlock();
        pokelist[names.CHRISTINA.i].unlock();
        pokelist[names.MARIANA.i].unlock();
    }

    public void addToList(names name){
        int catchR = names.catchRate(name);
        String foto = names.imageName(name);
        int i = names.number(name);
        pokelist[i] = new Pokes(name, catchR, foto);
    }

    public void addToList(int i) {
        if (i < 0 || i > names.values().length) {
            System.out.println("Out of bounds");
            return;
        }
        int catchR = names.catchRate(names.values()[i]);
        String foto = names.imageName(names.values()[i]);
        pokelist[i] = new Pokes(names.values()[i], catchR, foto);

    }

    public enum names {
        // MasterCoders
        SERGIO (0),
        MARIANA (1),
        CHRISTINA (2),
        BENNY (3),

        ROLO(4),
        SARA (5),
        AUDREY (6),

        FERRAO (7),
        UNKNOWN(8);

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
                case FERRAO:
                    return 7;
                case UNKNOWN:
                    return 8;
                default:
                    return -1;
            }
        }

        public static String imageName(names name) {
            switch (name) {
                case SERGIO:
                    return "sergio.png" /*"sergio.jpg"*/;
                case MARIANA:
                    return "mariana.png"/*"mariana.jpg"*/;
                case CHRISTINA:
                    return "christina.png"/*"christina.jpg"*/;
                case BENNY:
                    return "benny.png"/*"benny.jpg"*/;

                case ROLO:
                    return "rolo.png";
                case SARA:
                    return "sara.png";
                case AUDREY:
                    return "audrey.png";

                case FERRAO:
                    return "ferrao.jpg";
                case UNKNOWN:
                    return "pika4.png";// empty picture
                default:
                    return "pika.png";
            }

        }

        public static int catchRate(names name) {
            switch (name) {
                case SERGIO:
                case AUDREY:
                    return 50;
                case MARIANA:
                case CHRISTINA:
                    return 80;
                case BENNY:
                case ROLO:
                case SARA:
                    return 60;
                case FERRAO:
                    return 20;
                default:
                    return 100;
            }
        }

    }

}