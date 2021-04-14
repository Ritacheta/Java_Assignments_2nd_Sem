//package java_assignments.assignment2;
import java.util.*;
class SEO {
    void add_item(Scanner s,ItemList it)
    {
        String name;
        int price,rate,qty,entry_order;
        System.out.println("Enter item name->");
        name=s.nextLine();
        System.out.println("Enter entry order->");
        entry_order = s.nextInt();
        System.out.println("Enter price->");
        price=s.nextInt();
        System.out.println("Enter rate->");
        rate = s.nextInt();
        System.out.println("Enter quantity->");
        qty = s.nextInt();
        s.nextLine();
        try{
            it.add_item(entry_order,name, price, rate, qty);
        }
        catch(ItemCodeException e)
        {
            System.out.println(e.msg);
        }
    }
    void change_rate(Scanner s,ItemList it)
    {
        String item_code;int rate;
        System.out.println("Enter item code->");
        item_code = s.nextLine();
        System.out.println("Enter rate->");
        rate = s.nextInt();
        s.nextLine();
        try{
            it.update_rate(item_code, rate);
        }
        catch(ItemCodeException e)
        {
            System.out.println(e.msg);
        }
    }
    void check_quantity(Scanner s, ItemList it)
    {
        int i,qty;
        String item_code;
        System.out.println("Enter item code->");
        item_code = s.nextLine();
        System.out.println("Enter quantity->");
        qty = s.nextInt();
        s.nextLine();
        try
        {
            if (it.check_quantity(item_code, qty)) {
                System.out.println("Quantity available\n");
            } 
            else {
                System.out.println("Quantity not available\n");
            }
        }
        catch(ItemCodeException e)
        {
            System.out.println(e.msg);
        }
    }
    void issue_item(Scanner s,ItemList it)
    {
        int qty;
        String item_code;
        System.out.println("Enter item code->");
        item_code = s.nextLine();
        System.out.println("Enter quantity->");
        qty = s.nextInt();
        s.nextLine();
        try {
            it.issue(item_code, qty);
        } 
        catch (ItemCodeException e) {
            System.out.println(e.msg);
        }
    }
    void knowPrice(Scanner s,ItemList it)
    {
        String item_code;
        System.out.println("Enter item code->");
        item_code = s.nextLine();
        try {
            it.know_price(item_code);
        } catch (ItemCodeException e) {
            System.out.println(e.msg);
        }
    }
    void showHigher(Scanner s,ItemList it)
    {
        int amount;
        System.out.println("Enter amount->");
        amount = s.nextInt();
        s.nextLine();
        it.show_higher(amount);
    }
    void display_by_id(Scanner s,ItemList it)
    {
        System.out.println("Enter item id->");
        String id=s.nextLine();
        int i=it.item_exist(id);
        if(i!=-1)
        {
            it.itemlist.get(i).show();
            return;
        }
        System.out.println("Item not found");
    }
}