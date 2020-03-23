package ParkingLotMain;

public class AirportSecurity {
    public static boolean parkingLotCapacity=false;

    public void capacityStatus(boolean status){
        parkingLotCapacity=status;
    }
    public boolean isCapacityFull(){
        return parkingLotCapacity;
    }
}
