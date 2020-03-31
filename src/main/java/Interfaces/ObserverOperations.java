package Interfaces;

public interface ObserverOperations {
    public void registerObserver(ObserverInterface observer);

    public void removeObserver(ObserverInterface observer);

    public void notifyObservers();
}
