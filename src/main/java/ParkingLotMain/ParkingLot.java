package ParkingLotMain;

import ParkingException.ParkingLotException;

public class ParkingLot {
    Object vehicle;

    public void parkVehicle(Object vehicle) {
        if(this.vehicle!=null)
            throw new ParkingLotException("Parking Lot is Full");
        this.vehicle=vehicle;
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
    }

    public boolean isVehicleUnParked() {
        if(this.vehicle==null)
            return true;
        return false;
    }
}
