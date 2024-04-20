package com.hb11.caching;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch11 {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Student11.class);
        SessionFactory sf = configuration.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        System.out.println("******** Ilk get islemi --> 1 id li Student için : ");
        Student11 student1 = session.get(Student11.class, 1);

        session.clear(); // first level cache in iini boşaltır.

        System.out.println("******** Ikinci get islemi --> 1 id li Student için : ");
        Student11 student2 = session.get(Student11.class, 1);
        System.out.println(student1);

        tx.commit();
        session.close();

        Session session1 = sf.openSession();
        Transaction tx2 = session1.beginTransaction();

        System.out.println("******** Session1 close sonrası --> 1 id li Student için : ");
        Student11 student3 = session1.get(Student11.class, 1);

        tx2.commit();
        session1.close();
        sf.close();
    }
}
