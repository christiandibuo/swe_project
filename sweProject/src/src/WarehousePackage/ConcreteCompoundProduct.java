package src.WarehousePackage;

import java.util.List;
import java.util.Vector;

import src.CatalogPackage.AbstractProduct;
import src.CatalogPackage.Condition;

public class ConcreteCompoundProduct implements ConcreteProduct {

	private Vector children;
	private int numberOfProduct;
	private int weight;
	private String shippingAddress;
	private String name;
	
	public ConcreteCompoundProduct(AbstractProduct ap, String shippingAddress) {
    	this.name = ap.getName();
		this.shippingAddress = shippingAddress;
		children = new Vector();
	}

	public void add(ConcreteElementaryService p){
		children.addElement(p);
	}
	
	public String getshippingAddress() {
		return this.shippingAddress;
	}

	public void remove(ConcreteProduct p, int numberOfProduct){
		for(int i=0; i<numberOfProduct; i++){
			children.removeElement(p);
		}
	}

	
	private int weightCalculator(){
		int totalWeight=0;
		for(int i=0; i<children.size(); i++){
			ConcreteProduct p = (ConcreteProduct) children.get(i);
			totalWeight += p.getWeight();
		}
		this.weight = totalWeight;
		return totalWeight;
	}

	@Override
	public int getWeight() {
		return weightCalculator();
	}

	@Override
	public Condition getCondition() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getName() {
		return this.name;
	}


}
