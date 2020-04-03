package ParkingLotMain;

import EnumPackage.CarSizeType;
import EnumPackage.DriverType;

public class Vehicle {
    String colour;
    String typeOfCar;
    String numberPlate;
    String timeOfParking;
    CarSizeType carSizeType;
    DriverType driverType;
    public Vehicle() {
    }

    public Vehicle(String colour) {
        this.colour=colour;
    }

    public Vehicle(String colour, String typeOfCar, String numberPlate) {
        this.colour = colour;
        this.typeOfCar = typeOfCar;
        this.numberPlate = numberPlate;
    }

    public Vehicle(String colour, String typeOfCar, String numberPlate, String timeOfParking) {
        this.colour = colour;
        this.typeOfCar = typeOfCar;
        this.numberPlate = numberPlate;
        this.timeOfParking = timeOfParking;
    }

    public Vehicle(String colour, String typeOfCar, String numberPlate, String timeOfParking, CarSizeType carSizeType, DriverType driverType) {
        this.colour = colour;
        this.typeOfCar = typeOfCar;
        this.numberPlate = numberPlate;
        this.timeOfParking = timeOfParking;
        this.carSizeType = carSizeType;
        this.driverType = driverType;
    }
}
