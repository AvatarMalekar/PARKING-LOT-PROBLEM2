package ParkingLotMain;

import java.util.List;

public class ParkingLotSystem {
    static List<Vehicle> parkingLotOne;
    static List<Vehicle> parkingLotTwo;
    int size;

    public ParkingLotSystem(int size) {
        this.size = size;
    }

    public void initializeMap(){
        for(int i=0;i<size;i++){
            parkingLotOne.add(null);
            parkingLotTwo.add(null);}
    }

    public int listSize(){
        int listSize=0;
        for(int i=0;i<size;i++){
            if(parkingLotOne.get(i)!=null)
                listSize++;
        }
        return listSize;
    }

    public int listTwoSize(){
        int listSize=0;
        for(int i=0;i<size;i++){
            if(parkingLotTwo.get(i)!=null)
                listSize++;
        }
        return listSize;
    }

    public String decideWhichLot(){
        if(this.listSize()>this.listTwoSize())
            return "parkingLotTwo";
        return "parkingLotOne";
    }
}