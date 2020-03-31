package ParkingLotMain;

import Interfaces.ObserverInterface;


public class AirportSecurity implements ObserverInterface {
    public static boolean parkingLotCapacity=false;

    @Override
    public void updateObservers(boolean status) {
        parkingLotCapacity=status;
    }

    @Override
    public boolean isCapacityFull() {
        return parkingLotCapacity;
    }
}
