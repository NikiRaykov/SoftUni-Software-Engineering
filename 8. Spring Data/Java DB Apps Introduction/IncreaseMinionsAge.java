import java.sql.*;
import java.util.Arrays;
import java.util.Properties;
import java.util.Scanner;

public class IncreaseMinionsAge {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "1234");

        Connection connection =
                DriverManager.getConnection("jdbc:mysql://localhost:3306/minions_db", properties);

        PreparedStatement increaseAgeAndNameToLowerCase =
                connection.prepareStatement("UPDATE minions SET name = lower(name), " +
                        "age = age + 1 WHERE id IN(?)");

        int[] ids = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < ids.length; i++) {
            increaseAgeAndNameToLowerCase.setInt(1, ids[i]);
            increaseAgeAndNameToLowerCase.executeUpdate();
        }

        PreparedStatement printAllNamesAndAges =
                connection.prepareStatement("SELECT name, age FROM minions");

        ResultSet printSet = printAllNamesAndAges.executeQuery();

        while (printSet.next()) {
            String name = printSet.getString("name");
            int age = printSet.getInt("age");
            System.out.println(name + " " + age);
        }
    }
}
