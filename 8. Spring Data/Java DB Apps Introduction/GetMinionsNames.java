import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class GetMinionsNames {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "1234");

        Connection connection =
                DriverManager.getConnection("jdbc:mysql://localhost:3306/minions_db", properties);

        System.out.println("Enter villain id:");
        int villainId = Integer.parseInt(scanner.nextLine());

        PreparedStatement preparedStatement =
                connection.prepareStatement("SELECT name FROM villains WHERE id = ?");

        preparedStatement.setInt(1, villainId);

        ResultSet villainSet = preparedStatement.executeQuery();
        if (!villainSet.next()) {
            System.out.printf("No villain with ID %d exists in the database.", villainId);
            return;
        }

        String villainName = villainSet.getString("name");
        System.out.printf("Villain: %s%n", villainName);

        PreparedStatement stmt = connection.prepareStatement("SELECT m.name, m.age FROM minions m " +
                " JOIN minions_villains mv on m.id = mv.minion_id " +
                " JOIN villains AS v on v.id = mv.villain_id " +
                " WHERE mv.villain_id = ?");

        stmt.setInt(1, villainId);

        ResultSet minionSet = stmt.executeQuery();
        for (int i = 1; minionSet.next(); i++) {
            String minionName = minionSet.getString("name");
            int minionAge = minionSet.getInt("age");
            System.out.printf(i + ". %s %d%n", minionName,minionAge);
        }
        connection.close();
    }
}
