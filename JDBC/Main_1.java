import java.sql.*;

public class Main_1 {
    private static final String url = "jdbc:mysql://localhost:3306/mydb";
    private static final String username = "root";
    private static final String password = "Ronaldo#07";

    public static void main(String[] args) throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        // RETRIEVE THE DATA FROM DATABASE :--
        try {
             Connection connection = DriverManager.getConnection(url,username,password);
             Statement statement = connection.createStatement();
             String query = "select * from students";
             ResultSet resultSet = statement.executeQuery(query);
             while(resultSet.next()) {
                 int id = resultSet.getInt("id");
                 String name = resultSet.getString("name");
                 int age = resultSet.getInt("age");
                 double marks = resultSet.getDouble("marks");
                 System.out.println("ID : " + id);
                 System.out.println("NAME : " + name);
                 System.out.println("AGE : " + age);
                 System.out.println("MARKS : " + marks);
             }
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }


        // INSERT A ROW IN THE DATABASE :--
        try {
            Connection connection = DriverManager.getConnection(url,username,password);
            Statement statement = connection.createStatement();
            String query1 = String.format("INSERT INTO students(name, age, marks) VALUES('%s', %d, %f)", "Rahul",23,74.5);
            int rowsAffected = statement.executeUpdate(query1);
            if(rowsAffected > 0) {
                System.out.println("Data inserted.");
            }
            else {
                System.out.println("Data not inserted.");
            }
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }

        // UPDATE THE DATABASE :--
        try {
            Connection connection = DriverManager.getConnection(url,username,password);
            Statement statement = connection.createStatement();
            String query2 = String.format("UPDATE students SET marks = %f WHERE id = %d", 92.5,3);
            int rowsAffected = statement.executeUpdate(query2);
            if(rowsAffected > 0) {
                System.out.println("Data updated.");
            }
            else {
                System.out.println("Data not updated.");
            }
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }

        //DELETE A ROW FROM THE DATABASE :--
        try {
            Connection connection = DriverManager.getConnection(url, username,password);
            Statement statement = connection.createStatement();
            String query3 = "DELETE FROM students WHERE id = 3";

            int rowsAffected = statement.executeUpdate(query3);
            if(rowsAffected > 0) {
                System.out.println("Data deleted.");
            } else {
                System.out.println("Data not deleted.");
            }
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
