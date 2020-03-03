package productivity.tracker.models;

/**
 * A minimal class to maintain some state 
 */
public class Model extends ModelBase {
    private int count = 0;

    public void addOneToCount() {
        count++;
    }

    public int getCount() {
        return count;
    }
}