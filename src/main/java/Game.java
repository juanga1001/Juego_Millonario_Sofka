import java.util.Scanner; // Import the Scanner class

public class Game {

    // Atributes
    private Jugador jugador = new Jugador();;
    private Ronda ronda = new Ronda();;
    private Pregunta pregunta= new Pregunta();
    public static Scanner scan = new Scanner(System.in);
    private static Integer opcion;
    private static DataBase dataBase = new DataBase();
    private static Boolean respuestaCorrecta;
    private static Boolean bandera = false;
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";

    // Builder
    public Game() {
    }

    // Setters and Getters
    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setRonda(Ronda ronda) {
        this.ronda = ronda;
    }

    public Ronda getRonda() {
        return ronda;
    }

    public void setPregunta(Pregunta pregunta) {
        this.pregunta = pregunta;
    }

    public Pregunta getPregunta() {
        return pregunta;
    }

    // Methods
    public void iniciarJuego() {
        getJugador().setPuntaje(0);
        getRonda().setNumeroRonda(1);
        System.out.print("Nombre Jugador: " );
        jugador.setNombreJugador(scan.next());
        bandera = true;
        while (getRonda().getNumeroRonda() < 6 && bandera) {
            preguntar();
            validarRespuesta();
        }
        opcion = null;

    }

    public void mostrarMenu() {
        System.out.println("********************************");
        System.out.print("1. Nuevo juego\n" + "2. Mostrar puntajes\n" + "3. Salir\n" + "Elije una opción: ");
        opcion = scan.nextInt(); // Read user input
    }

    public void infoRonda() {
        System.out.print(ANSI_GREEN+jugador.getNombreJugador() + " tienes " + jugador.getPuntaje() + " Puntos acumulados\n"+ANSI_RESET);
        System.out.print("Ronda: " + ronda.getNumeroRonda() + " ==> " + ronda.calcularPremioRonda() + " Puntos en juego\n");
    }

    public boolean continuar() {
        System.out.println("********************************");
        System.out.println("ESTAS EN LA RONDA " + ronda.getNumeroRonda());
        System.out.print("1. Jugar la siguiente ronda\n" + "2. Retirarme con " + jugador.getPuntaje() + " Puntos\n"
                + "Elije una opción: ");
        int respuesta = scan.nextInt();
        if (respuesta == 1) {
            return true;
        } else {
            return false;
        }
    }

    public void desarrolloJuego(){

        switch (opcion) {
            case 1: // START A NEW GAME
                System.out.println("********************************");
                iniciarJuego();
                break;
            case 2: // MOSTRAR PUNTAJES
                System.out.println("********************************");
                System.out.println("TODOS LOS PUNTAJES");
                dataBase.showDB();
                System.out.println("********************************");
                opcion = null;
                break;
            case 3: // SALIR
                System.out.println("*********** GOOD BYE *************");
                System.exit(0);
        }
    }

    public void preguntar(){
        System.out.println("********************************");
        infoRonda();
        System.out.println("********************************");
        getPregunta().generarPregunta(getRonda().getNumeroRonda());
        getPregunta().mostrarOpciones();
        Integer respuesta = scan.nextInt(); //
        respuestaCorrecta = getPregunta().verificarRespuesta(respuesta);
    }
    public void validarRespuesta(){
        if (respuestaCorrecta) {
            jugador.sumarPuntaje(ronda.calcularPremioRonda());
            if (getRonda().getNumeroRonda() == 5) { // Validar ronda final
                System.out.println(ANSI_GREEN + "FELICIDADES HAS OBTENIDO EL PREIO MAYOR ==> "
                        + getJugador().getPuntaje() + " Puntos" + ANSI_RESET);
                dataBase.insertDB(getJugador().getNombreJugador(),getJugador().getPuntaje());
                bandera = false;
            } else { // Rondas 1 a 4
                if (continuar()) { // Preguntar al usuario si desea pasar de ronda
                    System.out.println("********************************");
                    ronda.pasarRonda();
                } else {
                    // EL JUGADOR DESEA RETIRARSE CON EL ACUMULADO
                    dataBase.insertDB(getJugador().getNombreJugador(),getJugador().getPuntaje());
                    bandera = false;
                }
            }
        } else {
            jugador.setPuntaje(0);
            dataBase.insertDB(getJugador().getNombreJugador(),getJugador().getPuntaje());
            bandera = false;
        }
    }

}
