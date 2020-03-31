import EnumPackage.DriverType;
import ParkingException.ParkingLotException;
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
    Vehicle vehicle3;
    ParkingLotOwner parkingLotOwner;
    AirportSecurity airportSecurity;

    @Before
    public void setUp() throws Exception {
        parkingLotOwner=new ParkingLotOwner();
        parkingLot=new ParkingLot(1);
        vehicle=new Vehicle();
        vehicle2=new Vehicle();
        vehicle3=new Vehicle();
        airportSecurity=new AirportSecurity();
    }

    @Test
    public void givenVehicle_WhenParked_ShouldReturnTrue() {
        try {
            parkingLot.parkVehicle(vehicle);
            boolean isVehicleParked = parkingLot.isVehicleParked(vehicle);
            Assert.assertEquals(true, isVehicleParked);
        }
        catch(ParkingLotException e){
            e.printStackTrace();        }
    }

    @Test
    public void givenVehicle_WhenNull_ShouldThrowException() {
        try {
            parkingLot.parkVehicle(null);
        }
        catch(ParkingLotException e){
            Assert.assertEquals(ParkingLotException.ExceptionType.NULL_OBJECT_FOR_VEHICLE,e.type);
        }
    }

    @Test
    public void givenVehicle_WhenParkedAgain_withoutUnparking_ShouldThrowException() {
        try {
            parkingLot.parkVehicle(vehicle);
            parkingLot.parkVehicle(vehicle);
        }
        catch(ParkingLotException e){
            Assert.assertEquals(ParkingLotException.ExceptionType.VEHICLE_PARKED_ALREADY,e.type);
        }
    }
    @Test
    public void givenVehicle_WhenUnParked_ShouldReturn_True() {
        try{
            parkingLot.parkVehicle(vehicle);
            parkingLot.unParkVehicle(vehicle);
            boolean isVehicleUnParked = parkingLot.isVehicleUnParked(vehicle);
            Assert.assertTrue(isVehicleUnParked);}
        catch(ParkingLotException e){
            e.printStackTrace();
        }
    }

    @Test
    public void givenLot_isEmpty_shouldThrowException() {
        try{
            parkingLot.unParkVehicle(vehicle);
            boolean isVehicleUnParked = parkingLot.isVehicleUnParked(vehicle);
            Assert.assertTrue(isVehicleUnParked);}
        catch(ParkingLotException e){
            Assert.assertEquals(ParkingLotException.ExceptionType.PARKING_LOT_IS_EMPTY,e.type);
        }
    }

    @Test
    public void givenVehicleNull_WhenUnParked_ShouldThrowException() {
        try{
            parkingLot.parkVehicle(null);
            parkingLot.unParkVehicle(vehicle);
            boolean isVehicleUnParked = parkingLot.isVehicleUnParked(vehicle); }
        catch(ParkingLotException e){
            Assert.assertEquals(ParkingLotException.ExceptionType.NULL_OBJECT_FOR_VEHICLE,e.type);
        }
    }

    @Test
    public void givenWhenParkingLotIsFull_ShouldInformTheOwner() {
        try{
            parkingLot.parkVehicle(vehicle);
            parkingLot.parkVehicle(vehicle2);
            boolean capacityFull = parkingLotOwner.isCapacityFull();
            Assert.assertTrue(capacityFull);}
        catch(ParkingLotException e){
            e.printStackTrace();
        }
    }

    @Test
    public void givenWhenParkingLotIsFull_ShouldInformTheAirportSecurity() {
        try{
            parkingLot.parkVehicle(vehicle);
            parkingLot.parkVehicle(vehicle2);
            boolean capacityFull = airportSecurity.isCapacityFull();
            Assert.assertTrue(capacityFull);}
        catch(ParkingLotException e){
            e.printStackTrace();
        }
    }

    @Test
    public void givenWhenParkingLotHasSpace_ShouldInformTheOwner() {
        try {
            parkingLot.parkVehicle(vehicle);
            parkingLot.unParkVehicle(vehicle);
            boolean hasMoreCapacity = parkingLotOwner.hasMoreCapacity();
            Assert.assertTrue(hasMoreCapacity);
        }catch(ParkingLotException e){
            e.printStackTrace();
        }
    }

    @Test
    public void givenWhenParkingLot_IfOverflowed_ShouldThrowException() {
        try {
            parkingLot.parkVehicle(vehicle);
            parkingLot.parkVehicle(vehicle2);
            parkingLot.parkVehicle(vehicle3);
            boolean hasMoreCapacity = parkingLotOwner.hasMoreCapacity();
            Assert.assertTrue(hasMoreCapacity);
        }catch(ParkingLotException e){
            Assert.assertEquals(ParkingLotException.ExceptionType.PARKING_LOT_IS_FULL,e.type);
        }
    }
    @Test
    public void givenParkingLot_hasSpace_ShouldReturn_Size() {
        try{
            parkingLot.parkVehicle(vehicle);
            int size = parkingLot.getSize();
            Assert.assertEquals(0,size);}
        catch(ParkingLotException e){
            e.printStackTrace();
        }
    }

    @Test
    public void givenVehicleIfPresent_shouldReturn_Address() {
        try{
            parkingLot.parkVehicle(vehicle);
            int position = parkingLot.getPositionOfCar(vehicle);
            Assert.assertEquals(0,position);}
        catch(ParkingLotException e){
            e.printStackTrace();
        }
    }

    @Test
    public void givenVehicleIfAbsent_shouldThrowException() {
        try{
            parkingLot.parkVehicle(vehicle);
            int position = parkingLot.getPositionOfCar(vehicle);
        }
        catch(ParkingLotException e){
            Assert.assertEquals(ParkingLotException.ExceptionType.VEHICLE_NOT_FOUND,e.type);
        }
    }

    @Test
    public void givenVehicleWhen_parkedShould_StoreTime() {
        Vehicle car1=new Vehicle();
        parkingLot.parkVehicle(car1);
        String localTime=String.valueOf((java.time.LocalTime.now()));
        ParkingLot.timeOfParking= localTime;
        String timeOfParking = parkingLot.getTimeOfParking();
        Assert.assertEquals(localTime,timeOfParking);
    }

    @Test
    public void givenVehicleWhen_parkedShould_AcceptType() {
        try{
            Vehicle car1=new Vehicle();
            parkingLot.parkVehicle(car1,DriverType.NORMAL);
            boolean isVehicleParked = parkingLot.isVehicleParked(car1);
            Assert.assertTrue(isVehicleParked);}
        catch(ParkingLotException e){
            e.printStackTrace();
        }
    }

    @Test
    public void givenVehicle_passedAsNULL_ShouldThrowException() {
        try {
            Vehicle car1 = new Vehicle();
            parkingLot.parkVehicle(null,DriverType.HANDICAP);
            boolean isVehicleParked = parkingLot.isVehicleParked(car1);
        }
        catch(ParkingLotException e){
            Assert.assertEquals(ParkingLotException.ExceptionType.NULL_OBJECT_FOR_VEHICLE,e.type);        }
    }
}