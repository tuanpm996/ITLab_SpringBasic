package dictionary;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface IGetWords {
	public List<Word> getWords() throws IOException, ClassNotFoundException, SQLException;
}
