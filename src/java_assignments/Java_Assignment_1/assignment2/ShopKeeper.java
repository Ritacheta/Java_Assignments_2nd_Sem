//package java_assignments.assignment2;
import java.util.*;
public class ShopKeeper {
    void check_quantity(Scanner s, ItemList it) {
        int i, qty;
        String item_code;
        System.out.println("Enter item code->");
        item_code = s.nextLine();
        System.out.println("Enter quantity->");
        qty = s.nextInt();
        s.nextLine();
        try {
            if(it.check_quantity(item_code, qty))
            {
                System.out.println("Quantity available\n");
            }
            else {
                System.out.println("Quantity not available\n");
            }
        } catch (ItemCodeException e) {
            System.out.println(e.msg);
        }
    }

    void issue_item(Scanner s, ItemList it) {
        int qty;
        String item_code;
        System.out.println("Enter item code->");
        item_code = s.nextLine();
        System.out.println("Enter quantity->");
        qty = s.nextInt();
        s.nextLine();
        try {
            it.issue(item_code, qty);
        } catch (ItemCodeException e) {
            System.out.println(e.msg);
        }
    }

    void knowPrice(Scanner s, ItemList it) {
        String item_code;
        System.out.println("Enter item code->");
        item_code = s.nextLine();
        try {
            it.know_price(item_code);
        } catch (ItemCodeException e) {
            System.out.println(e.msg);
        }
    }

    void showHigher(Scanner s, ItemList it) {
        int amount;
        System.out.println("Enter amount->");
        amount = s.nextInt();
        s.nextLine();
        it.show_higher(amount);
    }
}