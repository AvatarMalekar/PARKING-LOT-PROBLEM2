package ParkingLotMain;

import Interfaces.ParkingLotInterface;

public class ParkingLotOwner implements ParkingLotInterface {
    public static boolean parkingLotCapacity=false;

    public void capacityStatus(boolean status){
        parkingLotCapacity=status;
    }
    public boolean isCapacityFull(){
        return parkingLotCapacity;
    }
}