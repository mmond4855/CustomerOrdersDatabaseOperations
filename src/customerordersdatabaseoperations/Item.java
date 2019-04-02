package customerordersdatabaseoperations;

public class Item 
{
    private int customerNumber;
    private String itemName;
    private int itemCost;

    public int getCustomerNumber() 
    {
        return customerNumber;
    }

    public void setCustomerNumber(int customerNumber) 
    {
        this.customerNumber = customerNumber;
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
    
}
