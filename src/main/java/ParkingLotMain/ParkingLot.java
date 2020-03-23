package ParkingLotMain;

import ParkingException.ParkingLotException;

public class ParkingLot {
    Object vehicle;
    ParkingLotOwner parkingLotOwner;

    public ParkingLot() {
        parkingLotOwner=new ParkingLotOwner();
    }

    public void parkVehicle(Object vehicle) {
        if(this.vehicle!=null)
            throw new ParkingLotException("Parking Lot is Full");
        this.vehicle=vehicle;
        parkingLotOwner.capacityStatus(true);
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
        parkingLotOwner.capacityStatus(false);
    }

    public boolean isVehicleUnParked() {
        if(this.vehicle==null)
            return true;
        return false;
    }

}
