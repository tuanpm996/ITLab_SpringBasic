package dictionary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Validator;

public class Word {
    private String meaning;
    
    private String word;
    
    public String getWord() {
        return this.word;
    }

    public String getMeaning() {
        return this.meaning;
    }

    public Word(String word, String meaning) {
        this.word = word;
        this.meaning = meaning;
    }
}
