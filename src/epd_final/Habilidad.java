package epd_final;

public class Habilidad {
    private int tipo;
    private int potencia;
    public final int SIN_HABILIDAD = 0;
    public final int SALTARIN = 1;
    public final int ESQUIVADOR = 2;
    public final int HIPNOTIZADOR = 3;

    public Habilidad(int tipo) {
        if (tipo == SALTARIN){
            this.tipo = SALTARIN;
            this.potencia = 10;
        }else if(tipo == ESQUIVADOR) {
            this.tipo = ESQUIVADOR;
            this.potencia = 25;
        }else if(tipo == HIPNOTIZADOR){
            this.tipo = HIPNOTIZADOR;
            this.potencia = 40;
        }else {
            this.tipo = SIN_HABILIDAD;
            this.potencia = 0;
        }
    }

    public int getTipo() {
        return tipo;
    }

    public int getPotencia() {
        return potencia;
    }

    @Override
    public String toString() {
        if (this.tipo == SALTARIN){
            return "Habilidad Saltarin" + " " + "(" + this.potencia + ")";
        }else if (this.tipo == ESQUIVADOR){
            return "Habilidad Esquivador" + " " + "(" + this.potencia + ")";
        }
        else if (this.tipo == HIPNOTIZADOR){
            return "Habilidad Hipnotizador" + " " + "(" + this.potencia + ")";
        }
        return "Sin arma" + " " + "(" + this.potencia + ")";

    }
}
