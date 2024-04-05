package com.hb01.annotations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class RunnerFetch01 {

    public static void main(String[] args) {
        Configuration con = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Student01.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        //!!! DB den bilgi çekmek için 3 yol:
                  //1) get metodu
                  //2) SQL
                  //3) HQL (Hibernate Query Language)

        // Not : Get() ********************************
//        Student01 student1 = session.get(Student01.class,1001);
//        Student01 student2 = session.get(Student01.class,1002);
//
//        System.out.println(student1);
//        System.out.println(student2);

        // Not : SQL ******************************
        String sqlQuery = "SELECT * FROM t_student01";
//        List<Object[]> resultList1 =  session.createSQLQuery(sqlQuery).getResultList();
//
//        for(Object[] obj : resultList1){
//            System.out.println(Arrays.toString(obj));
//        }

        // Not : HQL *****************************
//        String hqlQuery1 = "FROM Student01";
//        List<Student01> resultList2 = session.createQuery(hqlQuery1, Student01.class).getResultList();
//        for(Student01 student01 : resultList2){
//            System.out.println(student01);
//        }

        //Not : Exercises ********************************

//        String sqlQuery2 = "SELECT * FROM t_student01 WHERE student_name = 'Doğu'";
//        Object[] uniqueResult1 = (Object[]) session.createSQLQuery(sqlQuery2).uniqueResult();
//
//        System.out.println(Arrays.toString(uniqueResult1));
//
//        System.out.println(uniqueResult1[0] + " " + uniqueResult1[1] + " " + uniqueResult1[2] + " " + uniqueResult1[3]);

        //Aynı sorguyu HQL ile yazalım
        String hqlQuery2 = "FROM Student01 WHERE name = 'Doğu'";
        Student01 uniqueresult2 = session.createQuery(hqlQuery2, Student01.class).uniqueResult();

        System.out.println(uniqueresult2);
        System.out.println(uniqueresult2.getName());


        tx.commit();
        session.close();
        sf.close();
    }
}
