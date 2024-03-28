package NoteApp;

import java.sql.SQLException;
import java.util.Scanner;

import static NoteApp.DatabaseConnection.con;
import static NoteApp.DatabaseConnection.st;

public class NoteApp {

    StudentService studentService = new StudentService();
    TeacherService teacherService = new TeacherService();
    Scanner scan = new Scanner(System.in);


    public void start() throws SQLException {
        String createTeacherTable = "CREATE TABLE IF NOT EXISTS teachers(" +
                "id INTEGER," +
                "name VARCHAR(20)," +
                "surname VARCHAR(20)," +
                "email VARCHAR(50)," +
                "course VARCHAR(20)," +
                "courseId INTEGER PRIMARY KEY);";
        st.execute(createTeacherTable);

        String createStudentTable = "CREATE TABLE IF NOT EXISTS students(" +
                "id INTEGER PRIMARY KEY," +
                "name VARCHAR(20)," +
                "surname VARCHAR(20)," +
                "email VARCHAR(50)," +
                "note REAL," +
                "courseId INTEGER," +
                "FOREIGN KEY(courseId) REFERENCES teachers(courseId));";
        st.execute(createStudentTable);


        byte select = 0;
        do{
            System.out.println("Welcome our Note App");
            System.out.println("Please choose your operation: \n" +
                    "1 ==> Save Student \n" +
                    "2 ==> Enter Student note \n" +
                    "3 ==> Find the student teacher \n" +
                    "4 ==> List Student \n" +
                    "5 ==> Save Teacher \n" +
                    "6 ==> List Teacher \n" +
                    "0 ==> EXIT");
            select = scan.nextByte();
            switch (select){
                case 1:
                    studentService.createStudent();
                    break;
                case 2:
                    studentService.setNote();
                    break;
                case 3:
                    studentService.findTeacher();
                    break;
                case 4:
                    studentService.listStudent();
                    break;
                case 5:
                    teacherService.addTeacher();
                    break;
                case 6:
                    teacherService.listTeacher();
                    break;
                case 0:
                    System.out.println("Good bye have a good day!!");
                    break;
            }

        }while(select != 0);

    }
}
