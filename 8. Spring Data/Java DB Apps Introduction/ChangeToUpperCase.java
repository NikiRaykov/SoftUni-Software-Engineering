import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

public class ChangeToUpperCase {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "1234");

        Connection connection =
                DriverManager.getConnection("jdbc:mysql://localhost:3306/minions_db", properties);

        String country = scanner.nextLine();

        PreparedStatement changeToUpperCaseStmt =
                connection.prepareStatement("UPDATE towns SET name = UPPER(name) WHERE country = ?");

        changeToUpperCaseStmt.setString(1, country);
        int updateCount = changeToUpperCaseStmt.executeUpdate();

        if (updateCount == 0) {
            System.out.println("No town names were affected.");
            return;
        }

        System.out.println(updateCount + " town names were affected.");
        PreparedStatement selectTownNames =
                connection.prepareStatement("SELECT name FROM towns WHERE country = ?");
        selectTownNames.setString(1, country);
        ResultSet updatedTowns = selectTownNames.executeQuery();

        List<String> towns = new ArrayList<>();
        while (updatedTowns.next()) {
            towns.add(updatedTowns.getString("name"));
        }
        System.out.println(towns);
    }
}
