package ParkingLotMain;

import EnumPackage.DriverType;
import ParkingException.ParkingLotException;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    Vehicle vehicle;
    ParkingLotOwner parkingLotOwner;
    AirportSecurity airportSecurity;
    int parkingLotSize;
    static int currentNumber;
    static Map<Integer,Vehicle> parkingLotAttendant;

    public ParkingLot(int parkingLotSize) {
        this.parkingLotSize=parkingLotSize;
        parkingLotAttendant =new HashMap<>();
        parkingLotOwner=new ParkingLotOwner();
        airportSecurity=new AirportSecurity();
        currentNumber =0;
        this.initializeMap();
    }

    public void parkVehicle(Vehicle vehicle) {
        if(this.currentNumber ==this.parkingLotSize) {
            this.updateObservers(true);
        }
        parkingLotAttendant.put(currentNumber,vehicle);
        currentNumber++;
    }

    public void parkVehicle(Vehicle vehicle,DriverType type) {
        if(this.currentNumber ==this.parkingLotSize) {
            this.updateObservers(true);
        }
      //  int a=this.getIndex(type);
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
            throw new ParkingLotException("Parking Lot is Empty");
        }

        if(parkingLotAttendant.containsValue(vehicle)) {
            parkingLotAttendant.remove(this.getMeKey(vehicle));
            this.updateObservers(false);
            currentNumber--;
        }
    }

    public boolean isVehicleUnParked() {
        if(!parkingLotAttendant.containsKey(vehicle))
            return true;
        return false;
    }

    public int getSize(){
        return (this.parkingLotSize- parkingLotAttendant.size());
    }

    public int getPositionOfCar(Vehicle name){
        return this.getMeKey(name);
    }

    public String getTimeOfParking(Vehicle carObj){
        return carObj.timeOfParking;
    }

    public void updateObservers(boolean status){
        parkingLotOwner.capacityStatus(status);
        airportSecurity.capacityStatus(status);
    }
    public int getMeKey(Vehicle vehicle){
        for(Map.Entry<Integer,Vehicle> entry:parkingLotAttendant.entrySet()){
            if(entry.getValue().equals(vehicle)){
                return entry.getKey();
            }
        }
       return  0;
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

    public void initializeMap(){
         for(int i=0;i<this.parkingLotSize;i++)
             parkingLotAttendant.put(0,null);
    }
}
