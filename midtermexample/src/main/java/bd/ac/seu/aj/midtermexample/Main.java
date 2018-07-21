package bd.ac.seu.aj.midtermexample;

import bd.ac.seu.aj.midtermexample.model.Campus;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public Main() {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        Session session = sessionFactory.openSession();

        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

//            Campus campus = new Campus("Test Campus", null, 4.0, null);
            Campus campus = new Campus("Te", null, -4.0, null);
            session.save(campus);

            transaction.commit();
            System.out.println("Committed transaction SUCCESSFULLY");
        } catch (HibernateException he) {
            transaction.rollback();
            he.printStackTrace();
        } finally {
            session.close();
        }

        sessionFactory.close();
    }

    public static void main(String args[]) {
        new Main();
    }
}
