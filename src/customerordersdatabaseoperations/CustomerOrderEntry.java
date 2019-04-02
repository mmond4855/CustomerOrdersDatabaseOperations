package customerordersdatabaseoperations;

import java.util.*;

public class CustomerOrderEntry implements Comparable
{
    private int customerNumber;
    private String customerFirstName;
    private String customerLastName;
    private String itemName;
    private int itemCost;
   
    public CustomerOrderEntry()
    {
        
    }

    public CustomerOrderEntry(Customer customerIn, Item itemIn)
    {
        this.customerNumber = customerIn.getCustomerNumber();
        this.customerFirstName = customerIn.getCustomerFirstName();
        this.customerLastName = customerIn.getCustomerLastName();
        this.itemName = itemIn.getItemName();
        this.itemCost = itemIn.getItemCost();
    }

    public int getCustomerNumber() 
    {
        return customerNumber;
    }

    public void setCustomerNumber(int customerNumber) 
    {
        this.customerNumber = customerNumber;
    }

    public String getCustomerFirstName() 
    {
        return customerFirstName;
    }

    public void setCustomerFirstName(String customerFirstName) 
    {
        this.customerFirstName = customerFirstName;
    }

    public String getCustomerLastName()
    {
        return customerLastName;
    }

    public void setCustomerLastName(String customerLastName) 
    {
        this.customerLastName = customerLastName;
    }

    public String getItemName() 
    {
        return itemName;
    }

    public void setItemName(String itemName) 
    {
        this.itemName = itemName;
    }

    public int getItemCost() 
    {
        return itemCost;
    }

    public void setItemCost(int itemCost) 
    {
        this.itemCost = itemCost;
    }
    
    @Override
    public int compareTo(Object customerOrderEntry) 
    {
	if(customerNumber == ((CustomerOrderEntry) customerOrderEntry).getCustomerNumber())
        {
            return 0;
	}
	else{
            if(customerNumber > ((CustomerOrderEntry) customerOrderEntry).getCustomerNumber())
            {
                return 1;
            }
            else
            {
		return -1;
            }			
	}
    }    

}
