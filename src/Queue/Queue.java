package Queue;

public interface Queue<T> {
    void enqueue(T t);
    T dequeue();
    boolean isEmpty();
    int amount();
    int size();
    void empty();
    T peek();
}
