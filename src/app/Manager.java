package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.ResultSet;

/**
 * Manager
 */
public class Manager {

    private static Connection connect() {
        String url = "jdbc:sqlite:./db/Menu.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public static ArrayList<Burger> prepareBurgers() {
        String sql = "SELECT * FROM burgers";
        ArrayList<Burger> allBurgers = new ArrayList<>();

        try {
            Connection conn = connect();
            Statement stmt = conn.createStatement();
            ResultSet data = stmt.executeQuery(sql);

            while (data.next())
                allBurgers.add(new Burger(data.getInt("id"), data.getString("name"), data.getDouble("price"),
                        data.getString("roll"), data.getString("meat")));

            return allBurgers;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    public static Integer getBillId() {
        String sql = "SELECT id FROM bills ORDER BY id DESC LIMIT 1";

        try {
            Connection conn = connect();
            Statement stmt = conn.createStatement();
            ResultSet data = stmt.executeQuery(sql);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    public static void prepareToppings(Burger burger) {
        String sql = "SELECT * FROM toppings WHERE id IN (SELECT toppingId FROM burgerToppings WHERE burgerId = ?)";

        try {
            Connection conn = connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, burger.getId());

            ResultSet data = pstmt.executeQuery();

            while (data.next())
                burger.setToppings(new Topping(data.getString("name"), data.getDouble("price")));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
