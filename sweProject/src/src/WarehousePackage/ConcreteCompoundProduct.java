package src.WarehousePackage;

import java.util.List;
import java.util.Vector;

import src.CatalogPackage.AbstractProduct;

public class ConcreteCompoundProduct extends ConcreteProduct {

	private Vector children;
	private int numberOfProduct;
	private int weight;
	private String shippingAddress;
	public ConcreteCompoundProduct(AbstractProduct ap, String shippingAddress) {
		super(ap);
		this.shippingAddress = shippingAddress;
		children = new Vector();
	}

	public void add(ConcreteProduct p){
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


}
