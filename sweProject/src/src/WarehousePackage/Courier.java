package src.WarehousePackage;

import java.util.ArrayList;
import java.util.List;

public class Courier {

	    private ArrayList<ConcreteProduct> products;
	    private CourierStatus status;
	    private String username;
	    private int maxWeight;
	    private int weight = 0;

		public Courier(String username, int maxWeight) {
	        products = new ArrayList<>();
			this.maxWeight = maxWeight;
	    	this.username = username;
	        this.status = CourierStatus.AVAIABLE;
	    }

		public int addProducts(ConcreteProduct cp, int weightP) {
	            products.add(cp);
	            return increaseWeight(weightP);
	    }
	    
		public int getnProducts() {
			return products.size();
		}
		
	    private int increaseWeight(int prodWeight) {
	    	int diffweight = 0;
	    	diffweight = prodWeight - (maxWeight - weight);
	        this.weight += prodWeight;
	        updateStatus();
	        return diffweight;
	    }
	    
	    private void updateStatus() {
	        if (this.weight >= maxWeight) {
	            status = CourierStatus.BUSY;
	        }
	        else {
	        	status = CourierStatus.AVAIABLE;
	        }
	    }

	    public boolean isAvailable() {
	        return status == CourierStatus.AVAIABLE;
	    }


		private void setStatus(boolean s) {
	    	if(!s) {
	            status = CourierStatus.BUSY;
	    	}else{
	    		status = CourierStatus.AVAIABLE; 
    		}
	    }
	    public CourierStatus getStatus() {
	        return status;
	    }
	    
	    public void shipmentCompleted() {
	    	setStatus(true);
	    	weight = 0;
	    	products.clear();
	    }
	    
	    public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}


	

}
