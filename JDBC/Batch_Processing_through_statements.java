import java.sql.*;
import java.util.Scanner;

public class Batch_Processing_through_statements {
    private static final String url = "jdbc:mysql://localhost:3306/mydb";
    private static final String username = "root";
    private static final String password = "Ronaldo#07";

    public static void main(String[] args) throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            Connection connection = DriverManager.getConnection(url,username,password);
            Statement statement = connection.createStatement();
            Scanner scanner = new Scanner(System.in);
            while(true) {
                System.out.print("Enter name : ");
                String name = scanner.next();
                System.out.print("Enter age : " );
                int age = scanner.nextInt();
                System.out.print("Enter marks : ");
                double marks = scanner.nextDouble();
                System.out.print("Enter more data(Y/L) : ");
                String choice = scanner.next();
                String query = String.format("INSERT INTO students(name, age, marks) VALUES('%s', %d, %f)", name, age, marks);
                statement.addBatch(query);
                if(choice.toUpperCase().equals("N")) {
                    break;
                }
            }
            int[] arr = statement.executeBatch();
            for(int i=0;i<arr.length;i++) {
                if(arr[i] == 0) {
                    System.out.println("Query " + i + " not executed.");
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
