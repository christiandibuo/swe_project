package src.InvoicePackage;

import src.CatalogPackage.AbstractProduct;

import java.util.HashMap;
import java.util.Map;

public class Invoice {
    private String orderNumber;
    private float totalPrice;
    private String address;
    private Map<AbstractProduct, Integer> productMap;
    private PaymentOption paymentOption;
    private ShipmentOption shipmentOption;
    
    public Invoice() {
    	productMap = new HashMap<>();
    }
    
    public Map<AbstractProduct, Integer> getProductMap() {
        return productMap;
    }
    
    public void displayProducts() {
    	for (Map.Entry<AbstractProduct, Integer> set :productMap.entrySet()) {
    		int i = 0;
            System.out.println(i + " Name: " + set.getKey().getName() + " Price: " + set.getKey().getPrice() + " Condition: " + set.getKey().getCondition());
            i++;
    	}
    }
    public String getOrderNumber() {
        return orderNumber;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public String getAddress() {
        return address;
    }
    

    public PaymentOption getPaymentOption() {
        return paymentOption;
    }

    public ShipmentOption getShipmentOption() {
        return shipmentOption;
    }
    
    

    public void addPrice(float totalPrice){
        this.totalPrice = totalPrice;
    }

    public void addOrderNumber( String orderNumber){
        this.orderNumber = orderNumber;
    }

    public void addAddress(String address) {
        this.address = address;
    }

    public void addProduct(Map<AbstractProduct, Integer> productMap){
        this.productMap = productMap;
    }
    
    public void addPaymentOption(PaymentOption paymentOption){ 
    	this.paymentOption = paymentOption; 
    }

    public void addTypeOfShipment(ShipmentOption shipmentOption){ 
    	this.shipmentOption = shipmentOption; 
    }

}
