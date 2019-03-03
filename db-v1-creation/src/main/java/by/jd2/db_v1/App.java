package by.jd2.db_v1;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import org.apache.ibatis.jdbc.ScriptRunner;
import org.mindrot.jbcrypt.BCrypt;

public class App {

	private static String[][] data = { 
			{ "PENELOPE", "GUINESS", "PENELOPE@mail.com.by", "12345" },
			{ "NICK", "WAHLBERG", "NICK@mail.com.by", "12345" }, 
			{ "ED", "CHASE", "ED@mail.com.by", "12345" },
			{ "JENNIFER", "DAVIS", "JENNIFER@mail.com.by", "12345" },
			{ "JOHNNY", "LOLLOBRIGIDA", "JOHNNY@mail.com.by", "12345" },
			{ "BETTE", "NICHOLSON", "BETTE@mail.com.by", "12345" }, 
			{ "GRACE", "MOSTEL", "GRACE@mail.com.by", "12345" },
			{ "MATTHEW", "JOHANSSON", "MATTHEW@mail.com.by", "12345" }, 
			{ "JOE", "SWANK", "JOE@mail.com.by", "12345" },
			{ "CHRISTIAN", "GABLE", "CHRISTIAN@mail.com.by", "12345" } };

	private final static String INSERT_NEW_USER_INTO_USERS =
			"INSERT INTO `db-v1`.users(first_name, last_name, email, password, password_salt, last_update) VALUES(?,?,?,?,?,?)";

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/"+
				"?useUnicode=true&characterEncoding=UTF-8", "root", "password");

		PreparedStatement ps = con.prepareStatement(INSERT_NEW_USER_INTO_USERS);

		ScriptRunner runner = new ScriptRunner(con);
		try {
			runner.runScript(new FileReader("db-v1-creation.sql"));
		}catch (IOException e){
			throw new RuntimeException(e);
		}

		for (int i = 0; i < data.length; i++) {
			ps.setString(1, data[i][0]);// first_name
			ps.setString(2, data[i][1]);// last_name
			ps.setString(3, data[i][2]);// email

			String salt = BCrypt.gensalt();
			String hashpw = BCrypt.hashpw(data[i][3], salt);

			ps.setString(4, hashpw);// password
			ps.setString(5, salt);// password_salt

			Timestamp t = new Timestamp(System.currentTimeMillis());
			ps.setTimestamp(6, t);

			System.out.println(ps.toString());
			ps.executeUpdate();

		}

		ps.close();
		con.close();
	}
}
