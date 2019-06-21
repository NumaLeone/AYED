package Stack;


public class StaticStack<T> implements iStack<T> {
    private T[] stack;
    private int top = 0;

    public StaticStack() {
        stack = (T[]) new Object[1];
    }

    @Override
    public void push(T element) {
        if(top>=stack.length)
            makeMyStackBigger();
        stack[top++] = element;
    }

    @Override
    public void pop() {
        if(!isEmpty()) {
            stack[--top] = null;
        }
    }

    @Override
    public T peek() {
        return stack[top-1];
    }

    @Override
    public boolean isEmpty() {
        return top == 0;
    }

    public void makeMyStackBigger(){
        T[] aux = (T[]) new Object[stack.length*2];
        for (int i = 0; i < stack.length ; i++) {
            aux[i]=stack[i];
        }
        stack=aux;
    }

    @Override
    public int size() {
        return top;
    }

    @Override
    public void empty() {
        stack = (T[]) new Object[1];
        top = 0;
    }

    private void newStack(){
        T[] stack = (T[]) new Object[0];
    }
}
