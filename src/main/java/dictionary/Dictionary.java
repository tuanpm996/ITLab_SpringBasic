package dictionary;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;

public class Dictionary {
	private IGetWords getWords;
	private List<Word> words;
	
	private String dictType;
	
	public void setGetWords(IGetWords getWords) throws IOException, ClassNotFoundException, SQLException {
		this.getWords = getWords;
		this.words = this.getWords.getWords();
	}
	
	
	public String getMeaning(String input) {
		StringBuilder sb = new StringBuilder();
		for (Word word : this.words) {
		    if (input.equals(word.getWord()) || input.equals(ConvertAccent.removeAccent(word.getWord()))) {
		    	sb.append("\n");
		    	sb.append(word.getWord());
		    	sb.append(": ");
		    	sb.append(word.getMeaning());
		    }
		}
		return (sb.length() > 0) ? sb.toString() : null;
	}


	public List<Word> getWords() {
		return words;
	}


	public void setWords(List<Word> words) {
		this.words = words;
	}


	public String getDictType() {
		return dictType;
	}


	public void setDictType(String dictType) {
		this.dictType = dictType;
	}
	
	
}
