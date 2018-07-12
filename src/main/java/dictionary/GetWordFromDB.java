package dictionary;
import org.springframework.validation.Validator;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.autoconfigure.validation.ValidationAutoConfiguration;

public class GetWordFromDB implements IGetWords{
	private static String CLASS = "com.mysql.jdbc.Driver";
	private static String URL = "jdbc:mysql://127.0.0.1:3306/Chat";
	private static String ACCOUNT = "root";
	private static String PASSWORD = "abcd1234";
	@Override
	public List<Word> getWords() throws IOException, ClassNotFoundException, SQLException {
		System.out.println("Get words from DB");
		List<Word> listWords = new ArrayList<>();
		connect(listWords);
		return listWords;
	}
	
	public void connect(List<Word> listWords) throws ClassNotFoundException, SQLException {
		Class.forName(CLASS);
		Connection conn = null;
		conn = DriverManager.getConnection(URL, ACCOUNT, PASSWORD);
		Statement stm = conn.createStatement();
		ResultSet rs = stm.executeQuery("select * from WORD");
		while (rs.next()) {
			String word = rs.getString("WORD");
			String meaning = rs.getString("MEANING");
			Word words = new Word(word, meaning);
			listWords.add(words);
		}
	}
}
