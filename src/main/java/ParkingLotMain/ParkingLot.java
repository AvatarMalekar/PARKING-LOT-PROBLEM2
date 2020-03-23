package ParkingLotMain;

import ParkingException.ParkingLotException;

public class ParkingLot {
    Object vehicle;
    ParkingLotOwner parkingLotOwner;
    AirportSecurity airportSecurity;

    public ParkingLot() {
        parkingLotOwner=new ParkingLotOwner();
        airportSecurity=new AirportSecurity();
    }

    public void parkVehicle(Object vehicle) {
        if(this.vehicle!=null)
            throw new ParkingLotException("Parking Lot is Full");
        this.vehicle=vehicle;
        this.updateObservers(true);
    }

    public boolean isVehicleParked(Object vehicle){
        if(this.vehicle.equals(vehicle))
            return true;
        return false;
    }
    public void unParkVehicle(Object vehicle) {
        if(this.vehicle==null)
            throw new ParkingLotException("Parking Lot is Empty");
        if(this.vehicle.equals(vehicle))
            this.vehicle=null;
        this.updateObservers(false);
    }

    public boolean isVehicleUnParked() {
        if(this.vehicle==null)
            return true;
        return false;
    }
    public void updateObservers(boolean status){
        parkingLotOwner.capacityStatus(status);
        airportSecurity.capacityStatus(status);
    }

}
