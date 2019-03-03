package by.jd2.hib_ex01.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import by.jd2.hib_ex01.bean.User;


public class Main {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration()
												.configure("hibernate.cfg.xml")
												.addAnnotatedClass(User.class)
												.buildSessionFactory();
		Session session = sessionFactory.openSession();

		try {

			session.beginTransaction();

			displayUsers(session.createQuery("from User").getResultList());

			session.getTransaction().commit();
			// insert code here

		} finally {
			sessionFactory.close();
			// insert code here
		}
	}

	private static void displayUsers(List<User> theUsers) {
		for (User tempUser : theUsers) {
			System.out.println(tempUser.getLastName());
		}
	}

}
