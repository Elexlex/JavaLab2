package Lab2;

public class Cart {
    private Item[] stack;
    private int itemQuantity;

    public Cart (int maxItemQuantity){
        stack = new Item[maxItemQuantity];
        itemQuantity = 0;
    }
    public Item[] getStack(){
        return stack;
    }
    public int getItemQuantity(){
        return itemQuantity;
    }
    public void addItem(Item item){
        if (checkStackFull())
            return;
        add(item);
    }
    private void add(Item item){
        stack[itemQuantity] = item;
        itemQuantity++;
    }
    public void deleteItem(){
        if (checkStackEmpty())
            return;
        delete();
    }
    private void delete(){
        itemQuantity--;
    }
    public void priceSummary(){
        if (checkStackEmpty())
            return;
        summary();
    }
    private void summary(){
        float sum = 0;
        for (Item item : stack)
            sum+=item.getPrice();
        System.out.println("\n\n- Summary of your cart: " + sum + "$");
    }
    private boolean checkStackFull (){
        boolean check = itemQuantity==stack.length;
        if (check)
            System.out.println("- Your cart is full");
        return check;
    }
    private boolean checkStackEmpty (){
        boolean check=itemQuantity==0;
        if (check)
            System.out.println("\n\n- Your cart is empty");
        return check;
    }
    public void increaseItemPrice (float percent){
        increasePrice(percent);
    }
    private void increasePrice(float percent){
        for (int i=0; i<itemQuantity; i++)
            stack[i].increasePercent(percent);
    }
    public void decreaseItemPrice (float percent){
        decreasePrice(percent);
    }
    private void decreasePrice(float percent){
        for (int i=0; i<itemQuantity; i++)
            stack[i].decreasePercent(percent);
    }
}
