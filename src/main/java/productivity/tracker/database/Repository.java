package productivity.tracker.database;

import java.util.List;

public interface Repository<T> {

	void add(T item);

	List<T> query(String sql);

	void update(T item);

	void remove(T item);
}
