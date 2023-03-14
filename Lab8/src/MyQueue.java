import java.io.Serializable;
import java.util.ArrayList;

public class MyQueue implements Serializable {

    private ArrayList<Object> queue;

    public MyQueue() {
        this.queue = new ArrayList<Object>();
    }

    public void enqueue(Object o) {
        queue.add(o);
    }

    public Object dequeue() {
        if (queue.isEmpty()) {
            return null;
        }
        return queue.remove(0);
    }

    public int size() {
        return queue.size();
    }
}
