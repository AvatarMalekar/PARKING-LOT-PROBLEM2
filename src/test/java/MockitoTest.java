//import ParkingLotMain.ClassToTest;
//import ParkingLotMain.ParkingLot;
//import ParkingLotMain.Vehicle;
//import org.junit.Assert;
//import org.junit.Rule;
//import org.junit.Test;
//import org.mockito.Mock;
//import org.mockito.junit.MockitoJUnit;
//import org.mockito.junit.MockitoRule;
//
//import static org.mockito.Mockito.when;
//
//public class MockitoTest {
////    Vehicle vehicle=new Vehicle("4:40");
//    @Mock
//    ParkingLot parkingLot;
//
//    @Rule
//    public MockitoRule mockitoRule= MockitoJUnit.rule();
//
//    @Test
//    public void mockito_for_parkingVehicle() {
//        ClassToTest classToTest=new ClassToTest(parkingLot);
//        when(parkingLot.isVehicleParked(vehicle)).thenReturn(true);
//        boolean vehicleParked = classToTest.isVehicleParked(vehicle);
//        Assert.assertTrue(vehicleParked);
//    }
//
//    @Test
//    public void mockito_for_unParkingVehicle() {
//        ClassToTest classToTest=new ClassToTest(parkingLot);
//        when(parkingLot.isVehicleUnParked(vehicle)).thenReturn(true);
//        boolean isVehicleUnParked = classToTest.isVehicleUnParked(vehicle);
//        Assert.assertTrue(isVehicleUnParked);
//    }
//}
