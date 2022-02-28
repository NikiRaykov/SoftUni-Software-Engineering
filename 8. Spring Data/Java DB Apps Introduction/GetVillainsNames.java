import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class GetVillainsNames {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        Connection connection = getConnection();

        PreparedStatement preparedStatement = getPreparedStatement(connection);

        System.out.print("Enter count filter: ");
        int count = Integer.parseInt(scanner.nextLine());

        preparedStatement.setInt(1, count);
        ResultSet resultSet = preparedStatement.executeQuery();

        extracted(resultSet);

        connection.close();
    }

    private static void extracted(ResultSet resultSet) throws SQLException {
        while (resultSet.next()){
            System.out.printf("%s %d%n", resultSet.getString("name"),
                    resultSet.getInt("count"));
        }
    }

    private static PreparedStatement getPreparedStatement(Connection connection) throws SQLException {
        return connection.prepareStatement("SELECT v.name, COUNT(DISTINCT mv.minion_id) AS `count` FROM villains v\n" +
                "JOIN minions_villains mv on v.id = mv.villain_id\n" +
                "GROUP BY v.name\n" +
                "HAVING `count` > ?\n" +
                "ORDER BY `count` DESC;");
    }

    private static Connection getConnection() throws SQLException {
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "1234");

        return DriverManager.getConnection("jdbc:mysql://localhost:3306/minions_db", properties);
    }
}
