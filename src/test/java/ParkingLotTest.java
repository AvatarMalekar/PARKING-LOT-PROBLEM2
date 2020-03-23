import ParkingLotMain.AirportSecurity;
import ParkingLotMain.ParkingLot;
import ParkingLotMain.ParkingLotOwner;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ParkingLotTest {
    ParkingLot parkingLot;
    Object vehicle;
    ParkingLotOwner parkingLotOwner;
    AirportSecurity airportSecurity;
    
    @Before
    public void setUp() throws Exception {
        parkingLotOwner=new ParkingLotOwner();
        parkingLot=new ParkingLot();
        vehicle=new Object();
        airportSecurity=new AirportSecurity();
    }

    @Test
    public void givenVehicle_WhenParked_ShouldReturnTrue() {
        parkingLot.parkVehicle(vehicle);
        boolean isVehicleParked = parkingLot.isVehicleParked(vehicle);
        Assert.assertEquals(true,isVehicleParked);
    }

    @Test
    public void givenVehicle_WhenUnParked_ShouldReturn_True() {
        parkingLot.parkVehicle(vehicle);
        parkingLot.unParkVehicle(vehicle);
        boolean isVehicleUnParked = parkingLot.isVehicleUnParked();
        Assert.assertTrue(isVehicleUnParked);
    }

    @Test
    public void givenWhenParkingLotIsFull_ShouldInformTheOwner() {
        parkingLot.parkVehicle(vehicle);
        boolean capacityFull = parkingLotOwner.isCapacityFull();
        Assert.assertTrue(capacityFull);
    }

    @Test
    public void givenWhenParkingLotIsFull_ShouldInformTheAirportSecurity() {
        parkingLot.parkVehicle(vehicle);
        boolean capacityFull = airportSecurity.isCapacityFull();
        Assert.assertTrue(capacityFull);
    }
}
