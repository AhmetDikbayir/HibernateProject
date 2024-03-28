package NoteApp;

public class Teacher extends User{
    private String course;
    private int courseId;

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public Teacher(int id, String name, String surname, String email, String course, int courseId) {
        super(id, name, surname, email);
        this.course = course;
        this.courseId = courseId;
    }

    public Teacher() {
    }
}
