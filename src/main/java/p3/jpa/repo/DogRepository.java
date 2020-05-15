package p3.jpa.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import p3.jpa.model.Dog;

public interface DogRepository extends JpaRepository<Dog, Long> {
	public Optional<List<Dog>> findByType(String type);
}
