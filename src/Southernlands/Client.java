package Southernlands;

public class Client {
    boolean hasFp;
    int leavingTime;
    int fpCharges;
    Attraction[] parkAttractions;
    Park park;

    public Client(Park park) {
        hasFp = Math.random() >= 0.7;
        if (hasFp) {
            fpCharges = 8;
        }
        parkAttractions = park.theAttractions;
        this.park = park;
    }

    void useFastPass() {
        fpCharges--;
    }

    public void leave(int time) {
        leavingTime = time;
        park.exit(this);
    }

    public Attraction chooseAttraction() {
        int n = 0;
        for (int i = 0; i < parkAttractions.length; i++) {
            if (parkAttractions[i].getPopularitry(parkAttractions[i].getTotalOfWaiting()) < parkAttractions[n].getPopularitry(parkAttractions[n].getTotalOfWaiting())) {
                n = i;
            }
        }
        return parkAttractions[n];
    }


    public void decide(int time) {
        double random = Math.random();
        if (time < 540) {
            if (random >= 0.4) {
                this.chooseAttraction();
            } else if (random < 0.4 && random >= 0.2) {
                this.leave(time);
            }

        } else {
            if (random > 0.5) {
                this.chooseAttraction();
            } else {
                this.leave(time);

            }
        }
    }
}
