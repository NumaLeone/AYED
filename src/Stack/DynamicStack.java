package Stack;


public class DynamicStack<T> implements iStackDynamic<T> {

    Node<T> tope;

    @Override
    public void push (T o) {
        Node<T> tmp = new Node<T>(o);
        tmp.next=tope;
        tope = tmp;
    }

    @Override
    public void pop() {
        if(tope != null){
            tope = tope.next;
        }
    }

    @Override
    public T peek() {
        return tope.data;
    }

    @Override
    public boolean isEmpty() {
        return (tope==null);
    }


    @Override
    public void empty() {
        tope=null;
    }
}
