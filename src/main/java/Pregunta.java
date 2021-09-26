import java.lang.Math;

public class Pregunta {

    // Atributes
    private final String[] preguntas = { "¿Cuál es la capital de Venezuela? ",
            "¿Dónde se encuentra la emblemática Torre Eiffel?", "¿Quién es el autor de el Don Quijote de la Mancha",
            "¿Según la Biblia, quién traicionó a Jesús?", "¿A quién le crecía la nariz cuando mentía?",
            "¿A qué personas se las conoce como carioca?", "¿A cuánto equivale el número pi?",
            "¿Dónde se encuentra la famosa Casa Blanca?", "¿Cuál es tercer planeta del sistema solar?",
            "¿Quién fue el primer hombre en pisar la luna?", "¿Cuándo acabó la Segunda Guerra Mundial?",
            "¿Cuál es el nombre del fundador de Facebook?", "¿Quién escribió ‘El Principito’?",
            "¿Cuál es el himno nacional de Francia?", "¿Qué nombre científico recibe el detector de mentiras?",
            "¿Cuál es conocida como la ciudad de los rascacielos?", "¿Quién dijo “yo sólo sé que no se nada”?",
            "¿Quién fue la primera mujer en ir al espacio?", "¿Cuál es la lengua más hablada en el mundo?",
            "¿Qué rama de la Biología se encarga del estudio de los animales?",
            "¿Cuál es el edificio más alto del mundo?", "¿En qué país se encuentra el Wembley Arena?",
            "¿Cómo se llama el triángulo que tiene sus tres lados iguales ?",
            "¿Quién es el dirigente en Corea del Norte?", "¿Qué tipo de animal es la ballena?" };
    private final String[][] opciones = { { "tokio", "colombia", "caracas", "bogota" },
            { "medellin", "cali", "bogota", "paris" }, { "miguel de cervantes", "carlos", "camilo", "Julian" },
            { "judas", "francisco", "nadie", "armando" }, { "el chavo", "pinocho", "don ramon", "goku" },
            { "brasileños", "urugayos", "chilenos", "caleños" }, { "4", "3.50", "3.21", "3.14" },
            { "nariño", "usa", "alemania", "bogota" }, { "venus", "marte", "tierra", "sol" },
            { "Epa colombia", "nick Arsmtrong ", "alvaro uribe", "neil Arsmtrong" }, { "1945", "1935", "1944", "1916" },
            { " Mark thompson ", " Mark Zuckerberg", "Steve JOBS", "Mark clan" },
            { "mario", "abad", "Antoine", "allende" }, { "marsellesa", "maesl", "maseel", "marsellesel" },
            { "poligrafeno", "poligrafo", "boligrafo", "poligrafito" },
            { "amsterdam", "Tokio", "Being jin", "New York" }, { "socrates", "perseo", "aristoteles", "platon" },
            { "kathie Tereshkova", "Valentina Tereshkova", "maria Tereshkova", "mia Tereshkova" },
            { "mandarin", "ingles", "frances", "español" }, { "paleontologia", "botanica", "zoologia", "ontologia" },
            { "Empire State", "Torre trump", "Burj Khalifa", "emirates" },
            { "Niza", "Londres", "Manchester", "Belgica" }, { "igualdad", "equivalente", "equilatero", "equilado" },
            { "Jong-un-kim", " Jong-nun-kim", "Kim Jong-um", "Kim Jong-un" },
            { "reptil", "mamimero", "crustaceo", "anfibio" } };
    private final Integer[] claves = { 3, 4, 1, 1, 2, 1, 4, 2, 3, 4, 1, 2, 3, 1, 2, 4, 1, 2, 1, 3, 3, 2, 3, 4, 2 };
    private int numeroPregunta;
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";

    // Builder
    public Pregunta() {
    };

    // Setters and Getters
    public String[] getPreguntas() {
        return preguntas;
    }

    public String[][] getOpciones() {
        return opciones;
    }

    public Integer[] getClaves() {
        return claves;
    }

    public void setNumeroPregunta(int numeroPregunta) {
        this.numeroPregunta = numeroPregunta;
    }

    public int getNumeroPregunta() {
        return numeroPregunta;
    }

    // Methods
    public void generarPregunta(int ronda) {
        numeroPregunta = generarNumero((ronda * 5 - 4), ronda * 5);
        System.out.println(preguntas[numeroPregunta - 1]);

    }

    public void mostrarOpciones() {
        for (int i = 0; i < 4; i++) {
            System.out.println(i + 1 + ". " + opciones[numeroPregunta - 1][i]);
        }
        System.out.print("¿Cuál es la respuesta correcta?: ");
    }

    public Boolean verificarRespuesta(Integer respuesta) {
        if ((respuesta) == claves[numeroPregunta - 1]) {
            System.out.println(ANSI_GREEN+"RESPUESTA CORRECTA"+ANSI_RESET);
            return true;
        } else {
            System.out.println(ANSI_RED+"RESPUESTA INCORRECTA"+ANSI_RESET);
            return false;
        }

    }

    public int generarNumero(int min, int max) {
        int rango = (max - min) + 1;
        return (int) (Math.random() * rango) + min;
    }
}

