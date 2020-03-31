package ParkingLotMain;

public class ObserverInitialization {

    boolean status;
    ParkingLotOwner parkingLotOwner=new ParkingLotOwner();
    AirportSecurity airportSecurity=new AirportSecurity();
    ParkingLotObserver parkingLotObserver;

    public ObserverInitialization(boolean status) {
        this.status=status;
        parkingLotObserver=new ParkingLotObserver(status);
        this.operate();
    }

    public void operate(){
        parkingLotObserver.registerObserver(parkingLotOwner);
        parkingLotObserver.registerObserver(airportSecurity);
        parkingLotObserver.notifyObservers();
    }

}
