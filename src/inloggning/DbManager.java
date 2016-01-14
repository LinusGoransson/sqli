/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inloggning;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Lobo
 */
public class DbManager {

    public static String loginStupid(String username, String password) {

        try {
            Connection conn = getConnection("T4labb");
            Statement stmt = (Statement) conn.createStatement();
            String sql = String.format("SELECT * FROM user WHERE username='%s' AND password='%s'", username, password);
            System.out.println(sql);
            ResultSet data = stmt.executeQuery(sql);
            data.next();
            return String.format("Du är nu inloggad som %s.", data.getString("username"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return "Felaktigt användarnamn/Lösenord!";
    }

    public static String loginBetter(String username, String password) {

        //http://www.theserverside.com/news/1365244/Why-Prepared-Statements-are-important-and-how-to-use-them-properly
        try {
            Connection conn = getConnection("T4labb");
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM user WHERE username=? AND password=?");
            stmt.setString(1, username);
            stmt.setString(2, password);
            System.out.println(stmt.toString());
            ResultSet data = stmt.executeQuery();
            data.next();
            return String.format("Du är nu inloggad som %s.", data.getString("username"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return "Felaktigt användarnamn/Lösenord!";
    }

    private static Connection getConnection(String server) {
        try {
            if (server.equals("T4labb")) {
                System.out.println("Connecting T4 Labb srever");
                return (Connection) DriverManager.getConnection("jdbc:mysql://10.97.72.5/sqlinject", "T4lundberg", "T4lundberg");
            } else {
                System.out.println("Connecting localhost..");
                return (Connection) DriverManager.getConnection("jdbc:mysql://localhost/sqlinject", "root", "");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

    }

}
