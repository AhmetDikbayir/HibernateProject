package com.hb12.get_load;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch12 {
    public static void main(String[] args) {

        /*
        get() ---> gerçek nesneyi döndürür ,
            nesne yoksa null döner
            nesnenin olduğundan emin değilseniz get() kullanın
            dönen nesneyi hemen kullanacaksam get() kullanılmalı
        load() --> proxy nesne döndürür, gerçek nesnenin gölgesi ,
            nesne yoksa exception fırlatır
            dönen nesne üzerinde delete yapılacaksa kullanılabilir
    */

        Configuration con = new org.hibernate.cfg.Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Student12.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

//        System.out.println("************Start to execute get method**************");
//        Student12 student1 = session.get(Student12.class, 1L);
//        System.out.println("***********Finish to execute get method*************");
//
//        System.out.println("Student ID : " + student1);
//
//        System.out.println("=================================");
//        System.out.println("************** Load method *****************");
//        Student12 student2 = session.load(Student12.class, 2L);
//        System.out.println("************** Load method finish ****************");
//        System.out.println("call getID()");
//        System.out.println("Student ID : " + student2.getId());
//        System.out.println("call getName()");
//        System.out.println(student2.getName());

        //!!! db de olmayan id'ler ile get ve load metotlarının davranışını görme

        System.out.println("********* Start to execute get method");
        Student12 student3 = session.get(Student12.class, 5L);
        System.out.println("********* Finish to execute get method");

        if(student3!= null){
            System.out.println(student3.getId());
        }

        //--> LOAD
        System.out.println("********* Start to execute load method");
        Student12 student4 = session.load(Student12.class, 10L);
        System.out.println("********* Finish to execute load method");

        if(student4!= null){
            System.out.println("Student ID : " + student4.getId());
        }


        tx.commit();
        session.close();
        sf.close();
    }
}
