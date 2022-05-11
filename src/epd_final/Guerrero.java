package epd_final;

/**
 *  Clase guerrero que define el comportamiento de las plantas guerreras en una partida
 */

public class Guerrero implements Personaje{
    protected String nombre;
    protected int ataque;
    public final int MAX_ATAQUE = 100;
    public final int MAX_DEFENSA = 100;
    protected int defensa;
    protected int nivelVida;

    public Guerrero(String nombre, int ataque, int defensa) {
        this.nombre = nombre;
        if (ataque >= 0 && ataque <= MAX_ATAQUE){
            this.ataque = ataque;
        }
        if (defensa >= 0 && defensa <= MAX_DEFENSA){
            this.defensa = defensa;
        }
        this.nivelVida = MAX_NIVEL_VIDA;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public int getAtaque() {
        return ataque;
    }

    @Override
    public int getDefensa() {
        return defensa;
    }

    @Override
    public int getNivelVida() {
        return nivelVida;
    }

    @Override
    public void setNivelVida(int n) {
        if (n >= MAX_NIVEL_VIDA){
           nivelVida = MAX_NIVEL_VIDA;
        }else if (n <= 0){
            this.nivelVida = 0;
            System.out.println(nombre + " " + " ha muerto");
        }
        else {
            nivelVida = n;
        }
    }

    /**
     * Metodo que permite saber si el personaje sigue con vida o no
     * @return
     */
    @Override
    public boolean isVivo() {
        if (this.nivelVida == 0){
            return false;
        }
        return true;

    }

    @Override
    public String toString() {
       if (this.nivelVida == 0){
           return this.nombre + "ha muerto";
       }
       return this.nombre + "\n" + "Nivel de ataque: " + this.ataque + "\n" + "Nivel de defensa: " + this.defensa + "\n" + "Nivel de vida: " +
               this.nivelVida;

    }
}
