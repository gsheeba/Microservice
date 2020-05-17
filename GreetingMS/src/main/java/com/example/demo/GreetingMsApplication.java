package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.example.demo.model.Greeting;
import com.example.demo.repository.GreetingRepo;

@SpringBootApplication
public class GreetingMsApplication {

	@Autowired
	private GreetingRepo repo;

	public static void main(String[] args) {
		SpringApplication.run(GreetingMsApplication.class, args);
	}

	@Bean
	public CommandLineRunner runFirst(ApplicationContext ctx)
	{
		return  (args)-> {
			/*
			 * int beanCount = ctx.getBeanDefinitionCount();
			 * System.out.println("Bean Count = "+beanCount); List<String> beans =
			 * Arrays.asList(ctx.getBeanDefinitionNames()); for(String bean : beans) {
			 * System.out.println(bean); }
			 */
			
			Greeting g = new Greeting(100, "Good Morning", "TEMPORAL");
			repo.save(g);
			g = new Greeting(101, "Good Afternoon", "TEMPORAL");
			repo.save(g);
			g = new Greeting(102, "Later then !", "PARTING");
			repo.save(g);
			g = new Greeting(103, "What an honour", "RESPECT");
			repo.save(g);
			
			
		};
	}

}
