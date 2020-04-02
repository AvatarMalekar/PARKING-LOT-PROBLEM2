package ParkingLotMain;

import java.util.ArrayList;
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


}
