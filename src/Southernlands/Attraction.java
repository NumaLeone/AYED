package Southernlands;

import List.DynamicList;
import Queue.DynamicQueue;
import Queue.StaticQueue;

public class Attraction {

   private int capacity;
    private String id;
    private DynamicQueue<Client> normalQueue;
    private StaticQueue<Client> fastPassQueue;
    private int popularitry;
    private DynamicList<Client> peopleIn;


    public Attraction(String id, int capacity){
        this.id = id;
        this.capacity = capacity;
        normalQueue = new DynamicQueue<Client>();
        fastPassQueue = new StaticQueue<Client>(20);
        popularitry = 10;
    }

    public void enqueueClient(Client client){
        if(client.hasFp){
            if(!fastPassQueue.isFull()){
                fastPassQueue.enqueue(client);
                client.useFastPass();
            }
        }
        normalQueue.enqueue(client);
    }

    public void getPeopleIn() {
        for (int i = 0; i < capacity; i++) {
            if (!fastPassQueue.isEmpty()) {
                peopleIn.insertNext(fastPassQueue.peek());
                fastPassQueue.dequeue();
            } else if (!normalQueue.isEmpty()) {
                peopleIn.insertNext(normalQueue.peek());
                normalQueue.dequeue();
            }

        }
    }

    public void getPeopleOut(){
        peopleIn = new DynamicList<Client>();
    }

    public int getTotalOfWaiting(){
        return fastPassQueue.amount() + normalQueue.amount();
    }

    public int getPopularitry (int amountOfClientsWaiting) {
        if (amountOfClientsWaiting<9) return 10;
        else if(amountOfClientsWaiting<18) return 9;
        else if(amountOfClientsWaiting<27) return 8;
        else if(amountOfClientsWaiting<36) return 7;
        else if(amountOfClientsWaiting<45) return 6;
        else if(amountOfClientsWaiting<54) return 5;
        else if(amountOfClientsWaiting<63) return 4;
        else if(amountOfClientsWaiting<72) return 3;
        else if(amountOfClientsWaiting<80) return 2;
        else return 1;
    }


}
