package com.hb14.entity_lifecycle_2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave14 {
    public static void main(String[] args) {

        Employee employee1 = new Employee();
        employee1.setName("Mirac");
        employee1.setSalary(25000.0);

        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Employee.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        System.out.println("-------> sesion.save cagrildi :");
        session.save(employee1);

        tx.commit();
        session.close();
        sf.close();
    }
}
