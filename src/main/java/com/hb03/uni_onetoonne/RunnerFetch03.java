package com.hb03.uni_onetoonne;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class RunnerFetch03 {
    public static void main(String[] args) {
        Configuration con = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Student03.class).
                addAnnotatedClass(Diary.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        Student03 std = session.get(Student03.class, 1001);
        Diary diary = session.get(Diary.class, 101);
        System.out.println(std);
        System.out.println(diary.getStudent().getName());

        String hqlQuery = "FROM Diary WHERE id = 102";
        List<Diary> results = session.createQuery(hqlQuery, Diary.class).getResultList();
//        System.out.println(results);


        Diary diary2 = session.createQuery(hqlQuery, Diary.class).uniqueResult();
        //System.out.println(diary2);
        session.delete(diary2);


        tx.commit();
        session.close();
        sf.close();

    }


}
