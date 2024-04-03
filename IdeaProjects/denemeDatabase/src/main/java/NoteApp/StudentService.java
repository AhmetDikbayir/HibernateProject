package NoteApp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import static NoteApp.DatabaseConnection.con;
import static NoteApp.DatabaseConnection.st;

public class StudentService {

    Scanner scan = new Scanner(System.in);

    public void createStudent() throws SQLException {
        System.out.println("Please enter student id: ");
        int studentId = scan.nextInt();
        scan.nextLine();
        System.out.println("Please enter student name:");
        String stdName = scan.nextLine();
        System.out.println("Please enter student surname:");
        String stdSurname = scan.nextLine();
        System.out.println("Please enter student email:");
        String stdEmail = scan.next();
        ArrayList<String> courses = new ArrayList<>();

        String stdCreate = "INSERT INTO students VALUES(?,?,?,?)";
        PreparedStatement prst = con.prepareStatement(stdCreate);
        prst.setInt(1,studentId);
        prst.setString(2,stdName);
        prst.setString(3,stdSurname);
        prst.setString(4,stdEmail);
        prst.executeUpdate();

    }

    //FİRST ASSİGNMENT METOT OLARAK DEĞİŞTİR
    //DİĞER YAZILILAR İÇİN METOTLAR OLUŞTUR

    public void setNote() throws SQLException {
        System.out.println("Please enter student id: ");
        int stdId = scan.nextInt();
        scan.nextLine();
        System.out.println("Please enter course id: ");
        int stdCourse = scan.nextInt();
        scan.nextLine();
        System.out.println("Please enter students note:");
        int stdNote = scan.nextInt();
        scan.nextLine();
        String setStudentNote = "UPDATE students SET firstassignmentnote = ?, courseid = ? WHERE id = ?";
        PreparedStatement prst = con.prepareStatement(setStudentNote);
        prst.setInt(1,stdNote);
        prst.setInt(2, stdCourse);
        prst.setInt(3, stdId);
        prst.executeUpdate();
    }


    public void findTeacher() throws SQLException {
        System.out.println("Please enter student name:");
        String stdName = scan.nextLine();
        System.out.println("Please enter the course Id: ");
        int courseID = scan.nextInt();
        scan.nextLine();
        String findTeacherSQL = "SELECT s.name AS sName, t.name AS tName\n" +
                "FROM teachers t \n" +
                "JOIN students s\n" +
                "ON t.courseId = s.courseId\n" +
                "WHERE s.name = ? AND ? = t.courseId";
        PreparedStatement prst = con.prepareStatement(findTeacherSQL);
        prst.setString(1, stdName);
        prst.setInt(2, courseID);
        ResultSet rs = prst.executeQuery();
        while(rs.next()){
            System.out.println("Student Name : " + rs.getString("sName") + " Teacher name : " + rs.getString("tName"));
        }

    }

    public void listStudent() throws SQLException {
        String listStudent = "SELECT * FROM students";
        ResultSet rs = st.executeQuery(listStudent);
        while (rs.next()){
            System.out.println("Student id : " + rs.getInt("id"));
            System.out.println("Student name : " + rs.getString("name"));
            System.out.println("Student surname : " + rs.getString("surname"));
        }
    }

}
