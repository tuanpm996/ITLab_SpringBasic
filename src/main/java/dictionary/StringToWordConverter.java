package dictionary;

import org.springframework.core.convert.converter.Converter;

public class StringToWordConverter implements Converter<String, Word> {

	@Override
	public Word convert(String line) {
		if (line == null || line.isEmpty()) {
            System.out.println("fsfsf");
        }
		if (line.contains(":")) {
			String[] words = line.split(":");
			return new Word(words[0].trim(), words[1].trim());
		} else {
			if (line.contains(",")) {
				int index = line.indexOf(',');
				String first = line.substring(0, index).trim();
				String second = line.substring(index + 1).trim();
				return new Word(first, second);
			}
		}

		return null;
	}

}
