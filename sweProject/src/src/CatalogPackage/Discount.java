package src.CatalogPackage;

public class Discount {
    Condition condition;
    Discount(Condition condition){
        this.condition = condition;
    }

    public int getDiscount(){
        switch (condition){
            case GOOD:
                return 20;
            case SATISFACTORY:
                return 30;
        }
        return 0;
    }
}
