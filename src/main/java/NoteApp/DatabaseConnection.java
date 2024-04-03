package NoteApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {

    static Connection con;
    static {
        try {
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/noteApp", "techprodt", "password");
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    static Statement st;
    static {
        try {
            st= con.createStatement();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
