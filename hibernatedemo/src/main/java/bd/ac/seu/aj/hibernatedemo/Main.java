package bd.ac.seu.aj.hibernatedemo;

import bd.ac.seu.aj.hibernatedemo.model.*;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    private SessionFactory sessionFactory;

    private void insertEmployee() {
                /*Name name,
                List< Address > addressList,
                List< Phone > phoneList,
                Sex sex,
                LocalDate dateOfBirth,
                long employeeId,
                LocalDate joiningDate,
                Rank rank
                */
        List<Address> addressList = new ArrayList<>();
        List<Phone> phoneList = new ArrayList<>();
        Employee employee = new Employee(new Name("John", "H.", "Doe"),
                addressList,
                phoneList,
                Sex.MALE,
                LocalDate.of(1995, Month.JULY, 17),
                1354,
                LocalDate.of(2017, Month.MAY, 24),
                Rank.SALES_PERSON);

        Phone phone = new Phone("88", "02", "23463245");
        employee.getPhoneList().add(phone);

        Address address = new Address("24 Kemal Ataturk Avenue", "Dhaka", "Bangladesh", "1213");
        employee.getAddressList().add(address);

        System.out.println(employee);

        Session session = sessionFactory.openSession();

        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.save(phone);
            session.save(address);
            session.save(employee);
            transaction.commit();
            System.out.println("Committed transaction SUCCESSFULLY");
        } catch (HibernateException he) {
            transaction.rollback();
            he.printStackTrace();
        }

        session.close();

    }

    public Main() {
        sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
        insertEmployee();
/*

//        Product product = new Product(4235, "Nova 3e", 27000, "Phone");

        Session session = sessionFactory.openSession();

        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
//            session.save(product);

//            Stream<Product> productStream = session
//                    .createQuery("FROM Product", Product.class)
//                    .stream();
//
//            System.out.println(productStream.count());

            transaction.commit();
        } catch (HibernateException he) {
            transaction.rollback();
        }

        session.close();
*/
        sessionFactory.close();

    }

    public static void main(String args[]) {
        System.out.println("Hello World!");
        new Main();
    }
}
