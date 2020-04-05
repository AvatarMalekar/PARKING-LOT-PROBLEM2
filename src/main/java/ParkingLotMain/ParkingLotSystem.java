package ParkingLotMain;

import java.util.List;

public class ParkingLotSystem {
    static List<Vehicle> parkingLotOne;
    static List<Vehicle> parkingLotTwo;
    int lotSize;

    public ParkingLotSystem(int lotSize) {
        this.lotSize = lotSize;
    }

    public void initializeMap(){
        for(int i = 0; i< lotSize; i++){
            parkingLotOne.add(null);
            parkingLotTwo.add(null);}
    }
    public int listSize(){
        int listSize=0;
        for(int i = 0; i< lotSize; i++){
            if(parkingLotOne.get(i)!=null)
                listSize++; }
        return listSize;
    }

    public int listTwoSize(){
        int listSize=0;
        for(int i = 0; i< lotSize; i++){
            if(parkingLotTwo.get(i)!=null)
                listSize++; }
        return listSize;
    }

    public String decideWhichLot(){
        if(this.listSize()>this.listTwoSize())
            return "parkingLotTwo";
        return "parkingLotOne";
    }
}