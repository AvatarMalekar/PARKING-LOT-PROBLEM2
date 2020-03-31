package ParkingLotMain;

public class ParkingLotObserver {
    boolean status;

    ParkingLotOwner parkingLotOwner;
    AirportSecurity airportSecurity;

    public ParkingLotObserver(boolean status) {
        this.status=status;
        parkingLotOwner=new ParkingLotOwner();
        airportSecurity=new AirportSecurity();
        updateObservers(status);
    }

    public void updateObservers(boolean status){
        parkingLotOwner.capacityStatus(status);
        airportSecurity.capacityStatus(status);
    }
}
