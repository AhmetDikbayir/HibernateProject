package com.hb03.uni_onetoonne;


import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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

        //**************** Delete method used *******************
        Diary diary2 = session.createQuery(hqlQuery, Diary.class).uniqueResult();
        //System.out.println(diary2);
        //session.delete(diary2);



        //***************** Create criteria used ****************************
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Diary> criteria = builder.createQuery(Diary.class);
        Root<Diary> root = criteria.from(Diary.class);
        criteria.select(root).where(builder.equal(root.get("name"), "Ahmet's diary"));

        Query<Diary> query = session.createQuery(criteria);
        List<Diary> diaryList = query.getResultList();
        for(Diary d : diaryList){
            System.out.println(d);
        }


        tx.commit();
        session.close();
        sf.close();

    }


}
