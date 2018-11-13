package stations.manager;


import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
class LoadDatabase {

	@Bean
	CommandLineRunner initDatabase(StationsRepository repository) {
		return args -> {
			repository.save(new Stations("klbj", "iheartRock",true));
			repository.save(new Stations("101.7", "iheartCountry",true));
		};
	}
}
