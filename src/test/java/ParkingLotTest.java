import EnumPackage.DriverType;
import ParkingLotMain.AirportSecurity;
import ParkingLotMain.ParkingLot;
import ParkingLotMain.ParkingLotOwner;
import ParkingLotMain.Vehicle;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ParkingLotTest {
    ParkingLot parkingLot;
    Vehicle vehicle;
    Vehicle vehicle2;
    ParkingLotOwner parkingLotOwner;
    AirportSecurity airportSecurity;

    @Before
    public void setUp() throws Exception {
        parkingLotOwner=new ParkingLotOwner();
        parkingLot=new ParkingLot(1);
        vehicle=new Vehicle("Tesla","9:00");
        vehicle2=new Vehicle("Range Rover","10:10");
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
        parkingLot.parkVehicle(vehicle2);
        boolean capacityFull = parkingLotOwner.isCapacityFull();
        Assert.assertTrue(capacityFull);
    }

    @Test
    public void givenWhenParkingLotIsFull_ShouldInformTheAirportSecurity() {
        parkingLot.parkVehicle(vehicle);
        parkingLot.parkVehicle(vehicle2);
        boolean capacityFull = airportSecurity.isCapacityFull();
        Assert.assertTrue(capacityFull);
    }

    @Test
    public void givenWhenParkingLotHasSpace_ShouldInformTheOwner() {
        parkingLot.parkVehicle(vehicle);
        parkingLot.unParkVehicle(vehicle);
        boolean hasMoreCapacity = parkingLotOwner.hasMoreCapacity();
        Assert.assertTrue(hasMoreCapacity);
    }

    @Test
    public void givenParkingLot_hasSpace_ShouldReturn_Size() {
        parkingLot.parkVehicle(vehicle);
        int size = parkingLot.getSize();
        Assert.assertEquals(0,size);
    }

    @Test
    public void givenVehicleIfPresent_shouldReturn_Address() {
        parkingLot.parkVehicle(vehicle);
        int position = parkingLot.getPositionOfCar(vehicle);
        Assert.assertEquals(0,position);
    }

    @Test
    public void givenVehicleWhen_parkedShould_StoreTime() {
        Vehicle car1=new Vehicle("BMW","8.00");
        parkingLot.parkVehicle(car1);
        String timeOfParking = parkingLot.getTimeOfParking(car1);
        Assert.assertEquals("8.00",timeOfParking);
    }

    @Test
    public void givenVehicleWhen_parkedShould_AcceptType() {
      Vehicle car1=new Vehicle("Mercedes","8.10");
        parkingLot.parkVehicle(car1,DriverType.NORMAL);
        boolean isVehicleParked = parkingLot.isVehicleParked(car1);
        Assert.assertTrue(isVehicleParked);
    }

}