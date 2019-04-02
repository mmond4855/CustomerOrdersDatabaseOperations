package customerordersdatabaseoperations;

import java.util.ArrayList;

public class Items 
{
    private ArrayList <Item> items = new ArrayList <Item> ();
    
    public void add(Item  item)
    {
        items.add(item);
    }
    
    public Item get(int i)
    {
        return items.get(i);
    }
    
    public int size()
    {
        return items.size();
    }     
    
}
