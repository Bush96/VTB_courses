package org.example;

import jakarta.persistence.LockModeType;
import org.example.model.Thing;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class WorkerThread implements Runnable {

    @Override
    public void run() {
        catchVal();
    }

    static void catchVal() {
        int random = 1 + (int) (Math.random() * 40);

        Configuration configuration = new Configuration().addAnnotatedClass(Thing.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            Thing thing = session.get(Thing.class, random, LockMode.fromJpaLockMode(LockModeType.PESSIMISTIC_READ));
            processCommand();
            thing.setVal(thing.getVal() + 1);
            System.out.println(thing);
            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }

    static void processCommand() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
