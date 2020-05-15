package p3.jdbctemplate.dao;

public interface CatDAO extends JpaRepository<Cat, Long> {
	public Optional<List<Cat>> findByType(String type);
}
