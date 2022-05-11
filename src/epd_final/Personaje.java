package epd_final;

/**
 *  Interfaz personaje que posee los metodos que usan los pjs del juego
 */
public interface Personaje {
    final int MAX_NIVEL_VIDA = 50;

    String getNombre();
    int getAtaque();
    int getDefensa();
    int getNivelVida();
    void setNivelVida(int n);
    boolean isVivo();


}
