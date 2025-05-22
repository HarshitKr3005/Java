import java.sql.*;

public class JDBC_through_prepared_statements {
    private static final String url = "jdbc:mysql://localhost:3306/mydb";
    private static final String username = "root";
    private static final String password = "Ronaldo#07";

    public static void main(String[] args) throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        // INSERT A ROW IN DATABASE :--
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            String query = "INSERT INTO students(name, age, marks) VALUES(?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,"Ananya");
            preparedStatement.setInt(2, 22);
            preparedStatement.setDouble(3, 86.4);

            int rowsAffected = preparedStatement.executeUpdate();
            if(rowsAffected > 0) {
                System.out.println("Data inserted.");
            }
            else {
                System.out.println("Data not inserted.");
            }
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }


        // RETRIEVE A ROW FROM THE DATABASE :--
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            String query1 = "SELECT marks FROM students WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query1);
            preparedStatement.setInt(1,1);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                double marks = resultSet.getDouble("marks");
                System.out.println("Marks : " + marks);
            } else {
                System.out.println("Marks not found.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        // UPDATE A ROW IN THE DATABASE :--
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            String query2 = "UPDATE students SET marks = ? WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query2);
            preparedStatement.setDouble(1, 95);
            preparedStatement.setInt(2, 4);

            int rowsAffected = preparedStatement.executeUpdate();
            if(rowsAffected > 0) {
                System.out.println("Data updated.");
            }
            else {
                System.out.println("Data not updated.");
            }
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }


        // DELETE A ROW IN THE DATABASE :--
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            String query2 = "DELETE from students WHERE marks = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query2);
            preparedStatement.setDouble(1, 95);
            int rowsAffected = preparedStatement.executeUpdate();
            if(rowsAffected > 0) {
                System.out.println("Data deleted.");
            }
            else {
                System.out.println("Data not deleted.");
            }
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
