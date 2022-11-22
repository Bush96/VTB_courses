package org.example;

import org.example.model.Item;
import org.example.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.Scanner;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите команду:");

        if (sc.hasNext("findPersonsByProductTitle")) {

            System.out.println("Введите название товара:");
            Scanner sc1 = new Scanner(System.in);
            String message = sc1.nextLine();
            findPersonsByProductTitle(message);

        } else if (sc.hasNext("showProductsByPerson")) {
            System.out.println("Введите имя человека:");
            Scanner sc1 = new Scanner(System.in);
            String message = sc1.nextLine();
            showProductsByPerson(message);

        } else if (sc.hasNext("removePerson")) {
            System.out.println("Введите имя человека:");
            Scanner sc1 = new Scanner(System.in);
            String message = sc1.nextLine();
            removePerson(message);

        } else {
            System.out.println("Я такого не делаю");
        }
    }


    static void findPersonsByProductTitle(String message) {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class)
                .addAnnotatedClass(Item.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            Query<Item> item = session.createQuery("select i from Item i where i.itemName = :name", Item.class).setParameter("name", message);
            System.out.println(item.getResultList().get(0).getOwner());
            session.getTransaction().commit();

//
        } finally {
            sessionFactory.close();
        }
    }

    static void showProductsByPerson(String message) {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class)
                .addAnnotatedClass(Item.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();
            Query<Person> person = session.createQuery("select p from Person p where p.name = :name", Person.class).setParameter("name", message);
            System.out.println(person.getResultList().get(0).getItems());

            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }

    static void removePerson(String message) {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class)
                .addAnnotatedClass(Item.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            Query query = session.createQuery("DELETE FROM Person WHERE name = :name").setParameter("name", message);
            query.executeUpdate();

            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}
