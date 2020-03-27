package ParkingLotMain;

public class ClassToTest {
    ParkingLot parkingLot;

    public ClassToTest(ParkingLot parkingLot) {
        this.parkingLot=parkingLot;
    }
    public boolean isVehicleParked(Vehicle vehicle){
        return this.parkingLot.isVehicleParked(vehicle);
    }
    public boolean isVehicleUnParked(Vehicle vehicle){
        return this.parkingLot.isVehicleUnParked(vehicle);
    }
}
