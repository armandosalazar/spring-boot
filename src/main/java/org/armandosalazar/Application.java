package org.armandosalazar;

import org.armandosalazar.component.PostComponent;
import org.armandosalazar.model.Connection;
import org.armandosalazar.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.logging.Logger;

@SpringBootApplication()
public class Application implements CommandLineRunner {
	@Autowired
	@Qualifier("beanConnection")
	private Connection connection;
	@Autowired
	@Qualifier("postComponent")
	private PostComponent postComponent;
	@Autowired
	@Qualifier("postServiceDecoradorImpl")
	public PostService postService;
	private final Logger LOG = Logger.getLogger(Application.class.getName());

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) {
		LOG.info("🚀::run()");
		LOG.info(connection.toString());
		postService.validatePosts(postComponent.getPosts())
				.forEach(post -> LOG.info(post.toString()));
	}
}
