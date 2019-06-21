package Stack;

public interface iStack<T> {
    void push(T t);
    void pop();
    T peek();
    boolean isEmpty();
    int size();
    void empty();
}
