package Southernlands;

import List.DynamicList;

import java.util.Random;

public class Park {

    Attraction[] theAttractions;
    private DynamicList<Attraction> attractionsOpen;
    DynamicList<Client> hub;
    int fastPassSold;
    int normalPassSold;
    DynamicList<Client> clientsInPark;

    public Park(Attraction[] attractions) {
        int randomOpen = (int)(Math.random()*(attractions.length-4)+4);
        int count=0;
        while(count<randomOpen){
            int randomAttraction = (int)(Math.random()*attractions.length);
            if(attractions[randomAttraction]!=null){
                attractionsOpen.insertNext(attractions[randomAttraction]);
                attractions[randomAttraction]=null;
                count++;
            }
        }

    }

    public void enterClient(int time) {
        for (int i = 0; i < 5; i++) {
            Client client = new Client(this);
            if(client.hasFp){
                fastPassSold++;
            }else{
                normalPassSold++;
            }
            clientsInPark.insertNext(client);
            client.decide(time);
        }

    }

    public void goToHub(Client client){
        hub.insertNext(client);
    }



    public void exit(Client client){
        for(int i=0;i<clientsInPark.size();i++){
            clientsInPark.goTo(i);
            if(client.equals(clientsInPark.getActual())){
                clientsInPark.remove();
            }
        }
    }

}
