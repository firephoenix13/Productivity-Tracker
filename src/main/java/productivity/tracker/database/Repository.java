package productivity.tracker.database;

public interface Repository<T> {

	void add(T item);

	void update(T item);

	void remove(T item);

	// List<T> query(Specification specification);
}
