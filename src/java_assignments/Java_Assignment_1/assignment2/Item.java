//package java_assignments.assignment2;

class Item {
   // private static int last_id=0;
    private String item_code,name;
    protected int rate,quantity;
    protected int price;
    Item(int id,String n,int p,int r,int qty)
    {
        //last_id+=1;
        price=p;
        name=new String(n);
        rate=r;
        quantity=qty;
        item_code=new String(name+String.format("%03d",id));
        System.out.println("Item Code=>"+item_code);
    }
    String get_id()
    {
        return item_code;
    }
    protected void update_rate(int r)
    {
        rate=r;
    }
    void show()
    {
        System.out.println("Item code-"+item_code+"\nName-"+name+"\nPrice-"+price+"\nRate="+rate+"\nQuantity available="+quantity+"\n");
    }
    protected boolean quantity_available(int q)
    {
        return quantity>=q;
    }
    protected void issue_item(int q)
    {
        if(quantity_available(q))
        {
            quantity-=q;
        }
    }
}

