package epd_final;


import poo.io.IO;

public class Simulacion {
    public static void main(String[] args) {
        String[] disposicionTablero = {
                "Plantas:2",
                "Zombis:4",
                "Recolectores:10",
                "P;Repetidora;10;7;1",
                "Z;Zombistein;15;20;PolimÃ³rfico;1",
                "P;Iris;28;21;3",
                "Z;Zombot;1800;25;Influenza;1",
                "Z;Zombidito;21;8;Adenovirus;0",
                "Z;Frank;25;10;Influenza;2",
        };
        PartidaTipo1 p = new PartidaTipo1(disposicionTablero);
        PartidaTipo2 p2 = new PartidaTipo2(disposicionTablero);
        int tipoPartida;

        System.out.println("Elige el tipo de partida a jugar");
        System.out.println("1 - Eliges tanto el zombi como la planta que pelearan");
        System.out.println("2 - Eliges uno de los bandos y el contricante será aleatorio ");

        tipoPartida = (int) IO.readNumber();

        if (tipoPartida == 1){
            p.jugar();
        }else if(tipoPartida == 2){
            p2.jugar();
        }

    }



}

