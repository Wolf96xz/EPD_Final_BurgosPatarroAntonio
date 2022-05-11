package epd_final;

/**
 * Personajes auxiliares que emergen en batalla de vez en cuando para cubrir a las guerreras
 */

public class PlantaRecolectora implements Personaje {
    private int nivelVida;

    public PlantaRecolectora() {
        this.nivelVida = MAX_NIVEL_VIDA;
    }

    @Override
    public String getNombre() {
        return "Las plantas recolectoras no tienen nombre";
    }

    @Override
    public int getAtaque() {
        return 0;
    }

    @Override
    public int getDefensa() {
        return 0;
    }

    @Override
    public int getNivelVida() {
        return nivelVida;
    }


    @Override
    public void setNivelVida(int n) {
        if (n >= MAX_NIVEL_VIDA){
            this.nivelVida = MAX_NIVEL_VIDA;
        } else if (n <= 0) {
            this.nivelVida = 0;
            System.out.println("Una planta recolectora ha muerto");
        }
        else {
            nivelVida = n;
        }
    }

    @Override
    public boolean isVivo() {
        if (this.nivelVida == 0){
            return false;
        }
        return true;
    }


}
