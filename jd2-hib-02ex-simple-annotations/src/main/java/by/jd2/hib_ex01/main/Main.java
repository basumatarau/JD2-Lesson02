package by.jd2.hib_ex01.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import by.jd2.hib_ex01.bean.User;

public class Main {

	public static void main(String[] args) {

		// insert code here

		try {

			// insert code here

		} finally {

			// insert code here
		}
	}

	private static void displayUsers(List<User> theUsers) {
		for (User tempUser : theUsers) {
			System.out.println(tempUser.getLastName());
		}
	}

}
