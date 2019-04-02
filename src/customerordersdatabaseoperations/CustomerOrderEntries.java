package customerordersdatabaseoperations;

import java.util.ArrayList;

public class CustomerOrderEntries 
{

    private ArrayList <CustomerOrderEntry> customerOrderEntries = new ArrayList <CustomerOrderEntry> ();
    
    public void add(CustomerOrderEntry  customerOrderEntry)
    {
        customerOrderEntries.add(customerOrderEntry);
    }
    
    public CustomerOrderEntry get(int i)
    {
        return customerOrderEntries.get(i);
    }
    
    public int size()
    {
        return customerOrderEntries.size();
    }     

    public void sort()
    {
        customerOrderEntries.sort(null);
    }    
}
