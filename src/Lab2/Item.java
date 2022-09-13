package Lab2;

public class Item {
    private String name;
    private float price;
    public Item (String name, float price){
        this.name = name;
        this.price = price;
    }
    public String getName(){
        return name;
    }
    public float getPrice(){
        return price;
    }
    public void increasePercent (float percent){
        price+=price*percent/100;
    }
    public void decreasePercent (float percent){
        price-=price*percent/100;
        checkNegativePrice();
    }
    public void checkNegativePrice(){
        if (price<0)
            price=0;
    }
}
