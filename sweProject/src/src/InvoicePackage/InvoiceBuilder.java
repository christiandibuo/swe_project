package src.InvoicePackage;

import src.CatalogPackage.Condition;
import src.WarehousePackage.Logistic;
import src.WarehousePackage.Warehouse;

public class InvoiceBuilder implements Builder{
    private int orderNumber;
    private float totalPrice;
    private String address;
    private Invoice invoice;

    public InvoiceBuilder(){
        invoice = new Invoice();
    }

    public void createOrder(String clientID, Cart cart, int orderCounter, String paymentOption, String shipmentOption, String address) {
        addPrice(cart);
        addOrderNumber(clientID, orderCounter);
        addAddress(address);
        addPaymentMethod(paymentOption);
        addTypeOfShipping(shipmentOption);
        invoice.addProduct(cart.getProductList());
        sendOrderToLogistic();
    }

    private void addPrice(Cart cart){
        invoice.addPrice(cart.priceCalculator());
    }
    
    private void addOrderNumber(String id, int orderNumber){
        invoice.addOrderNumber(id + "o" + Integer.toString(orderNumber));
    }

    private void addAddress(String address) {
        invoice.addAddress(address);
    }
    
    private void addPaymentMethod(String paymentOption){
    	PaymentOption po = PaymentOption.valueOf(paymentOption);
    	invoice.addPaymentOption(po);
    }

    private void addTypeOfShipping(String shipmentOption){
    	ShipmentOption so = ShipmentOption.valueOf(shipmentOption);
    	invoice.addTypeOfShipment(so);
    }
    
    
    private void sendOrderToLogistic() {
    	Logistic.receiveInvoice(invoice);
    }
    
    public Invoice getOrder(){
        return invoice;
    }
}
