package NoteApp;

import java.sql.SQLException;

public class NoteAppRunner {


    public static void main(String[] args) throws SQLException {
        NoteApp noteApp = new NoteApp();
        noteApp.start();
    }
}
