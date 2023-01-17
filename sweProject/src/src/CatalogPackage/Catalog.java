package src.CatalogPackage;
import src.ObserverPackage.Observer;
import javax.xml.catalog.CatalogException;
import java.util.*;

public class Catalog implements Observer {
    private final Map<AbstractProduct, Integer> abstractProductMap = new HashMap<AbstractProduct, Integer>();

    private static Catalog instance = null;

    private Catalog(){}

    public static Catalog getInstance(){
        if(instance == null)
            instance = new Catalog();
        return instance;
    }
    
    public AbstractProduct search(String nameOfProduct) throws NoSuchElementException {
        AbstractProduct tmp = null;
        Object l[] = abstractProductMap.keySet().toArray();
        for (int i = 0; i < abstractProductMap.size(); i++) {
            if (Objects.equals(((AbstractProduct)l[i]).getName(), nameOfProduct)){
            	if(abstractProductMap.get((AbstractProduct)l[i]) == 0) {
            		throw new NoSuchElementException("Product not avaiable!");
            	}else {
                    tmp = ((AbstractProduct)l[i]);
            	}
            }
        }
        if(tmp == null)
            throw new NoSuchElementException("Don't exist any product with that name!");
        return tmp;
    }
    
    public int searchNumber(String nameOfProduct) throws NoSuchElementException {
        int tmp = -1;
        Object l[] = abstractProductMap.keySet().toArray();
        for (int i = 0; i < abstractProductMap.size(); i++) {
            if (Objects.equals(((AbstractProduct)l[i]).getName(), nameOfProduct)){
            	if(abstractProductMap.get((AbstractProduct)l[i]) == 0) {
            		throw new NoSuchElementException("Product not avaiable!");
            	}else {
                    tmp = abstractProductMap.get((AbstractProduct)l[i]);
            	}
            }
        }
        if(tmp == -1)
            throw new NoSuchElementException("Don't exist any product with that name!");
        return tmp;
    }
    
    @Override
    public void add(src.ObserverPackage.Observable o, Object arg, int number) {
    	if(abstractProductMap.get((AbstractProduct)arg) == null) {
    		abstractProductMap.put((AbstractProduct) arg, number);
    	}else{
    		int n = abstractProductMap.get((AbstractProduct) arg);
    		abstractProductMap.replace((AbstractProduct) arg, n, n+number);
    	}
    }

    @Override
    public void remove(src.ObserverPackage.Observable o, Object arg, int number) throws CatalogException {
        int n = abstractProductMap.get((AbstractProduct) arg);
        if(n >= number) {
            abstractProductMap.replace((AbstractProduct) arg, n, n-number);
        	
        }else {
        	throw new CatalogException("There are just " + n + " product");
        }
        }

    
}