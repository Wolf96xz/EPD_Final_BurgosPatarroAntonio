package epd_final;

/**
 * Clase que define el tipo de arma que portaran las plantas guerreras
 */

public class Arma {
    private int tipo;
    private int potencia;
    public final int SIN_ARMA = 0;
    public final int COROLA = 1;
    public final int PISTILO = 2;
    public final int ESTAMBRE = 3;
    public final int CALIZ = 4;

    public Arma(int tipo) {
        if (tipo == COROLA){
            this.tipo = COROLA;
            this.potencia = 5;
        }else if(tipo == PISTILO) {
            this.tipo = PISTILO;
            this.potencia = 15;
        }else if(tipo == ESTAMBRE){
            this.tipo = ESTAMBRE;
            this.potencia = 20;
        }else if(tipo == CALIZ){
            this.tipo = CALIZ;
            this.potencia = 30;
        }else {
            this.tipo = SIN_ARMA;
            this.potencia = 0;
        }
    }


    @Override
    public String toString() {
        if (this.tipo == COROLA){
            return "Arma Corola" + this.potencia;
        }else if (this.tipo == PISTILO){
            return "Arma Pistilo" + this.potencia;
        }
        else if (this.tipo == ESTAMBRE){
            return "Arma Estambre" + this.potencia;
        }
        else if (this.tipo == CALIZ){
            return "Arma Caliz" + this.potencia;
        }

        return "Sin arma" + this.potencia;

    }


    public int getPotencia() {
        return potencia;
    }
}
