package epd_final;

import poo.io.IO;

import java.util.Random;

public class PartidaTipo2 extends Partida{
    public PartidaTipo2(String[] disposicionTablero) { // Constructor heredado de la clase Partida
        super(disposicionTablero);
    }

    @Override
    public void jugar() {
        int h, a;
        String s;

        System.out.println("************************************************************");
        System.out.println("***************** INICIO DE PARTIDA TIPO 2 *****************");
        System.out.println("************************************************************\n");

        do {
            imprimeEstadoPartida();

            System.out.println("\n*** ELIGE UNO DE LOS BANDOS (Plantas/Zombis) ***");
            s = IO.readLine().toUpperCase();

            /**
             * Esta parte del codigo se encarga de que el usuario pueda seleccionar uno de los bandos, en vez de jugar solo con las plantas
             */
            if (s.equals("ZOMBIS")){
                imprimeZombisVivos();
                System.out.println("Elige uno de los zombis disponibles:");
                h = (int) IO.readNumber();
                a = new Random().nextInt(plantasGuerreras.length);
                combate(plantasGuerreras[a], zombis[h]);
            }else if (s.equals("PLANTAS")){
                imprimePlantasGuerrerasVivas();
                System.out.println("Elige una Planta Guerrera:");
                h = (int) IO.readNumber();
                a = new Random().nextInt(zombis.length);
                if (new Random().nextBoolean()) {
                    System.out.println("Recolectora al rescate");
                    combate(plantasRecolectoras[new Random().nextInt(plantasRecolectoras.length)], zombis[a]);
                }else {
                    combate(zombis[a], plantasGuerreras[h]);
                }
            }




        }while (plantasGuerreras_vivas > 0 && zombis_vivos > 0);


        System.out.println("******************************************");
        System.out.println("*********** FINAL DE PARTIDA ************");
        System.out.println("******************************************");

        imprimeEstadoPartida();

        System.out.println("******************************************");
        System.out.println("*************** GAME OVER ****************");
        System.out.println("******************************************");


    }
}
