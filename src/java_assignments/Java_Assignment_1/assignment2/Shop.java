//package java_assignments.assignment2;
import java.util.*;
public class Shop {
    SEO seo; 
    ShopKeeper sk;
    String name;
    ItemList items;
    Shop(String n)
    {
        name=new String(n);
        seo = new SEO();
        items = new ItemList();   
    }
    void add_item(Scanner s)
    {
        seo.add_item(s, items);
    }
    void change_rate(Scanner s)
    {
        seo.change_rate(s, items);
    }
    void item_issue(Scanner s)
    {
        String type;
        System.out.println("What type of user are you? SK or SEO?");
        type=s.nextLine();
        if(type.toLowerCase().equals("sk"))
        {
            sk=new ShopKeeper();
            sk.issue_item(s, items);
        }
        else if(type.toLowerCase().equals("seo"))
        {
            seo.issue_item(s, items);
        }
    }
    void check_quantity(Scanner s)
    {
        seo.issue_item(s, items);
    }
    void know_price(Scanner s)
    {
        String type;
        System.out.println("What type of user are you? SK or SEO?");
        type = s.nextLine();
        if (type.toLowerCase().equals("sk")) {
            sk = new ShopKeeper();
            sk.knowPrice(s, items);
        } else if (type.toLowerCase().equals("seo")) {
            seo.knowPrice(s, items);
        }
    }
    void items_above_amount(Scanner s)
    {
        String type;
        System.out.println("What type of user are you? SK or SEO?");
        type = s.nextLine();
        if (type.toLowerCase().equals("sk")) {
            sk = new ShopKeeper();
            sk.showHigher(s, items);
        } else if (type.toLowerCase().equals("seo")) {
            seo.showHigher(s, items);
        }
    }
    void show_item_by_id(Scanner s)
    {
        seo.display_by_id(s, items);
    }
    void display_all_item()
    {
        items.showAll();
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Shop name->");
        String name = sc.nextLine();
        Shop h = new Shop(name);
        int ch = 0;
        System.out.println("\tWelcome to " + name + " Shop");
        while (true) {
            System.out.print(
                    "\n\t1. Add item\n\t2. Change rate\n\t3. Issue item\n\t4. Check Quantity of an item\n\t5. Display item By Id\n\t6. Display All Item\n\t7. exit\n\tEnter Choice :-");
            ch = sc.nextInt();
            sc.nextLine();
            switch (ch) {
            case 1:
                h.add_item(sc);
                break;
            case 2:
                h.change_rate(sc);
                break;
            case 3:
                h.item_issue(sc);
                break;
            case 4:
                h.check_quantity(sc);
                break;
            case 5:
                h.show_item_by_id(sc);
                break;
            case 6:
                h.display_all_item();
                break;
            default:
                System.exit(0);
            }
        }
    }
}
