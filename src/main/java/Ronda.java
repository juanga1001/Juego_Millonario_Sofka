public class Ronda {

    // Atributes
    private Integer numeroRonda = 1;

    // Builder
    public Ronda() {
    };

    // Setters and Getters
    public void setNumeroRonda(Integer numeroRonda) {
        this.numeroRonda = numeroRonda;
    }

    public Integer getNumeroRonda() {
        return numeroRonda;
    }

    // Methods
    public int calcularPremioRonda() {
        int premio = numeroRonda * 1000;
        return premio;
    }

    public void pasarRonda() {
        numeroRonda++;
    }

}
