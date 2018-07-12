package dictionary;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class WordValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Word.class.equals(clazz);
	}

	@Override
	public void validate(Object obj, Errors error) {
		ValidationUtils.rejectIfEmpty(error, "name", "name.empty");
        Word p = (Word) obj;
        if (p.getWord().length() > 1) {
        	error.rejectValue("word", "too short");
        } else if (p.getMeaning().length() < 1) {
        	error.rejectValue("meaning", "too short");
        }
		
	}



}
