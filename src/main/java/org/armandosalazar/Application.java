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
	/**
	 * Dependency injection by field
	 */
	@Autowired
	@Qualifier("beanConnection")
	private Connection connection;
	private PostComponent postComponent;
	public PostService postService;

	public Application() {
	}

	/**
	 * Dependency injection by constructor
	 * Use when you need to inject a dependency that is required
	 * Use @Autowired when you have more than one constructor
	 */
	@Autowired
	public Application(@Qualifier("postComponent") PostComponent postComponent) {
		this.postComponent = postComponent;
	}

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

	/**
	 * Dependency injection by setter
	 * Use when you need modify the dependency before inject it
	 */
	@Autowired
	public void setPostService(@Qualifier("postServiceDecoradorImpl") PostService postService) {
		postService.addClass(Application.class);
		this.postService = postService;
	}
}
