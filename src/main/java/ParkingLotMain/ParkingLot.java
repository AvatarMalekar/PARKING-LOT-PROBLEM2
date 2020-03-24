package ParkingLotMain;

import ParkingException.ParkingLotException;

import java.util.LinkedList;
import java.util.List;

public class ParkingLot {
    Object vehicle;
    ParkingLotOwner parkingLotOwner;
    AirportSecurity airportSecurity;
    int parkingLotSize;
    static int currentNumber;
    static List<Object> parkingLotAttendant;
    public ParkingLot(int parkingLotSize) {
        this.parkingLotSize=parkingLotSize;
        parkingLotAttendant=new LinkedList<>();
        parkingLotOwner=new ParkingLotOwner();
        airportSecurity=new AirportSecurity();
        currentNumber =0;
    }

    public void parkVehicle(Object vehicle) {
        if(this.currentNumber ==this.parkingLotSize) {
            this.updateObservers(true);
        }
        parkingLotAttendant.add(vehicle);
        currentNumber++;

    }

    public boolean isVehicleParked(Object vehicle){
        if(parkingLotAttendant.contains(vehicle))
            return true;
        return false;
    }
    public void unParkVehicle(Object vehicle) {
        if(this.currentNumber==0){
            throw new ParkingLotException("Parking Lot is Empty");
        }
        if(parkingLotAttendant.contains(vehicle)) {
            parkingLotAttendant.remove(vehicle);
            this.updateObservers(false);
            currentNumber--;
        }
    }

    public boolean isVehicleUnParked() {
        if(!parkingLotAttendant.contains(vehicle))
            return true;
        return false;
    }
    public int getSize(){
        return (this.parkingLotSize-parkingLotAttendant.size());
    }
    public void updateObservers(boolean status){
        parkingLotOwner.capacityStatus(status);
        airportSecurity.capacityStatus(status);
    }

}
