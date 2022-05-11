package epd_final;


public class Simulacion {
    public static void main(String[] args) {
        String[] disposicionTablero = {
                "Plantas:2",
                "Zombis:4",
                "Recolectores:5",
                "P;Repetidora;10;7;1",
                "Z;Zombistein;15;20;PolimÃ³rfico;1",
                "P;Iris;28;21;3",
                "Z;Zombot;18;25;Influenza;1",
                "Z;Zombidito;21;8;Adenovirus;0",
                "Z;Frank;22;10;Influenza;2",
        };
        PartidaTipo1 p = new PartidaTipo1(disposicionTablero);
        PartidaTipo2 p2 = new PartidaTipo2(disposicionTablero);

        p2.jugar();
    }



}

