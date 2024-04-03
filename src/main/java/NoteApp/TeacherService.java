package NoteApp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import static NoteApp.DatabaseConnection.con;
import static NoteApp.DatabaseConnection.st;

public class TeacherService {

    Scanner scan = new Scanner(System.in);

    public void addTeacher() throws SQLException {

        System.out.println("Please enter teacher id :");
        int id = scan.nextInt();
        scan.nextLine();
        System.out.println("Please enter teacher name :");
        String tchName = scan.nextLine();
        System.out.println("Please enter teacher surname :");
        String tchSurname = scan.nextLine();
        System.out.println("Please enter teacher email :");
        String tchEmail = scan.nextLine();
        System.out.println("Please enter teacher course :");
        String tchCourse = scan.nextLine();
        System.out.println("Please enter teacher courseId :");
        int courseId = scan.nextInt();
        scan.nextLine();

        String createTeacher = "INSERT INTO teachers VALUES(?,?,?,?,?,?);";
        PreparedStatement prst = con.prepareStatement(createTeacher);
        prst.setInt(1,id);
        prst.setString(2,tchName);
        prst.setString(3,tchSurname);
        prst.setString(4,tchEmail);
        prst.setString(5, tchCourse);
        prst.setInt(6,courseId);
        prst.executeUpdate();

    }

    public void listTeacher() throws SQLException {
        String listTeacher = "SELECT * FROM teachers";
        ResultSet rs = st.executeQuery(listTeacher);
        while(rs.next()){
            System.out.println("-----------------------------");
            System.out.println("Teacher id : " + rs.getInt("id"));
            System.out.println("Teacher name : " + rs.getString("name"));
            System.out.println("Teacher surname : " + rs.getString("surname"));
            System.out.println("Teacher email : " + rs.getString("email"));
            System.out.println("Teacher course name : " + rs.getString("course"));
            System.out.println("Teacher courseId : " + rs.getInt("courseid"));
            System.out.println("--------------------------------");
        }
    }

}
