package productivity.tracker.database;

import java.util.List;

public interface Repository<T> {

	public List<T> query(String sql);

	public List<T> getAll();

	public void add(T item);

	public void update(T item);

	public void remove(T item);
}
