import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class File_Handling {
    public static void main(String[] args) {
        // Code to create a new file
        File myFile1 = new File("file.txt");
        try {
            myFile1.createNewFile();
        } catch (IOException e) {
            System.out.println("Unable to create this file.");
            throw new RuntimeException(e);
        }


        // Code to write to a file
        try {
            FileWriter fileWriter = new FileWriter("file.txt");
            fileWriter.write("This is a first file.");
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        // Reading a file
        File myFile2 = new File("file.txt");
        try {
            Scanner scanner = new Scanner(myFile2);
            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


        // Deleting a file
        File myFile3 = new File("file.txt");
        if(myFile3.delete()) {
            System.out.println("I have deleted the " + myFile3.getName());
        }
        else {
            System.out.println("Some error occurred while deleting the file");
        }
    }
}
