package ParkingLotMain;

import EnumPackage.CarSizeType;
import EnumPackage.DriverType;
import ParkingException.ParkingLotException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ParkingLot extends ParkingLotSystem{
    int parkingLotSize;
    int totalParkingLotSize;
    static int currentNumber;
    public static String timeOfParking=null;
    public static ArrayList<Vehicle> tempList;
    PoliceDepartment policeDepartment;
    public ParkingLot(int parkingLotSize) {
        super(parkingLotSize);
        this.parkingLotSize=parkingLotSize;
        this.totalParkingLotSize=parkingLotSize*2;
        parkingLotOne =new ArrayList<>();
        parkingLotTwo=new ArrayList<>();
        tempList=new ArrayList<>();
        currentNumber =0;
        this.initializeMap();
        policeDepartment=new PoliceDepartment(this.parkingLotSize);

    }

    public void parkVehicle(Vehicle vehicle) {
        this.parkingExceptionCheck(vehicle);
        if(decideWhichLot().equals("parkingLotOne")){
            parkingLotOne.set(this.getIndex(null,"parkingLotOne",null),vehicle);
            return;}
        if(decideWhichLot().equals("parkingLotTwo")){
            parkingLotTwo.set(this.getIndex(null,"parkingLotTwo",null),vehicle);
            return;}
    }

    public void parkVehicle(Vehicle vehicle,DriverType type) {
        this.parkingExceptionCheck(vehicle);
        if(decideWhichLot().equals("parkingLotOne")){
            parkingLotOne.set(this.getIndex(type,"parkingLotOne",null),vehicle);
            return;}
        if(decideWhichLot().equals("parkingLotTwo")){
            parkingLotTwo.set(this.getIndex(type,"parkingLotTwo",null),vehicle);
            return;}
    }

    public void parkVehicle(Vehicle vehicle, DriverType driverType, CarSizeType carSizeType) {
        this.parkingExceptionCheck(vehicle);
        if(decideWhichLot().equals("parkingLotOne")){
            parkingLotOne.set(this.getIndex(driverType,"parkingLotOne",carSizeType),vehicle);
            return;}
        if(decideWhichLot().equals("parkingLotTwo")){
            parkingLotTwo.set(this.getIndex(driverType,"parkingLotTwo",carSizeType),vehicle);
            return;}
    }

    public boolean isVehicleParked(Vehicle vehicle){
        if(parkingLotOne.contains(vehicle) || parkingLotTwo.contains(vehicle))
            return true;
        return false;
    }

    public void unParkVehicle(Vehicle vehicle) {
        if(this.currentNumber==0){
            throw new ParkingLotException(ParkingLotException.ExceptionType.PARKING_LOT_IS_EMPTY,"Parking lot is empty"); }
        if(parkingLotOne.contains(vehicle))
            parkingLotOne.set(parkingLotOne.indexOf(vehicle),null);
        if(parkingLotTwo.contains(vehicle))
            parkingLotTwo.set(parkingLotTwo.indexOf(vehicle),null);
        this.informObserver(false);
        currentNumber--;
    }

    public boolean isVehicleUnParked(Vehicle vehicle) {
        if(!parkingLotOne.contains(vehicle) || !parkingLotTwo.contains(vehicle))
            return true;
        return false;
    }

    public int getSize(){
        return (this.totalParkingLotSize-(this.listSize()+this.listTwoSize()));
    }

    public int getPositionOfCar(Vehicle vehicle){
        if(parkingLotOne.contains(vehicle))
            return parkingLotOne.indexOf(vehicle);

        if(parkingLotTwo.contains(vehicle))
            return  parkingLotTwo.indexOf(vehicle);
        throw new ParkingLotException("Vehicle Not Found"); }

    public void informObserver(boolean status) {
        new ObserverInitialization(status); }

    public int getIndex(DriverType driverType,String lotName,CarSizeType carSizeType) {
        if (carSizeType == CarSizeType.LARGE && this.getSize() >= 3) {
            if (driverType == DriverType.NORMAL) {
                for (int i = this.parkingLotSize - 1; i >= 0; i--) {
                    if (lotName.equals("parkingLotOne")) {
                        if (parkingLotOne.get(i) == null && parkingLotOne.get(i - 1) == null && parkingLotOne.get(i - 2) == null)
                            return i - 1; }
                    if (lotName.equals("parkingLotTwo")) {
                        if (parkingLotTwo.get(i) == null && parkingLotTwo.get(i - 1) == null && parkingLotTwo.get(i - 2) == null)
                            return i - 1; } } }

            if (driverType == DriverType.HANDICAP) {
                for (int i = 0; i < this.parkingLotSize; i++) {
                    if (lotName.equals("parkingLotOne")) {
                        if (parkingLotOne.get(i) == null && parkingLotOne.get(i + 1) == null && parkingLotOne.get(i + 2) == null)
                            return i + 1; }
                    if (lotName.equals("parkingLotTwo")) {
                        if (parkingLotTwo.get(i) == null && parkingLotTwo.get(i + 1) == null && parkingLotTwo.get(i + 2) == null)
                            return i + 1; } } } }

        if (driverType == DriverType.NORMAL) {
            for (int i = this.parkingLotSize - 1; i >= 0; i--) {
                if (lotName.equals("parkingLotOne")) {
                    if (parkingLotOne.get(i) == null)
                        return i; }
                if (lotName.equals("parkingLotTwo")) {
                    if (parkingLotTwo.get(i) == null)
                        return i; } } }

        if(driverType==DriverType.HANDICAP || driverType==null){
            if (lotName.equals("parkingLotOne"))
                return IntStream.range(0,this.parkingLotSize).filter(i->parkingLotOne.get(i)==null).boxed().collect(Collectors.toList()).get(0);
            if (lotName.equals("parkingLotTwo"))
                return IntStream.range(0,this.parkingLotSize).filter(i->parkingLotTwo.get(i)==null).boxed().collect(Collectors.toList()).get(0); }
        throw new ParkingLotException("Parking lot is full"); }

    public void parkingExceptionCheck (Vehicle vehicle){
        currentNumber++;
        if(this.currentNumber ==this.totalParkingLotSize)
            this.informObserver(true);
        if (this.currentNumber > this.totalParkingLotSize)
            throw new ParkingLotException(ParkingLotException.ExceptionType.PARKING_LOT_IS_FULL, "Parking lot is full");
        if (vehicle == null)
            throw new ParkingLotException(ParkingLotException.ExceptionType.NULL_OBJECT_FOR_VEHICLE, "null object for vehicle");
        if (isVehicleParked(vehicle))
            throw new ParkingLotException(ParkingLotException.ExceptionType.VEHICLE_PARKED_ALREADY, "Vehicle already Parked"); }

    public String getTimeOfParking () {
        return timeOfParking; }
    public ArrayList<Integer> getMeList(String colour){
        return policeDepartment.getColour(colour); }

    public ArrayList<PoliceDataRecord> getMeLocationAndNumberPlate(String colour, String typeOfVehicle){
        return policeDepartment.getLocationAndPlate(colour,typeOfVehicle); }

    public ArrayList<Integer> getMeCarType(String typeOfCar){
        return policeDepartment.getType(typeOfCar); }

    public ArrayList<Integer> getMeCarsParkedInDuration(String beforeTime){
        return policeDepartment.getTimeOfParking(beforeTime);
    }

    public LinkedHashMap<String,Vehicle> getMeLocationByCarSizeAndDriverType(CarSizeType carSizeType, DriverType driverType){
        return policeDepartment.getLocationByCarSizeAndDriverType(carSizeType,driverType); }

    public ArrayList<String> getMeLocationOfAllParkedCars(){
        return policeDepartment.getLocationOfAllParkedCars(); }
}
