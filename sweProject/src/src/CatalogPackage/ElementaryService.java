package src.CatalogPackage;

import java.util.List;

public class ElementaryService extends AbstractProduct {
	private float price;
	private int weight;

	public ElementaryService(String name, float price, String condition, int weight){
		super(name, condition);
		this.price = price;
		this.weight = weight;
	}
	
	
	@Override
	public float getPrice() {
		return price * (100 - this.discount.getDiscount()) /100;
	}

	public void describe(AbstractProduct ab){
		ab.products.add(this);
	}
	
//	public List <AbstractProduct>  justDescribe(){
//		return null;
//	}

	@Override
	public int getWeight() {
		return weight;
	}
	
}
