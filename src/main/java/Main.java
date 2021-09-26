import java.util.Scanner; // Import the Scanner class

public class Main {
    private static Game juego = new Game();

    public static void main(String[] args) throws Exception {
        System.out.println("BIENVENIDO AL JUEGO MILLONARIO");
        while (true) {
            juego.mostrarMenu();
            juego.desarrolloJuego();
        }
    }
}
