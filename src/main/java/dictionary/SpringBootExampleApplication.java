package dictionary;


import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.convert.ConversionService;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

@SpringBootApplication
public class SpringBootExampleApplication {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("/home/michu/ITLab_SpringBasic/src/main/java/Beans.xml");
		Dictionary dict = (Dictionary) context.getBean("dictionary");		
		search(dict);
	}
	
	public static void search(Dictionary dict) {
		while(true) {
			ExpressionParser parser = new SpelExpressionParser();
			Expression exp = parser.parseExpression("'Input your word: '");  
			String message = (String) exp.getValue();  
			System.out.println(message);  
			Scanner sc = new Scanner(System.in);
			String input = sc.nextLine();
			String meaning = dict.getMeaning(input);
			if(meaning!=null) {
				System.out.println("Mean of " + input + " is " + meaning);
			} else {
				System.out.println("The word doesn't exist");
			}
			
		}
	}
}
