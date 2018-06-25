package bd.ac.seu.aj.hibernatedemo;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    private SessionFactory sessionFactory;

    public Main() {
        sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        Product product = new Product(4235, "Nova 3e", 27000, "Phone");

        Session session = sessionFactory.openSession();

        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.save(product);
            transaction.commit();
        } catch (HibernateException he) {
            transaction.rollback();
        }

        session.close();
    }

    public static void main(String args[]) {
        System.out.println("Hello World!");
        new Main();
    }
}
