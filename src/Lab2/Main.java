package Lab2;
import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner num = new Scanner(System.in);
        Cart cart;
        int number, menu = 0;
        do{
            System.out.print("- Input the maximum number of items in your cart (from 1 to 10): ");
            number = num.nextInt();
        } while(number>10||number<1);
        cart = new Cart(number);
        input(number, cart);
        do {
            output(cart);
        System.out.print("\n\n1. The amount of your cart\n2. Increasing a price by 15%\n3. Decreasing price by 30%\n4. Delete last item\n5. Add a new item\n6. Exit\n- ");
        menu = num.nextInt();
        switch (menu){
            case 1:
                cart.priceSummary();
                break;
            case 2:
                cart.increaseItemPrice(15);
                break;
            case 3:
                cart.decreaseItemPrice(30);
                break;
            case 4:
                cart.deleteItem();
                break;
            case 5:
                input(number, cart);
                break;
        }
    }while (menu!=6);
    }
    public static Cart input(int number, Cart cart){
        int currentNumber = cart.getItemQuantity();
       Scanner num = new Scanner(System.in);
       Scanner item = new Scanner (System.in);
        System.out.println();
            System.out.println("- Input the name of object № " + (currentNumber+1) + ": ");
            String object = item.nextLine();
            System.out.println("- Input the price of object № " + (currentNumber+1) + ": ");
            float price = num.nextFloat();
            cart.addItem(new Item(object, price));
        return cart;
    }
    public static void output(Cart cart) {
        System.out.println("\n\nYour cart: ");
        for (int i=0; i<cart.getItemQuantity(); i++){
            System.out.println("\t- Object № " + (i+1) + ": " + cart.getStack()[i].getName() + ", " + cart.getStack()[i].getPrice() + "$");
        }
    }
}
