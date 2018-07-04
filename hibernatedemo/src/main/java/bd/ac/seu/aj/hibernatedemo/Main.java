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
        Employee employee1 = new Employee(new Name("John", "H.", "Doe"),
                addressList,
                phoneList,
                Sex.MALE,
                LocalDate.of(1995, Month.JULY, 17),
                1354,
                LocalDate.of(2017, Month.MAY, 24),
                Rank.SALES_PERSON);

        Employee employee2 = new Employee(new Name("Hasan", null, "Tareque"),
                addressList,
                phoneList,
                Sex.MALE,
                LocalDate.of(1995, Month.JULY, 17),
                1355,
                LocalDate.of(2017, Month.MAY, 24),
                Rank.SALES_PERSON);

        Employee employee3 = new Employee(new Name("Md.", "Rakibul", "Hasan"),
                addressList,
                phoneList,
                Sex.MALE,
                LocalDate.of(1995, Month.JULY, 17),
                1356,
                LocalDate.of(2017, Month.MAY, 24),
                Rank.SALES_PERSON);

        Phone phone = new Phone("88", "02", "23463245");
        employee1.getPhoneList().add(phone);
        //employee2.getPhoneList().add(phone);

        Address address = new Address("24 Kemal Ataturk Avenue", "Dhaka", "Bangladesh", "1213");
        employee1.getAddressList().add(address);

        System.out.println(employee1);

        Department accountsDepartment = new Department("Accounts");
        Department salesDepartment = new Department("Sales");

        employee1.setDepartment(salesDepartment);
        employee2.setDepartment(salesDepartment);
        employee3.setDepartment(accountsDepartment);

        salesDepartment.getEmployeeList().add(employee1);
        salesDepartment.getEmployeeList().add(employee2);
        accountsDepartment.getEmployeeList().add(employee3);

        Session session = sessionFactory.openSession();

        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.save(phone);
            session.save(address);
            session.save(accountsDepartment);
            session.save(salesDepartment);
            session.save(employee1);
            session.save(employee2);
            session.save(employee3);
            transaction.commit();
            System.out.println("Committed transaction SUCCESSFULLY");
        } catch (HibernateException he) {
            transaction.rollback();
            he.printStackTrace();
        } finally {
            session.close();
        }
    }

    private void insertCustomer() {
                /*Name name,
                List< Address > addressList,
                List< Phone > phoneList,
                Sex sex,
                LocalDate dateOfBirth,
                long customerId
                */
        List<Address> addressList = new ArrayList<>();
        List<Phone> phoneList = new ArrayList<>();
        Customer customer = new Customer(new Name("Jane", "A.", "Doe"),
                addressList,
                phoneList,
                Sex.MALE,
                LocalDate.of(1985, Month.MAY, 18),
                6577);

        Phone phone = new Phone("88", "02", "4346313");
        customer.getPhoneList().add(phone);

        Address address = new Address("18 Kemal Ataturk Avenue", "Dhaka", "Bangladesh", "1213");
        customer.getAddressList().add(address);

        System.out.println(customer);

        Session session = sessionFactory.openSession();

        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.save(phone);
            session.save(address);
            session.save(customer);
            transaction.commit();
            System.out.println("Committed transaction SUCCESSFULLY");
        } catch (HibernateException he) {
            transaction.rollback();
            he.printStackTrace();
        } finally {
            session.close();
        }
    }

    public Main() {
        sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
        insertEmployee();
        insertCustomer();
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
