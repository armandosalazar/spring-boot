package org.armandosalazar;

import org.armandosalazar.model.Connection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.logging.Logger;

@SpringBootApplication()
public class Application implements CommandLineRunner {
	private final Logger LOG = Logger.getLogger(Application.class.getName());
	@Autowired
	@Qualifier("beanConnection")
	private Connection connection;
	@Autowired
	private String hello;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) {
		LOG.info("🚀::run()");
		LOG.info(connection.toString());
		LOG.info(hello);
	}
}
