package src.InvoicePackage;

import src.CatalogPackage.AbstractProduct;
import src.CatalogPackage.Catalog;
import src.ObserverPackage.Observable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Cart extends Observable {
    private Map<AbstractProduct,Integer> abstractProductsMap;
    private int nproducts;
    
    public Cart() {
    	Catalog catalog = Catalog.getInstance();
		this.addObserver(catalog);
        abstractProductsMap = new HashMap<>();
    }

    public Cart(Cart c){
        abstractProductsMap = new HashMap<>();
        for(Map.Entry<AbstractProduct, Integer> entry: c.abstractProductsMap.entrySet()) {
            abstractProductsMap.put(entry.getKey(), entry.getValue());
        }
    }
    
    public void addProduct(AbstractProduct ap, int productNumber){
    	abstractProductsMap.put(ap, productNumber);
    	this.nproducts += productNumber;
        this.notifyRemove(ap, productNumber);
    }
    
    public int getnProducts() {
        return nproducts;
    }
    
    public int getProductSize() {
    	return abstractProductsMap.size();
    }
    
    public Map<AbstractProduct, Integer> getProductList() {
        return abstractProductsMap;
    }

    public void removeProduct(String productName, int productNumber) throws IllegalArgumentException {
        AbstractProduct tmp = null;
        Object l[] = abstractProductsMap.keySet().toArray();
        for (int i = 0; i < abstractProductsMap.size(); i++) {
            if (Objects.equals(((AbstractProduct) l[i]).getName(), productName)) {
                tmp = ((AbstractProduct) l[i]);
                if(abstractProductsMap.remove(tmp, productNumber)) {
                	this.nproducts -= productNumber;
                	this.notifyAdd(tmp, productNumber);
                }else if (abstractProductsMap.get(tmp) > productNumber) {
                    abstractProductsMap.replace(tmp, abstractProductsMap.get(tmp), abstractProductsMap.get(tmp) - productNumber);                	
                    this.nproducts -= productNumber;
                    this.notifyAdd(tmp, productNumber);
                } else {
                    throw new IllegalArgumentException("You are trying to remove more products at how many are contained in the cart!");
                }
            }
        }
        if (tmp == null)
            throw new IllegalArgumentException("Don't exist any product with that name!");
    }

    public float priceCalculator(){
        float total = 0;
        Object l[] = abstractProductsMap.keySet().toArray();
        for (int i = 0; i < abstractProductsMap.size(); i++) {
                total += (((AbstractProduct) l[i]).getPrice())*abstractProductsMap.get(((AbstractProduct) l[i]));
        }
        return total;
    }


    public void clear(){
        abstractProductsMap.clear();
        nproducts = 0;
    }
}
