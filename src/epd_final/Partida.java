package epd_final;



public abstract class Partida {
    protected Planta[] plantasGuerreras;
    protected Zombi[] zombis;
    protected PlantaRecolectora[] plantasRecolectoras;
    protected int plantasGuerreras_vivas;
    protected int zombis_vivos;
    protected int plantasRecolectoras_vivas;
    protected int plantasGuerreras_muertas;
    protected int zombis_muertos;
    protected int plantasRecolectoras_muertas;
    protected int num_combates;

    public Partida(String[] disposicionTablero) {
        plantasGuerreras_vivas = Integer.parseInt(disposicionTablero[0].substring(8));
        zombis_vivos = Integer.parseInt(disposicionTablero[1].substring(7));
        plantasRecolectoras_vivas = Integer.parseInt(disposicionTablero[2].substring(13));

        plantasGuerreras = new Planta[plantasGuerreras_vivas];
        zombis = new Zombi[zombis_vivos];
        plantasRecolectoras = new PlantaRecolectora[plantasRecolectoras_vivas];

        for (int x = 0; x < plantasRecolectoras.length; x++) { plantasRecolectoras[x] = new PlantaRecolectora(); }



        for (int z = 0; z < zombis.length; z++) { // Inserta en el vector de zombis los que participaran en la partida correspondiente, delimitados por el vector del tablero
            for (int i = 0; i < plantasGuerreras.length; i++) {  // Inserta en el vector de plantas guerreras, empleando trataLinea
                for (int x = 0; x < disposicionTablero.length ; x++){
                    if (disposicionTablero[x].startsWith("P;")) {plantasGuerreras[i++] = (Planta) trataLinea(disposicionTablero[x]);}
                    if (disposicionTablero[x].startsWith("Z;")) {zombis[z++] = (Zombi) trataLinea(disposicionTablero[x]);}

                }

            }
        }



        }


    /**
     * Metodo que es empleado para generar un guerrero (Planta o Zombi) según la linea que extraiga del vector disposicionTablero
     * @param i
     * @return
     */

 private Guerrero trataLinea(String i){
        String[] partes = i.split(";");
        Guerrero p1 = null;
            if (partes[0].equals("P")) {
                p1 = new Planta(partes[1], Integer.parseInt(partes[2]), Integer.parseInt(partes[3]), new Arma(Integer.parseInt(partes[4])));
            }else if(partes[0].equals("Z")){
                p1 = new Zombi(partes[1], Integer.parseInt(partes[2]), Integer.parseInt(partes[3]), partes[4], new Habilidad(Integer.parseInt(partes[5])));
            }
        return p1;
    }


    /**
     * Metodo que va mostrando el desarrollo de la partida
     */

    public void imprimeEstadoPartida(){
        System.out.println("******** ESTADO GLOBAL DE LA PARTIDA *********");


        System.out.println("- PLANTAS GUERRERAS: ");
        System.out.println("\t - Numero inicial de planta de tipo guerrera: " +plantasGuerreras.length);
        System.out.println("\t - Numero de planta de tipo guerrera vivas: " +plantasGuerreras_vivas);
        System.out.println("\t - Numero de planta de tipo guerrera muertas: " +plantasGuerreras_muertas);

        System.out.println("- ZOMBIS: ");
        System.out.println("\t - Numero inicial de zombis: " +zombis.length);
        System.out.println("\t - Numero de zombis vivos: " +zombis_vivos);
        System.out.println("\t - Numero de zombis muertos: " +zombis_muertos);

        System.out.println("- RECOLECTORAS: ");
        System.out.println("\t - Numero inicial de planta de tipo recolectoras: " +plantasRecolectoras.length);
        System.out.println("\t - Numero de planta de tipo planta recolectora vivas: " +plantasRecolectoras_vivas);
        System.out.println("\t - Numero de planta de tipo planta recolectora muertas: " +plantasRecolectoras_muertas);

        if (plantasGuerreras_vivas > zombis_vivos){
            System.out.println("PARTIDA EN JUEGO: Las plantas van ganando");
        }else if(zombis_vivos > plantasGuerreras_vivas){
            System.out.println("PARTIDA EN JUEGO: Los zombis van ganando");
        }else if(plantasGuerreras_vivas == zombis_vivos){
            System.out.println("PARTINDA EN JUEGO: Ambos bandos van igualados");
        }

        System.out.println("Combates hasta el momento: " +num_combates);


    }


    protected int combate(Personaje p1, Personaje p2) {

        System.out.println("COMBATE: " + p1.getNombre() + " " + "vs" + " " + p2.getNombre());
        int dañoFinal = p1.getAtaque() - p2.getDefensa();
        int dañoFinal2 = p2.getAtaque() - p1.getDefensa();

        // Tanda de ifs que comprueban requisitos como que no sean dos plantas entrentandose entre si, o dos pjs muertos en combate
        if (p1.getNivelVida() == 0 && p2.getNivelVida() == 0) {
            System.out.println("Ambos personajes estan muertos, por lo que no se puede celebrar el combate");
            return -1;
        }
        if (p1 instanceof Planta && p2 instanceof Planta) {
            System.out.println("Dos plantas guerreras no pueden luchar entre sí");
            return -1;
        }
        if (p1 instanceof PlantaRecolectora && p2 instanceof PlantaRecolectora) {
            System.out.println("Dos plantas recolectoras no pueden luchar entre sí");
            return -1;
        }
        if (p1 instanceof PlantaRecolectora && p2 instanceof Planta){
            System.out.println("Son del mismo bando");
            return -1;
        }



        p1.setNivelVida(p1.getNivelVida() - dañoFinal2);
        p2.setNivelVida(p2.getNivelVida() - dañoFinal);
        num_combates++;


        if (!p2.isVivo()) {
            if (p2 instanceof Planta) {
                plantasGuerreras_muertas++;
                plantasGuerreras_vivas--;
            }
            if (p2 instanceof Zombi){
                zombis_muertos++;
                zombis_vivos--;
            }
            if (p2 instanceof PlantaRecolectora){
                plantasRecolectoras_muertas++;
                plantasRecolectoras_vivas--;
            }
        }
        if (!p1.isVivo()) {
            if (p1 instanceof Planta) {
                plantasGuerreras_muertas++;
                plantasGuerreras_vivas--;

            }
            if (p1 instanceof Zombi){
                zombis_muertos++;
                zombis_vivos--;

            }
            if (p1 instanceof PlantaRecolectora){
                plantasRecolectoras_muertas++;
                plantasRecolectoras_vivas--;
            }
        }

        if (p1.getNivelVida() > p2.getNivelVida()) {
            System.out.println(" ========" + " " + "GANADOR: " + " " + p1.getNombre());

            return 1;

        }
        if (p2.getNivelVida() > p1.getNivelVida()) {
            System.out.println(" ========" + " " + "GANADOR: " + " " + p2.getNombre());
            return 2;

        }




        System.out.println("Ambos personajes empatan");
            return 0;

    }


    /**
     * Metodo que imprime por pantalla las plantas disponibles en la partida
     */

    public void imprimePlantasGuerrerasVivas(){
        System.out.println("--> PLANTAS GUERRERAS VIVAS");

        for (int i = 0; i < plantasGuerreras.length; i++){
            if (plantasGuerreras[i].isVivo()) {
                System.out.println(i + ":" + "\t" + "Planta guerrera: " +plantasGuerreras[i].toString() + "\t");
            }

        }


    }


    /**
     * Metodo que muestra por pantalla los zombis que hay vivos en la partida actual
     */

    public void imprimeZombisVivos(){
        System.out.println("--> ZOMBIS VIVOS");

        for (int i = 0; i < zombis.length; i++){
            if (zombis[i].isVivo()) {
                System.out.println(i + ":" + "\t" + "Zombi " +zombis[i].toString() + "\t");
            }
        }

    }

    public void jugar(){}


}
