package ParkingLotMain;

import ParkingException.ParkingLotException;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ParkingLot {
    Object vehicle;
    ParkingLotOwner parkingLotOwner;
    AirportSecurity airportSecurity;
    int parkingLotSize;
    static int currentNumber;
    static List<Object> parkingLotAttendant;
    static Map<Object,Integer> mapObj;
    public ParkingLot(int parkingLotSize) {
        this.parkingLotSize=parkingLotSize;
        parkingLotAttendant=new LinkedList<>();
        mapObj=new HashMap<>();
        parkingLotOwner=new ParkingLotOwner();
        airportSecurity=new AirportSecurity();
        currentNumber =0;
    }

    public void parkVehicle(Object vehicle) {
        if(this.currentNumber ==this.parkingLotSize) {
            this.updateObservers(true);
        }
        parkingLotAttendant.add(vehicle);
        mapObj.put(vehicle,currentNumber);
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
            mapObj.remove(vehicle);
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

    public int getPositionOfCar(Object name){
        return mapObj.get(name);
    }

    public String getTimeOfParking(Vehicle carObj){
        return carObj.timeOfParking;
    }

    public void updateObservers(boolean status){
        parkingLotOwner.capacityStatus(status);
        airportSecurity.capacityStatus(status);
    }

}
