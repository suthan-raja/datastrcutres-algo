package com.data.algo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.env.Environment;

import java.util.Arrays;

@SpringBootApplication
public class AlgoApplication implements CommandLineRunner {

	private final ApplicationContext ctx;
	private final Environment env;

	AlgoApplication(Environment env, ApplicationContext context) {
		this.env = env;
		this.ctx = context;
	}

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(AlgoApplication.class);

		// Listener #1: Environment prepared (very early)
		app.addListeners((ApplicationListener<ApplicationEnvironmentPreparedEvent>) event -> {
			Environment env = event.getEnvironment();
			System.out.println("=== [EVENT] ApplicationEnvironmentPreparedEvent ===");
			String[] active = env.getActiveProfiles();
			System.out.println(" Profiles active at ENV PREPARE: " + (active.length == 0 ? "[default]" : String.join(",", active)));
			System.out.println(" server.port (from env): " + env.getProperty("server.port"));
			System.out.println(" property sources loaded (top -> bottom):");
			event.getEnvironment().getPropertySources().forEach(ps -> System.out.println("  - " + ps.getName()));
			System.out.println("===================================================\n");
		});

		// Listener #2: Application prepared (bean definitions loaded, context created but not refreshed)
		app.addListeners((ApplicationListener<ApplicationPreparedEvent>) event -> {
			var ctx = event.getApplicationContext();
			System.out.println("=== [EVENT] ApplicationPreparedEvent ===");
			System.out.println(" BeanDefinition count (registered, not instantiated): " + ctx.getBeanFactory().getBeanDefinitionCount());
			System.out.println(" BeanDefinition names (sample):");
			var names = ctx.getBeanDefinitionNames();
			for (int i = 0; i < Math.min(10, names.length); i++) {
				System.out.println("  - " + names[i]);
			}
			System.out.println("===================================================\n");
		});

		app.run(args);
	}

	@Override
	public void run(String... args) {
		System.out.println("\n=== [CommandLineRunner] Final summary ===");
		System.out.println("Active Profiles: " + Arrays.toString(env.getActiveProfiles()));
		System.out.println("Total beans registered: " + ctx.getBeanDefinitionCount());
		System.out.println("--- Beans (name -> class) ---");
		String[] names = ctx.getBeanDefinitionNames();
		Arrays.sort(names);
		for (String n : names) {
			try {
				Object b = ctx.getBean(n);
//				System.out.printf("%s -> %s\n", n, b.getClass().getName());
			} catch (Exception ex) {
				System.out.printf("%s -> [error getting bean: %s]\n", n, ex.getMessage());
			}
		}
		System.out.println("=== [CommandLineRunner] End ===\n");
	}

}
