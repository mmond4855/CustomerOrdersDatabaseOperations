package customerordersdatabaseoperations;

import java.util.ArrayList;

public class Customers 
{

    private ArrayList <Customer> customers = new ArrayList <Customer> ();
    
    public void add(Customer customer)
    {
        customers.add(customer);
    }
    
    public Customer get(int i)
    {
        return customers.get(i);
    }
    
    public int size()
    {
        return customers.size();
    }     
}
