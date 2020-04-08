package ParkingException;

public class ParkingLotException extends RuntimeException{
    public ParkingLotException(String message) {
        super(message);
    }

    public enum ExceptionType {
        NULL_OBJECT_FOR_VEHICLE,VEHICLE_NOT_FOUND,PARKING_LOT_IS_FULL,PARKING_LOT_IS_EMPTY,
        VEHICLE_PARKED_ALREADY,VEHICLE_COLOUR_NOT_FOUND,TYPE_OF_CAR_NOT_FOUND;
    }

    public ExceptionType type;

    public ParkingLotException(ExceptionType type, String message) {
        super(message);
        this.type = type;
    }
}
