package p3.jpa.repo;

import p3.jdbctemplate.dao.JpaRepository;

public interface DogRepository extends JpaRepository<Dog, Long> {
	public Optional<List<Dog>> findByType(String type);
}
