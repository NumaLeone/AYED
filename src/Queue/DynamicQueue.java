package Queue;



public class DynamicQueue<T> implements Queue<T> {
    private Node front;
    private Node back;
    private int amount, size;

    public DynamicQueue(int size) {
        this.size = size;
        this.amount = 0;
        this.front = null;
        this.back = null;
    }

    public DynamicQueue(){
        this.size = 1000000000;
        this.amount = 0;
        this.front = null;
        this.back = null;
    }

    @Override
    public void enqueue(T t) {
        Node newNode = new Node(t);
        newNode.next = null;
        if(amount < size){
            if(isEmpty()){
                front = newNode;
                back = newNode;
            } else {
                back.next = newNode;
                back = newNode;
            }
            amount++;
        } else {
            throw new IllegalStateException("Queue full");
        }
    }

    @Override
    public T dequeue() {
        if(!isEmpty()){
            T data = (T) front.data;
            if(front == back){
                front = null;
                back = null;
            } else {
                front = front.next;
            }
            amount--;
            return data;
        } else {
            throw new IllegalStateException("Empty queue");
        }
    }

    @Override
    public T peek() {
        if(isEmpty()) throw new RuntimeException("There is not element in queue");
        return (T) front.data;
    }

    @Override
    public boolean isEmpty() {
        return amount == 0;
    }

    public boolean isFull() {
        return amount == size;
    }

    @Override
    public int amount() {
        return amount;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void empty() {
        front = null;
        back = null;
        amount = 0;
    }
}
