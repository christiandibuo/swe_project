package src.ObserverPackage;

public interface Observer {

    public void add(Observable o, Object arg, int number);

    public void remove(Observable o, Object arg, int number);

}
