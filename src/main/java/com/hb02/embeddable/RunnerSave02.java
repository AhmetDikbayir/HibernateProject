package com.hb02.embeddable;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave02 {

    public static void main(String[] args) {

        // 1. Öğrenci
        Student02 std1 = new Student02();
        std1.setId(1001);
        std1.setName("Ayse Hanim");
        std1.setGrade(80);

        Address address1 = new Address();
        address1.setStreet("Apple Street");
        address1.setCity("Istanbul");
        address1.setCountry("Turkey");
        address1.setZipCode("341000");

        std1.setAddress(address1);

        //2. Öğrenci
        Student02 std2 = new Student02();
        std2.setId(1002);
        std2.setName("Ali Bey");
        std2.setGrade(80);

        Address address2 = new Address();
        address2.setStreet("Orange Street");
        address2.setCity("Ankara");
        address2.setCountry("Turkey");
        address2.setZipCode("061000");

        std2.setAddress(address2);

        Configuration con = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Student02.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        session.save(std1);
        session.save(std2);


        tx.commit();
        session.close();
        sf.close();

    }
}
