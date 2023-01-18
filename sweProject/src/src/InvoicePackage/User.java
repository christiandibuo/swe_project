package src.InvoicePackage;

import src.CatalogPackage.*;

import java.util.ArrayList;
import java.util.List;

public class User{
    private List<String> invoiceList = new ArrayList<>();
    private Catalog catalog;
    private String id;
	private String username;
    private Cart cart;
    private int orderCounter;

    public User(String id, String username){
        this.catalog = Catalog.getInstance();
        this.cart = new Cart();
        this.id = id;
        this.username = username;
        orderCounter = 0;
    }
    
    public AbstractProduct searchProduct(String nameOfProduct){
        return catalog.search(nameOfProduct);
    }
    public int searchNumberProduct(String nameOfProduct) {
    	return catalog.searchNumber(nameOfProduct);
    }
    public int getCartProductNumber() {
    	return cart.getnProducts();
    }
    
    public float getCartTotalPrice() {
    	return cart.priceCalculator();
    }
    
    public int getOrderCounter() {
		return orderCounter;
	}

	public void addToCart(String nameOfProduct, int productNumber){
        cart.addProduct(searchProduct(nameOfProduct), productNumber);
    }

    public void removeFromCart(String nameOfProduct, int productNumber){
        cart.removeProduct(nameOfProduct, productNumber);
    }

    public void makeOrder(String paymentOption, String shipmentOption, String address)throws Exception{
        InvoiceBuilder orderBuilder = new InvoiceBuilder();
        if(cart.getProductSize() != 0){
            orderCounter++;
	        orderBuilder.createOrder(id, new Cart(cart) , orderCounter, paymentOption, shipmentOption, address);
	        cart.clear();
	        invoiceList.add(orderBuilder.getOrder().getOrderNumber());
        }else {
        	throw new Exception("the cart is empty");
        }
    }
    

    
    public String getUsername() {
		return username;
	}
}
