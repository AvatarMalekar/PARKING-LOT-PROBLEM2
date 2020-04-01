import ParkingLotMain.MockitoForTest;
import ParkingLotMain.ParkingLot;
import ParkingLotMain.Vehicle;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.mockito.Mockito.when;

public class MockitoTest {
    Vehicle vehicle=new Vehicle();
    @Mock
    ParkingLot parkingLot;

    @Rule
    public MockitoRule mockitoRule= MockitoJUnit.rule();

    @Test
    public void mockito_for_parkingVehicle() {
        MockitoForTest mockitoForTest =new MockitoForTest(parkingLot);
        when(parkingLot.isVehicleParked(vehicle)).thenReturn(true);
        boolean vehicleParked = mockitoForTest.isVehicleParked(vehicle);
        Assert.assertTrue(vehicleParked);
    }

    @Test
    public void mockito_for_unParkingVehicle() {
        MockitoForTest mockitoForTest =new MockitoForTest(parkingLot);
        when(parkingLot.isVehicleUnParked(vehicle)).thenReturn(true);
        boolean isVehicleUnParked = mockitoForTest.isVehicleUnParked(vehicle);
        Assert.assertTrue(isVehicleUnParked);
    }
}
