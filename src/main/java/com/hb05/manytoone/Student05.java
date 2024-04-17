package com.hb05.manytoone;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.time.LocalDateTime;

@Entity
public class Student05 {

    @Id
    private Integer id;

    @Column(name="student_name", nullable = false)
    private String name;

    private int grade;

    private LocalDateTime createOn; //create edilme tarih ve saat bilgisini tutacağız

    @ManyToOne
    @JoinColumn(name = "university_id")
    private University university;

    @PrePersist // !!! create tarihini persist edildiğindeki zaman olsun
// TRICK : icinde bulundugum sinifdan bir instance olusturuldugu anda createOn degeri setlenir
    public void prePersist(){
        createOn = LocalDateTime.now();
    }

    // Getter - Setter **************************
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public LocalDateTime getCreateOn() {
        return createOn;
    }

//    public void setCreateOn(LocalDateTime createOn) {
//        this.createOn = createOn;
//    }

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    //toString **************************
    @Override
    public String toString() {
        return "Student05{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", createOn=" + createOn +
                ", university=" + university +
                '}';
    }
}
