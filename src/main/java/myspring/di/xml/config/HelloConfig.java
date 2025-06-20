package myspring.di.xml.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import myspring.di.xml.ConsolePrinter;
import myspring.di.xml.Hello;
import myspring.di.xml.Printer;
import myspring.di.xml.StringPrinter;

@Configuration
@PropertySource(value = "classpath:values.properties")
public class HelloConfig {
	@Autowired
	private Environment env;
	
	@Bean
	public Printer stringPrinter() {
		return new StringPrinter();
	}
	
	@Bean
	public Printer consolePrinter() {
		return new ConsolePrinter();
	}
	
	@Bean
	public Hello hello() {
		Hello hello = new Hello(); // alt + shift + l
		hello.setName(env.getProperty("myName1")); // myName1=스프링
		hello.setPrinter(stringPrinter());
		hello.setNames(namesList());
		return hello;
	}
	
	@Bean
	public List<String> namesList() {
		String names = env.getProperty("names.list.of.strings");
		String[] strArray = names.split(",");
		return Arrays.asList(strArray);
	}
}
