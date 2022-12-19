package ru.gb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.gb.Services.SessionFactoryUtils;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {

		SessionFactoryUtils sessionFactoryUtils = new SessionFactoryUtils();
		sessionFactoryUtils.init();

		SpringApplication.run(Application.class, args);

	}
}
