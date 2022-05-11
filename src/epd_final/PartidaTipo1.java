package epd_final;

import poo.io.IO;

import java.util.Random;

public class PartidaTipo1 extends Partida {
    public PartidaTipo1(String[] tablero) {
        super(tablero);
    }

    public void jugar() {

        int h, a;

        System.out.println("************************************************************");
        System.out.println("***************** INICIO DE PARTIDA TIPO 1 *****************");
        System.out.println("************************************************************\n");

        do {
            imprimeEstadoPartida();

            System.out.println("\n*** ELECCIÃ“N DE PERSONAJES PARA EL COMBATE ***");
            imprimePlantasGuerrerasVivas();
            System.out.println("Elige una Planta Guerrera:");
            h = (int) IO.readNumber();
            imprimeZombisVivos();
            System.out.println("Elige un Zombi:");
            a = (int) IO.readNumber();

            System.out.println("\n*** COMIENZA EL COMBATE ***");

            Random r = new Random();

            if (r.nextBoolean()) {

                System.out.println("ATENCION: Â¡Â¡Â¡Una planta de tipo recolectora se ha entrometido en el combate!!!");
                combate(plantasRecolectoras[r.nextInt(plantasRecolectoras.length)], zombis[a]);

            } else {
                combate(plantasGuerreras[h], zombis[a]);
            }

        } while (plantasGuerreras_vivas > 0 && zombis_vivos > 0);

        System.out.println("******************************************");
        System.out.println("*********** FINAL DE PARTIDA ************");
        System.out.println("******************************************");

        imprimeEstadoPartida();

        System.out.println("******************************************");
        System.out.println("*************** GAME OVER ****************");
        System.out.println("******************************************");

    }


}
