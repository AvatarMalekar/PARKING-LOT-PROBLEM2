import ParkingLotMain.ParkingLot;
import org.junit.Assert;
import org.junit.Test;

public class ParkingLotTest {
    @Test
    public void givenVehicle_WhenParked_ShouldReturnTrue() {
        ParkingLot parkingLot=new ParkingLot();
        boolean park = parkingLot.parkVehicle(new Object());
    }
}
