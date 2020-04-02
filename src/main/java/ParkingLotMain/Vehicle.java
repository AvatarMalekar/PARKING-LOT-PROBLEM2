package ParkingLotMain;

public class Vehicle {
    String colour;
    String typeOfCar;
    String numberPlate;
    String timeOfParking;
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
}
