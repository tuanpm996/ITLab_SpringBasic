package dictionary;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.GenericConverter;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

@Service
public class GetWordFromFile implements IGetWords{	
	
	
	@Override
	public List<Word> getWords() throws IOException {
		System.out.println("Get words from file");		
		List<Word> listWords = new ArrayList<>();
		Resource resource = new FileSystemResource("/home/michu/Downloads/vnedict.txt");
		InputStream resourceInputStream = resource.getInputStream();
		File file = resource.getFile();
		insertToDictionary(file, listWords);
		return listWords;
	}
	
	public void insertToDictionary(File file, List<Word> listWords) throws IOException {
        FileReader in = new FileReader(file);
        BufferedReader br = new BufferedReader(in);
        DefaultConversionService conversionService = new DefaultConversionService();
	    conversionService.addConverter(new StringToWordConverter());
        String line;
        while ((line = br.readLine()) != null) {
        	listWords.add(conversionService.convert(line, Word.class));
        }
    }
}
