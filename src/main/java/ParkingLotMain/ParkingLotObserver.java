package ParkingLotMain;

import Interfaces.ObserverInterface;
import Interfaces.ObserverOperations;

import java.util.ArrayList;

public class ParkingLotObserver implements ObserverOperations {
      boolean status;

    public ParkingLotObserver(boolean status) {
        this.status=status;
    }

    private ArrayList<ObserverInterface> observers = new ArrayList<ObserverInterface>();

    @Override
    public void registerObserver(ObserverInterface observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(ObserverInterface observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (ObserverInterface ob : observers) {
            ob.updateObservers(this.status);
        }
    }
}