import java.io.*;
 class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        Steps to Deserialize
//        1. Declare your object (don't instantiate)
//        2. Your class should implement Serializable interface
//        3. add import java. io.serializable;
//        4. FileInputStream fileln = new FileInputStream(fi1e path);
//        5. ObjectlnputStream in = new Objectlnputstream(fileln);
//        6. objectName = (Class) in. readObject();
//        7. in. close(); fileln.close();

          User user = null;
          FileInputStream fileIn = new FileInputStream("C:\\Users\\harsh\\IdeaProjects\\Java Serialization\\UserInfo.ser");
          ObjectInputStream in = new ObjectInputStream(fileIn);
          user = (User) in.readObject();
          in.close();
          fileIn.close();

        System.out.println(user.name);
        System.out.println(user.password);
        user.sayHello();
    }
}
