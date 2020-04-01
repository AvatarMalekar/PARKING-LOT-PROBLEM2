package ParkingLotMain;

import java.util.Map;

public class ParkingLotSystem {
    static Map<Integer, Vehicle> parkingLots;
    int size;

    public ParkingLotSystem(int size) {
        this.size=size;
    }
    public void initializeMap(){
        for(Map.Entry<Integer,Vehicle> entry: parkingLots.entrySet())
            parkingLots.put(0,null);
    }
}