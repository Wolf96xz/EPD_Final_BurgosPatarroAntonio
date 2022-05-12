package epd_final;

public class Planta extends Guerrero{
    private Arma arma;

    public Planta(String nombre, int ataque, int defensa, Arma arma) {
        super(nombre, ataque, defensa);
        this.arma = arma;

    }

    @Override
    public String toString() {
        if (!isVivo()){
            return "La planta guerrera" + this.nombre + "está muerta";
        }
        return this.nombre + "\n" + "\t" + "Nivel de ataque: " + this.ataque + "\n" + "\t" + "Nivel de defensa: " +
                this.defensa + "\n" + "\t" + "Nivel de vida: " + this.nivelVida + "\n" + "\t" + "Arma: " +  this.arma;
    }

    public Arma getArma() {
        return arma;
    }
}
