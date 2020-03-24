package ParkingLotMain;

import Interfaces.ParkingLotInterface;
import ParkingException.ParkingLotException;

public class ParkingLotOwner implements ParkingLotInterface {
    public static boolean parkingLotCapacity=false;

    public void capacityStatus(boolean status){
        parkingLotCapacity=status;
    }
    public boolean isCapacityFull(){
        return parkingLotCapacity;
    }

    public boolean hasMoreCapacity(){
        return !this.isCapacityFull();
    }
}
