package ParkingLotMain;

import java.util.ArrayList;
import java.util.List;

public class PoliceDepartment {
     int size;

    public PoliceDepartment(int parkingLotSize) {
        this.size=parkingLotSize;
    }

    public ArrayList<Integer> getColour(String colour){
        ArrayList<Integer> policeList=new ArrayList<>();
        for(int i=0;i<size;i++) {
           if(ParkingLot.parkingLotOne.get(i)!=null){
            if(ParkingLot.parkingLotOne.get(i).colour==colour)
                policeList.add(ParkingLot.parkingLotOne.indexOf(ParkingLot.parkingLotOne.get(i)));}
           if(ParkingLot.parkingLotTwo.get(i)!=null){
            if(ParkingLot.parkingLotTwo.get(i).colour==colour)
                policeList.add(ParkingLot.parkingLotTwo.indexOf(ParkingLot.parkingLotTwo.get(i)));}
        }
        return policeList;
    }
}
