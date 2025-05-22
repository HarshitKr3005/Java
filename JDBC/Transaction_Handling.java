import java.sql.*;
import java.util.Scanner;

public class Transaction_Handling {
    private static final String url = "jdbc:mysql://localhost:3306/balance";
    private static final String username = "root";
    private static final String password = "Ronaldo#07";

    public static void main(String[] args) throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            connection.setAutoCommit(false);
            String debitQuery = "UPDATE accounts SET balance = balance - ? WHERE account_number = ?";
            String creditQuery = "UPDATE accounts SET balance = balance + ? WHERE account_number = ?";
            PreparedStatement debitPreparedStatement = connection.prepareStatement(debitQuery);
            PreparedStatement creditPreparedStatement = connection.prepareStatement(creditQuery);
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter account number : ");
            int account_number = scanner.nextInt();
            System.out.print("Enter amount : ");
            double amount = scanner.nextDouble();
            debitPreparedStatement.setDouble(1, amount);
            debitPreparedStatement.setInt(2, account_number);
            creditPreparedStatement.setDouble(1, amount);
            creditPreparedStatement.setInt(2, 102);
            debitPreparedStatement.executeUpdate();
            creditPreparedStatement.executeUpdate();
            if(isSufficient(connection, account_number, amount)) {
                connection.commit();
                System.out.println("Transaction completed.");
            } else {
                connection.rollback();
                System.out.println("Transaction failed.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    static boolean isSufficient(Connection connection, int account_number, double amount) {
        try {
            String query = "SELECT balance FROM accounts WHERE account_number = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, account_number);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
               double current_balance = resultSet.getDouble("balance");
               if(amount > current_balance) {
                   return false;
               } else {
                   return true;
               }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}
