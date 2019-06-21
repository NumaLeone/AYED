package Stack;

public interface iStackDynamic<T> {
    void push(T t);
    void pop();
    T peek();
    boolean isEmpty();
    void empty();
}
