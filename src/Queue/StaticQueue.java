package Queue;


public class StaticQueue<T> implements Queue<T> {
    private T[] array;
    private int front, back, size, amount;

    public StaticQueue(int size) {
        this.size = size;
        this.front = 0;
        this.back = 0;
        this.amount = 0;
        this.array = (T[]) new Object[size];
    }

    @Override
    public void enqueue(T t) {
        if(!isFull()){
            increment();
            amount++;
            array[back-1] = t;
            //System.out.println("enqueue: " + array[back-1]); //TODO: quitar
        }else{
            grow();
            enqueue(t);
        }
    }

    @Override
    public T dequeue() {
        T element = null;

        if(!isEmpty()){
            element = array[front];
            front++;
            amount--;
        }
        //System.out.println("dequeue: " + element); //TODO: quitar
        return element;
    }

    public void grow(){
        T[] newArray = (T[]) new Object[size*2];
        int index = 0;
        for (int i = front; i < size; i++) {
            newArray[index++] = array[i];
        }
        for (int i = back-1; i < front; i++) {
            newArray[index++] = array[i];
        }
        front = 0;
        back = size;
        array = newArray;
        size = newArray.length;
        //System.out.println(Arrays.toString(array)); //TODO: quitar
    }

    @Override
    public T peek() {
        return array[front];
    }

    @Override
    public boolean isEmpty() {
        return amount == 0;
    }

    public boolean isFull(){
        return size == amount;
    }

    @Override
    public int amount() {
        return this.amount;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void empty() {
        this.front = 0;
        this.back = 0;
        this.amount = 0;
    }

    private void increment(){
        if(back != size){
            back++;
        }else{
            if(amount < size){
                back = 1;
            } else{
                throw new IllegalStateException("TP4.Queue is full");
            }
        }
    }
}
