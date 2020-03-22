import ParkingLotMain.ParkingLot;
import org.junit.Assert;
import org.junit.Test;

public class ParkingLotTest {
    @Test
    public void Welcome_message() {
        ParkingLot parkingLot=new ParkingLot();
        parkingLot.showWelcomeMessage();
    }
}
