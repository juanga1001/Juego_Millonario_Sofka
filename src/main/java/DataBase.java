import com.mongodb.DBObject;
import com.mongodb.client.*;
import org.bson.Document;
import java.util.List;
import java.util.ArrayList;


public class DataBase {
    // Atributes

    private String dataBase = "TestDB";
    private String collection = "RetoSofka";
    private MongoClient client = MongoClients.create("mongodb+srv://TestUser:123@cluster0.puass.mongodb.net/myFirstDatabase?retryWrites=true&w=majority");
    private MongoDatabase db = client.getDatabase(dataBase);
    private MongoCollection col = db.getCollection(collection);
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLUE = "\u001B[34m";


    // Builder
    public DataBase(){};

    // Methods
    public void insertDB (String Nombre, int Puntaje){
        Document jugador = new Document();
        jugador.append("Nombre", Nombre).append("Puntaje",Puntaje);
        col.insertOne(jugador);
    }
    public void showDB (){
        MongoCursor< Document > cursor = col.find().iterator();
        while (cursor.hasNext()) {
            Document doc = cursor.next();
            String name = doc.getString("Nombre");
            Integer puntaje = doc.getInteger("Puntaje");
            System.out.println(ANSI_BLUE+name +ANSI_RESET+ " ==> "+ANSI_BLUE + puntaje + ANSI_RESET+" Puntos");
        }
        cursor.close();
    }
}
