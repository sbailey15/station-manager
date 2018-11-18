package stations.manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Application {

	
	private final StationsRepository stRepository;

    public Application(StationsRepository repository) {
        this.stRepository = repository;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
