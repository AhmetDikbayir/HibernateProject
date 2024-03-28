package NoteApp;

import java.util.ArrayList;




public class Student extends User{
    private double note;
    private ArrayList<String> courses;

    public Student(int id, String name, String surname, String email) {
        super(id, name, surname, email);
    }

    public Student(int id, String name, String surname, String email, ArrayList<String> courses) {
        super(id, name, surname, email);
        this.courses = courses;
    }

    public Student(int id, String name, String surname, String email, double note, ArrayList<String> courses) {
        super(id, name, surname, email);
        this.note = note;
        this.courses = courses;
    }
}
