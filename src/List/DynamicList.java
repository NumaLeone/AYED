package List;
//import struct.istruct.list.GeneralList;
//import struct.istruct.list.List;
public class DynamicList<T> implements List<T> {
    private Node<T> head, window, sentinel;
    private int size;
    public DynamicList(){
        head = new Node<>();
        sentinel = new Node<>();
        head.next = sentinel;
        window = head;
        size = 0;
    }
    @Override
    public T getActual() {
        return window.obj;
    }
    @Override
    public int getActualPosition() {
        int pos = 0;
        if (!isVoid()) {
            Node<T> aux = head;
            for (; aux.next != window; pos++) aux = aux.next;
        }
        return pos;
    }
    @Override
    public boolean isVoid() {
        return head.next == sentinel;
    }
    @Override
    public boolean endList() {
        return window.next == sentinel;
    }
    @Override
    public GeneralList<T> clone() {
        return null;
    }
    @Override
    public void insertPrev(T obj) {
        if (!isVoid()) {
            goBack();
        }
        insertNext(obj);
    }
    @Override
    public void insertNext(T obj) {
        window.next = new Node<>(obj, window.next);
        window = window.next;
        size++;
    }
    @Override
    public void goNext() {
        if(window.next == sentinel) throw new IndexOutOfBoundsException("Reached the end of this ListPackage");
        window = window.next;
    }
    @Override
    public void goPrev() {
        if(window == head.next) throw new IndexOutOfBoundsException("Reached the beginning of this ListPackage");
        goBack();
    }
    private void goBack(){
        Node<T> aux = head;
        while(window != aux.next){
            aux = aux.next;
        }
        window = aux;
    }
    @Override
    public void goTo(int index) {
        window = head.next;
        for(int i = 0; i < index; i++){
            window = window.next;
        }
    }
    @Override
    public void remove() {
        if(isVoid()) throw new NullPointerException("This ListPackage is empty");
        goBack();
        window.next = window.next.next;
        window = window.next;
        if(window == sentinel) goBack();
        size--;
    }
    @Override
    public int size() {
        return size;
    }
    private static class Node<E> {
        E obj;
        Node<E> next;
        Node() {
            obj = null;
            next = null;
        }
        Node(E o) {
            obj = o;
            next = null;
        }
        Node(E o, Node<E> next) {
            this(o);
            this.next = next;
        }
        boolean hasNoObj() {
            return obj == null;
        }
    }
}
