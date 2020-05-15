package p3.jdbctemplate.dao;

public interface JpaRepository<T, ID> {
	public List<T> findAll();
	public Optional<T> findById();

}
