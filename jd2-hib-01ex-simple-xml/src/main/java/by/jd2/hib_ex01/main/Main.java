package by.jd2.hib_ex01.main;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import by.jd2.hib_ex01.bean.User;


public class Main {

	public static void main(String[] args) {

			SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

			Session session = factory.openSession();

			try {
				
				session.beginTransaction();


				//CriteriaQuery<User> criteriaQuery = session.getCriteriaBuilder().createQuery(User.class);

				List<User> users = session.createQuery("from User").getResultList();
				List<String> result = session.createQuery("select u.firstName from User as u").list();
				// insert code here
				//List<String> result = new ArrayList<>();

				session.getTransaction().commit();

				for(String name : result) {
					System.out.println("-----" + name);
				}
				
				
				for(User user : users) {
					System.out.println(user.getUserId() + " " + user.getFirstName() + "  " + user.getPasswordSalt() + " " + user.getLastUpdate());
				}

			} finally {
				factory.close();
			}
		}


}
