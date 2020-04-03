package ParkingLotMain;

import EnumPackage.CarSizeType;
import EnumPackage.DriverType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PoliceDepartment {
    int size;

    public PoliceDepartment(int parkingLotSize) {
        this.size = parkingLotSize;
    }

    public ArrayList<Integer> getColour(String colour) {
        ArrayList<Integer> policeList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            if (ParkingLot.parkingLotOne.get(i) != null) {
                if (ParkingLot.parkingLotOne.get(i).colour == colour)
                    policeList.add(ParkingLot.parkingLotOne.indexOf(ParkingLot.parkingLotOne.get(i)));
            }
            if (ParkingLot.parkingLotTwo.get(i) != null) {
                if (ParkingLot.parkingLotTwo.get(i).colour == colour)
                    policeList.add(ParkingLot.parkingLotTwo.indexOf(ParkingLot.parkingLotTwo.get(i)));
            }
        }
        return policeList;
    }

    public ArrayList<PoliceDataRecord> getLocationAndPlate(String colour, String type) {
        ArrayList<PoliceDataRecord> policeList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            if (ParkingLot.parkingLotOne.get(i) != null) {
                if (ParkingLot.parkingLotOne.get(i).colour == colour && ParkingLot.parkingLotOne.get(i).typeOfCar == type)
                    policeList.add(new PoliceDataRecord(ParkingLot.parkingLotOne.indexOf(ParkingLot.parkingLotOne.get(i)), ParkingLot.parkingLotOne.get(i).numberPlate));
            }
            if (ParkingLot.parkingLotTwo.get(i) != null) {
                if (ParkingLot.parkingLotTwo.get(i).colour == colour && ParkingLot.parkingLotTwo.get(i).typeOfCar == type)
                    policeList.add(new PoliceDataRecord(ParkingLot.parkingLotTwo.indexOf(ParkingLot.parkingLotTwo.get(i)), ParkingLot.parkingLotTwo.get(i).numberPlate));
            }
        }
        return policeList;
    }

    public ArrayList<Integer> getType(String typeOfCar) {
        ArrayList<Integer> policeList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            if (ParkingLot.parkingLotOne.get(i) != null) {
                if (ParkingLot.parkingLotOne.get(i).typeOfCar == typeOfCar)
                    policeList.add(ParkingLot.parkingLotOne.indexOf(ParkingLot.parkingLotOne.get(i)));
            }
            if (ParkingLot.parkingLotTwo.get(i) != null) {
                if (ParkingLot.parkingLotTwo.get(i).typeOfCar == typeOfCar)
                    policeList.add(ParkingLot.parkingLotTwo.indexOf(ParkingLot.parkingLotTwo.get(i)));
            }
        }
        return policeList;
    }

    public ArrayList<Integer> getTimeOfParking(String time) {
        ArrayList<Integer> policeList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            if (ParkingLot.parkingLotOne.get(i) != null) {
                if (ParkingLot.parkingLotOne.get(i).timeOfParking.compareTo(time)>=0)
                    policeList.add(ParkingLot.parkingLotOne.indexOf(ParkingLot.parkingLotOne.get(i)));
            }
            if (ParkingLot.parkingLotTwo.get(i) != null) {
                System.out.println(ParkingLot.parkingLotTwo.get(i).timeOfParking.compareTo(time)>=0);
                if (ParkingLot.parkingLotTwo.get(i).timeOfParking.compareTo(time)>0)
                    policeList.add(ParkingLot.parkingLotTwo.indexOf(ParkingLot.parkingLotTwo.get(i)));
            }
        }
        return policeList;
    }

    public HashMap<String,Vehicle> getLocationByCarSizeAndDriverType(CarSizeType carSizeType, DriverType driverType) {
        HashMap<String,Vehicle> policeList = new HashMap<>();
        for (int i = 0; i < size; i++) {
            if (ParkingLot.parkingLotOne.get(i) != null) {
                if (ParkingLot.parkingLotOne.get(i).carSizeType == carSizeType && ParkingLot.parkingLotOne.get(i).driverType ==driverType)
                    policeList.put("P1"+ParkingLot.parkingLotOne.indexOf(ParkingLot.parkingLotOne.get(i)),ParkingLot.parkingLotOne.get(i));
            }
            if (ParkingLot.parkingLotTwo.get(i) != null) {
                if (ParkingLot.parkingLotTwo.get(i).carSizeType == carSizeType && ParkingLot.parkingLotTwo.get(i).driverType ==driverType)
                    policeList.put("P2"+ParkingLot.parkingLotTwo.indexOf(ParkingLot.parkingLotTwo.get(i)),ParkingLot.parkingLotTwo.get(i));
            }
        }
        return policeList;
    }

    public ArrayList<String> getLocationOfAllParkedCars() {
        ArrayList<String> policeList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            if (ParkingLot.parkingLotOne.get(i) != null) {
                    policeList.add("ParkingLotOne-"+ParkingLot.parkingLotOne.indexOf(ParkingLot.parkingLotOne.get(i)));
            }
            if (ParkingLot.parkingLotTwo.get(i) != null) {
                    policeList.add("ParkingLotTwo-"+ParkingLot.parkingLotTwo.indexOf(ParkingLot.parkingLotTwo.get(i)));
            }
        }
        return policeList;
    }

}
