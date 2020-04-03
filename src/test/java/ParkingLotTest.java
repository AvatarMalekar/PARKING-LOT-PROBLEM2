import EnumPackage.CarSizeType;
import EnumPackage.DriverType;
import ParkingException.ParkingLotException;
import ParkingLotMain.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class ParkingLotTest {
    ParkingLot parkingLot;
    Vehicle vehicle;
    Vehicle vehicle2;
    Vehicle vehicle3;
    Vehicle vehicle4;
    Vehicle vehicle5;
    Vehicle vehicle6;
    Vehicle vehicle7;
    Vehicle vehicle8;
    Vehicle vehicle9;
    Vehicle vehicle10;
    Vehicle vehicle11;
    Vehicle vehicle12;
    Vehicle vehicle13;
    Vehicle vehicle14;
    Vehicle vehicle15;
    ParkingLotOwner parkingLotOwner;
    AirportSecurity airportSecurity;
    Calendar now;

    @Before
    public void setUp() throws Exception {
        parkingLotOwner=new ParkingLotOwner();
        parkingLot=new ParkingLot(2);
        now = Calendar.getInstance();
        vehicle=new Vehicle("RED");
        vehicle2=new Vehicle("WHITE");
        vehicle3=new Vehicle("WHITE");
        vehicle4=new Vehicle("WHITE");
        vehicle5=new Vehicle("WHITE");

        vehicle6=new Vehicle("BLUE","TOYOTA","1234");
        vehicle7=new Vehicle("BLUE","TOYOTA","1122");
        vehicle8=new Vehicle("BLUE","BMW","1111");
        vehicle9=new Vehicle("BLUE","BMW","2222");

        vehicle10=new Vehicle("RED","BMW","4145",""+now.get(Calendar.HOUR_OF_DAY)+":"+now.get(Calendar.MINUTE)+":"+now.get(Calendar.SECOND));
        vehicle11=new Vehicle("WHITE","TESLA","4455",""+now.get(Calendar.HOUR_OF_DAY)+":"+now.get(Calendar.MINUTE)+":"+now.get(Calendar.SECOND));

        vehicle12=new Vehicle("YELLOW","LAMBORGHINI","7458",""+now.get(Calendar.HOUR_OF_DAY)+":"+now.get(Calendar.MINUTE)+":"+now.get(Calendar.SECOND),CarSizeType.SMALL,DriverType.HANDICAP);
        vehicle13=new Vehicle("WHITE","TESLA","4451",""+now.get(Calendar.HOUR_OF_DAY)+":"+now.get(Calendar.MINUTE)+":"+now.get(Calendar.SECOND),CarSizeType.SMALL,DriverType.HANDICAP);
        vehicle14=new Vehicle("RED","MERCEDES","8888",""+now.get(Calendar.HOUR_OF_DAY)+":"+now.get(Calendar.MINUTE)+":"+now.get(Calendar.SECOND),CarSizeType.SMALL,DriverType.HANDICAP);
        vehicle15=new Vehicle("WHITE","AUDI","9991",""+now.get(Calendar.HOUR_OF_DAY)+":"+now.get(Calendar.MINUTE)+":"+now.get(Calendar.SECOND),CarSizeType.LARGE,DriverType.NORMAL);


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
            parkingLot.parkVehicle(vehicle3);
            parkingLot.parkVehicle(vehicle4);
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
            parkingLot.parkVehicle(vehicle3);
            parkingLot.parkVehicle(vehicle4);
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
            parkingLot.parkVehicle(vehicle4);
            parkingLot.parkVehicle(vehicle5);
        }catch(ParkingLotException e){
            Assert.assertEquals(ParkingLotException.ExceptionType.PARKING_LOT_IS_FULL,e.type);
        }
    }

    @Test
    public void givenParkingLot_hasSpace_ShouldReturn_Size() {
        try{
            parkingLot.parkVehicle(vehicle);
            int size = parkingLot.getSize();
            Assert.assertEquals(3,size);}
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

    @Test
    public void givenVehicle_IfLarge_ShouldBeParked_InTheLotHavingLargeSize() {
        try{
            ParkingLot parkLot=new ParkingLot(4);
            parkLot.parkVehicle(vehicle,DriverType.NORMAL, CarSizeType.LARGE);
            int positionOfCar = parkLot.getPositionOfCar(vehicle);
            Assert.assertEquals(2,positionOfCar);
        }
        catch(ParkingLotException e){
            e.printStackTrace();
        }
    }

    @Test
    public void whenPoliceDepartmentAsks_ShouldReturn_LocationOfAllParked_WhiteCars() {
        try{
            ParkingLot parkLot=new ParkingLot(4);
            parkLot.parkVehicle(vehicle,DriverType.NORMAL, CarSizeType.LARGE);
            parkLot.parkVehicle(vehicle2,DriverType.NORMAL, CarSizeType.LARGE);
            parkLot.parkVehicle(vehicle3,DriverType.NORMAL);
            parkLot.parkVehicle(vehicle4,DriverType.HANDICAP);
            parkLot.parkVehicle(vehicle5,DriverType.NORMAL);
            ArrayList<Integer> policeList = parkLot.getMeList("WHITE");
            ArrayList<Integer> checklist=new ArrayList<>();
            checklist.add(0);
            checklist.add(1);
            checklist.add(2);
            checklist.add(3);
            boolean a=checklist.equals(policeList);
            Assert.assertTrue(a);
        }catch(ParkingLotException e){
            e.printStackTrace();
        }
    }

    @Test
    public void givenBlue_ToyotaCars_shouldReturnLocationAndPlateNumber_ToPoliceDepartment() {
        try{
            parkingLot.parkVehicle(vehicle6,DriverType.NORMAL);
            parkingLot.parkVehicle(vehicle7,DriverType.HANDICAP);
            parkingLot.parkVehicle(vehicle8,DriverType.NORMAL);
            parkingLot.parkVehicle(vehicle9,DriverType.NORMAL);
            ArrayList<PoliceDataRecord> locationAndNumberPlate = parkingLot.getMeLocationAndNumberPlate("BLUE", "TOYOTA");
            Assert.assertEquals(0,locationAndNumberPlate.get(0).location);
            Assert.assertEquals("1122",locationAndNumberPlate.get(0).numberPlate);
            Assert.assertEquals(1,locationAndNumberPlate.get(1).location);
            Assert.assertEquals("1234",locationAndNumberPlate.get(1).numberPlate);
        }
        catch(ParkingLotException e){
            e.printStackTrace();
        }
    }

    @Test
    public void givenBMWCar_shouldReturn_LocationTo_Police_Department() {
        try {
            parkingLot.parkVehicle(vehicle6, DriverType.NORMAL);
            parkingLot.parkVehicle(vehicle7, DriverType.HANDICAP);
            parkingLot.parkVehicle(vehicle8, DriverType.NORMAL);
            parkingLot.parkVehicle(vehicle9, DriverType.NORMAL);
            ArrayList<Integer> checklist = new ArrayList<>();
            checklist.add(0);
            checklist.add(1);
            ArrayList<Integer> policeList = parkingLot.getMeCarType("BMW");
            Assert.assertEquals(checklist, policeList);
        }catch(ParkingLotException e){
            e.printStackTrace();
        }
    }

    @Test
    public void givenCarParkedWithinThirtyMinutes_ShouldReturnLocation_ToPoliceDepartment() {
        try{
            parkingLot.parkVehicle(vehicle10,DriverType.NORMAL);
            parkingLot.parkVehicle(vehicle11,DriverType.HANDICAP);

            now.add(Calendar.MINUTE,-31);
            ArrayList<Integer> checklist = new ArrayList<>();
            checklist.add(0);
            checklist.add(1);
            String timeToCheck=""+now.get(Calendar.HOUR_OF_DAY)+":"+now.get(Calendar.MINUTE)+":"+now.get(Calendar.SECOND);
            ArrayList<Integer> policeList = parkingLot.getMeCarsParkedInDuration(timeToCheck);
            Assert.assertEquals(checklist,policeList);
        }catch (ParkingLotException e){
            e.printStackTrace();
        }
    }

    @Test
    public void givenSmallHandicapCarParked_ShouldReturnLocationAndInformation_ToPoliceDepartment() {
        try{
            parkingLot.parkVehicle(vehicle12);
            parkingLot.parkVehicle(vehicle13);
            parkingLot.parkVehicle(vehicle14);
            parkingLot.parkVehicle(vehicle15);
            HashMap<String, Vehicle> policeData = parkingLot.getMeLocationByCarSizeAndDriverType(CarSizeType.SMALL, DriverType.HANDICAP);
        }catch(ParkingLotException e){
            e.printStackTrace();
        }
    }
}