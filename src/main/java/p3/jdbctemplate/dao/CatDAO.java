package p3.jdbctemplate.dao;

import java.util.List;
import java.util.Optional;

import p3.jdbctemplate.model.Cat;

public interface CatDAO extends JpaRepository<Cat, Long> {
	public Optional<List<Cat>> findByType(String type);
}
