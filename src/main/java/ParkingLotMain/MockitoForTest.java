package ParkingLotMain;

public class MockitoForTest {
    ParkingLot parkingLot;

    public MockitoForTest(ParkingLot parkingLot) {
        this.parkingLot=parkingLot;
    }
    public boolean isVehicleParked(Vehicle vehicle){
        return this.parkingLot.isVehicleParked(vehicle);
    }
    public boolean isVehicleUnParked(Vehicle vehicle){
        return this.parkingLot.isVehicleUnParked(vehicle);
    }
}
