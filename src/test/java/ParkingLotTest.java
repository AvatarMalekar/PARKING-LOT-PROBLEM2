import ParkingException.ParkingLotException;
import ParkingLotMain.ParkingLot;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ParkingLotTest {
    ParkingLot parkingLot;
    Object vehicle;
    
    @Before
    public void setUp() throws Exception {
        parkingLot=new ParkingLot();
        vehicle=new Object();
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
}
