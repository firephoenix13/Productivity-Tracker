package productivity.tracker.models;

public class Model extends ModelBase {
    private int count = 0;

    public void addOneToCount() {
        count++;
    }

    public int getCount() {
        return count;
    }
}