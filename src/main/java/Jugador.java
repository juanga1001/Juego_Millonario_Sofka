public class Jugador {

    // Atributes
    private String nombreJugador;
    private Integer puntaje = 0;

    // Builder
    public Jugador() {
    }

    // Methods
    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

    public String getNombreJugador() {
        return nombreJugador;
    }

    public void setPuntaje(Integer puntaje) {
        this.puntaje = puntaje;
    }

    public Integer getPuntaje() {
        return puntaje;
    }

    public void sumarPuntaje(Integer premioRonda) {
        puntaje = puntaje + premioRonda;
    }

}
