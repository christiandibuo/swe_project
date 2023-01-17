

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import src.CatalogPackage.CatalogWorker;
import src.InvoicePackage.User;
import src.WarehousePackage.Courier;
import src.WarehousePackage.Logistic;

public class Manager {
	
	private static List<Courier> couriers = new ArrayList<>();
	private static List<User> users = new ArrayList<>();
	
	private Manager() {}
	
	
	public static void createCourier(String username, int maxWeight) {
			Courier c = new Courier(username, maxWeight);
			couriers.add(c);
	}
	
	public static void removeCourier(String username) {
		for(int i = 0; i<couriers.size(); i++) {
			if(couriers.get(i).getUsername()==username) {
				couriers.remove(i);
			}
		}
	}
	
	public static List<Courier> getCouriers(){
		return couriers;
	}
	
	

    private static void addUser(User u){
        users.add(u);
    }

    public static User createUser(String username){
    	if(!checkUsernameConflict(username)) {
	        User user = new User("c" + Integer.toString(users.size()), username);
	        addUser(user);
	        return user;
    	}
    	else {
    		throw new IllegalArgumentException("username already present");
    	}
    }
    
    private static boolean checkUsernameConflict(String u) {
        boolean conflict = false;
        for (User i : users)
            if (Objects.equals(i.getUsername(), u)) {
                conflict = true;
                break;
            }
        return conflict;
    }
}
