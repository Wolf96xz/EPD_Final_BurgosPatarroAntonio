package epd_final;

public class Zombi extends Guerrero{
    private String infeccion;
    private Habilidad habilidad;

    
    public Zombi(String nombre, int ataque, int defensa, String infeccion, Habilidad habilidad) {
        super(nombre, ataque, defensa);
        this.infeccion = infeccion;
        this.habilidad = habilidad;
        if (this.ataque < 100){
            this.ataque = habilidad.getPotencia() + this.ataque;
        }
    }



    @Override
    public String toString() {
        if (!isVivo()) {
            return "Zombi" + this.nombre + "está muerto";
        }
        return  this.nombre + "\n" + "\t" + "Nivel de ataque: " + this.ataque + "\n" + "\t" + "Nivel de defensa: " +
                this.defensa + "\n" + "\t" + "Nivel de vida: " + this.nivelVida + "\n" + "\t" + "Infeccion: " + this.infeccion + "\n" + "\t" +
                "Habilidad: " + this.habilidad;

    }
}
