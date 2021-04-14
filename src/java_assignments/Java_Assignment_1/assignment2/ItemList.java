//package java_assignments.assignment2;
import java.util.*;
class ItemList {
    private static int last_id=0;
    ArrayList<Item> itemlist=new ArrayList<Item>();
    //private boolean check_unique()
    int item_exist(String id)
    {
        for (int i=0;i<itemlist.size();i++)
        {
            if (itemlist.get(i).get_id().equals(id))
            {
                return i;
            }
        }
        return -1;
    }
    void add_item(int entry_order,String name,int price,int rate,int qty) throws ItemCodeException
    {
        int i;
        Item it=new Item(entry_order,name,price,rate,qty);
       // int i=item_exist(it.get_id());
        if(itemlist.size()==0) 
        { 
            itemlist.add(it);
            System.out.println("Item added\n");
            return;
        }
        i=item_exist(it.get_id());
        if(i==-1)
        {
            itemlist.add(it);
            System.out.println("Item added\n");
            return;
        }
        else
        {
            throw new ItemCodeException("item already exists");
        }
        //last_id += 1;
    }
    void show_list()
    {
        for(int i=0;i<last_id;i++)
        {
            itemlist.get(i).show();
        }
    }
    protected void update_rate(String id,int rate) throws ItemCodeException
    {
        int i = item_exist(id);
        if(i!=-1){
            itemlist.get(i).update_rate(rate);
            return;
        } 
        else {
            throw new ItemCodeException("Invalid item code");
        }
    }
    boolean check_quantity(String id, int qty) throws ItemCodeException
    {
        int i=item_exist(id);
        if (i != -1) {
            if (itemlist.get(i).quantity_available(qty)) {
                return true;
            } else {
                throw new ItemCodeException("Quantity not avalailable");
            }
        } else {
            throw new ItemCodeException("Invalid item code");
        }
    }
    protected void issue(String id,int q) throws ItemCodeException
    {
        int i = item_exist(id);
        if (i != -1 ) {
            if(check_quantity(id, q))
            {
                itemlist.get(i).issue_item(q);
            }
            else
            {
                throw new ItemCodeException("Quantity not avalailable");
            }
        }
        else {
            throw new ItemCodeException("Invalid item code");
        }   
    }
    protected void know_price(String id) throws ItemCodeException
    {
        int i=item_exist(id);
        if (i != -1) {
            System.out.println("Price- " + itemlist.get(i).price + "\nQuantity availabale- " + itemlist.get(i).quantity);
        } else {
            throw new ItemCodeException("Invalid item code");
        }
    }
    void show_higher(int a)
    {
        for(int i=0;i<last_id;i++)
        {
            if(itemlist.get(i).price>=a)
            {
                itemlist.get(i).show();
            }
        }
    }
    void showAll()
    {
        for (int i = 0; i < itemlist.size(); i++) {
            itemlist.get(i).show();
        }
    }
}
