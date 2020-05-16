package p3.init;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import p3.jpa.model.Dog;
import p3.jpa.repo.DogRepository;

@Component
public class InitDb4dogs implements CommandLineRunner {
	private static final Logger logger = LoggerFactory.getLogger(InitDb4dogs.class);

	@Autowired
	private DogRepository dogRepository;
	
	public void run(String... args) throws Exception {
		logger.info("BEF InitDb4dogs will make sure 'dogs' table has rows");
			
		long countOfDogs = dogRepository.count();
		if (countOfDogs == 0) {
			logger.info("InitDb4dogs will initialize 'dogs' table with 10 rows");
			dogRepository.save(new Dog ("White", "Maltiese"));
			dogRepository.save(new Dog ("Yellow", "Chihuahua"));
			dogRepository.save(new Dog ("Black", "GermanShepherd"));
			dogRepository.save(new Dog ("Brown", "Yorki"));
			dogRepository.save(new Dog ("Milky", "Kangal"));
		} else {
			logger.info("InitDb4dogs will not do anything since 'dogs' table already has rows");
		}
	}

}
