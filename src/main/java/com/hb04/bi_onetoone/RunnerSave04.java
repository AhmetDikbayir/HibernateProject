package com.hb04.bi_onetoone;

import com.hb03.uni_onetoonne.Diary;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave04 {
    public static void main(String[] args) {

        //!!! 3 adet Student nesnesi oluşturalım
        Student04 student1 = new Student04();
        student1.setId(1001);
        student1.setName("Ayşe Hanım");
        student1.setGrade(10);

        Student04 student2 = new Student04();
        student2.setId(1002);
        student2.setName("Gül Hanım");
        student2.setGrade(11);

        Student04 student3 = new Student04();
        student3.setId(1003);
        student3.setName("Kenan Bey");
        student3.setGrade(9);

        // !!! 2 adet Diary nesnesi oluşturalım

        Diary04 diary1 = new Diary04();
        diary1.setId(101);
        diary1.setName("Ayse Hanımın günlüğü");
        diary1.setStudent(student1);
        //student1.setDiary(diary1);

        Diary04 diary2 = new Diary04();
        diary2.setId(102);
        diary2.setName("Gül Hanımın günlüğü");
        diary2.setStudent(student2);
        //student2.setDiary(diary2);




        Configuration con = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Student04.class).
                addAnnotatedClass(Diary04.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        session.save(student1);
        session.save(student2);
        session.save(student3);

        session.save(diary1);
        session.save(diary2);

        tx.commit();
        session.close();
        sf.close();

    }
}
