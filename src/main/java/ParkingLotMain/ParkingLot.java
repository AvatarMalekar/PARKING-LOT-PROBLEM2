package ParkingLotMain;

import EnumPackage.DriverType;
import ParkingException.ParkingLotException;
import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    int parkingLotSize;
    static int currentNumber;
    static Map<Integer,Vehicle> parkingLotAttendant;
    public static String timeOfParking=null;

    public ParkingLot(int parkingLotSize) {
        this.parkingLotSize=parkingLotSize;
        parkingLotAttendant =new HashMap<>();
        currentNumber =0;
        this.initializeMap();
    }

    public void parkVehicle(Vehicle vehicle) {
        if(this.currentNumber ==this.parkingLotSize) {
            this.informObserver(true);}
        this.parkingExceptionCheck(vehicle);
        parkingLotAttendant.put(currentNumber,vehicle);
        currentNumber++;
    }

    public void parkVehicle(Vehicle vehicle,DriverType type) {
        if(this.currentNumber ==this.parkingLotSize) {
            this.informObserver(true);
        }
        this.parkingExceptionCheck(vehicle);
        parkingLotAttendant.put(this.getIndex(type),vehicle);
        currentNumber++;
    }

    public boolean isVehicleParked(Vehicle vehicle){
        if(parkingLotAttendant.containsValue(vehicle))
            return true;
        return false;
    }

    public void unParkVehicle(Vehicle vehicle) {
        if(this.currentNumber==0){
            throw new ParkingLotException(ParkingLotException.ExceptionType.PARKING_LOT_IS_EMPTY,"Parking lot is empty"); }
        if(parkingLotAttendant.containsValue(vehicle)) {
            parkingLotAttendant.remove(this.getMeKey(vehicle));
            this.informObserver(false);
            currentNumber--;
        }
    }

    public boolean isVehicleUnParked(Vehicle vehicle) {
        if(!parkingLotAttendant.containsValue(vehicle))
            return true;
        return false;
    }

    public int getSize(){
        return this.parkingLotSize-parkingLotAttendant.size();
    }

    public int getPositionOfCar(Vehicle name){
        return this.getMeKey(name);
    }

    public void informObserver(boolean status)
    {
        new ObserverInitialization(status);
    }

    public int getMeKey(Vehicle vehicle){
        for(Map.Entry<Integer,Vehicle> entry:parkingLotAttendant.entrySet()){
            if(entry.getValue().equals(vehicle)){
                return entry.getKey();
            }
        }
        throw new ParkingLotException("Vehicle not found");
    }

    public int getIndex(DriverType type){
        if(type==DriverType.NORMAL){
            for(int i=this.parkingLotSize;i>=0;i--){
                if(parkingLotAttendant.get(i)==null)
                    return i;
            }
        }
        if(type==DriverType.HANDICAP){
            for(int i=0;i<this.parkingLotSize;i++){
                if(parkingLotAttendant.get(i)==null)
                    return i;
            }
        }
        throw new ParkingLotException("Parking lot is full");
    }

    public void parkingExceptionCheck(Vehicle vehicle){
        if(this.currentNumber >this.parkingLotSize)
            throw new ParkingLotException(ParkingLotException.ExceptionType.PARKING_LOT_IS_FULL,"Parking lot is full");
        if(vehicle==null)
            throw new ParkingLotException(ParkingLotException.ExceptionType.NULL_OBJECT_FOR_VEHICLE,"null object for vehicle");
        if(isVehicleParked(vehicle))
            throw new ParkingLotException(ParkingLotException.ExceptionType.VEHICLE_PARKED_ALREADY,"Vehicle already Parked");
    }

    public void initializeMap(){
        for(int i=0;i<this.parkingLotSize;i++)
            parkingLotAttendant.put(0,null);
    }

    public String getTimeOfParking(){
        return timeOfParking;
    }

}
