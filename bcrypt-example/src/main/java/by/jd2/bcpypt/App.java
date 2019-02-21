package by.jd2.bcpypt;

import org.mindrot.jbcrypt.BCrypt;

public class App {
	public static void main(String[] args) {
		String password = "qwerty";
		
		String salt = BCrypt.gensalt();
		
		String hashpw;
		hashpw = BCrypt.hashpw(password, BCrypt.gensalt());
		
		System.out.println(salt);
		
		System.out.println(hashpw);
		
	}

	
}
