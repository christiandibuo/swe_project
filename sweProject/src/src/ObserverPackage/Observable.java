package src.ObserverPackage;

import java.util.ArrayList;
import java.util.List;

public class Observable extends Object{
    List<Observer> observers;

    protected Observable(){
        observers = new ArrayList <Observer>();
   }

    public void addObserver(Observer o){
        observers.add(o);
    }

    public void deleteObserver(Observer o){
        observers.remove(o);
    }

    public void notifyAdd(Object arg, int number){
    	for(Observer i : observers) {
    		i.add(this, arg, number);
    	}
    }

    public void notifyRemove(Object arg, int number){
    	for(Observer i : observers) {
    		i.remove(this, arg, number);
    	}
    }

}