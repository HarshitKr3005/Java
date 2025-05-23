import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Main {
    public static void main(String[] args) throws IOException {
//        Serialization :  The process of converting an object into a byte stream.
//                         Persists (saves the state) the object after program exits
//                         This byte stream can be saved as a file or sent over a network
//                         Can be sent to a different machine.
//                         Byte Stream can be saved as a file (.ser) which is platform independent.
//                         (Think of this as if you are saving a file with the object's information)

//        Deserialization : The reverse process of converting a byte stream into an object.
//                          (Think og this as if you are loading a saved file).

//        Steps to Serialize
//        1. Your object class should implement Serializable interface
//        2. add import java.io.Serializable;
//        3. FileOutputStream fileOut = new FileOutputStream(fi1e path)
//        4. ObjectOutputStream out = new ObjectOutputStream(fi1eOut);
//        5. out. writeObject(objectName)
//        6. out. close(); fileout.close();

        User user = new User();
        user.name = "Harshit Kumar";
        user.password = "RonaldoMessi#";

        FileOutputStream fileOut = new FileOutputStream("UserInfo.ser");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(user);
        out.close();
        fileOut.close();

        System.out.println("Object info saved");
    }
}
