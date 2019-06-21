package Southernlands;

public class Client {
    boolean hasFp;
    int leavingTime;
    int fpCharges;

    public Client(){
        hasFp =Math.random()>0.7;
        if(hasFp){
            fpCharges = 8;
        }
    }


}
