package ParkingLotMain;

public class ParkingLotOwner {
    public static boolean parkingLotCapacity=false;

    public void capacityStatus(boolean status){
        parkingLotCapacity=status;
    }
    public boolean isCapacityFull(){
        return parkingLotCapacity;
    }
}
