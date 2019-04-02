package customerordersdatabaseoperations;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Customer 
{
    private SimpleIntegerProperty customerNumberProperty = new SimpleIntegerProperty();
    private SimpleStringProperty customerFirstNameProperty = new SimpleStringProperty();
    private SimpleStringProperty customerLastNameProperty = new SimpleStringProperty();

    private int customerNumber;
    private String customerFirstName;
    private String customerLastName;

    public int getCustomerNumber() 
    {
        return customerNumber;
    }

    public void setCustomerNumber(int customerNumber) 
    {
        this.customerNumber = customerNumber;
        this.customerNumberProperty.set(customerNumber);
    }

    public String getCustomerFirstName() 
    {
        return customerFirstName;
    }

    public void setCustomerFirstName(String customerFirstName) 
    {
        this.customerFirstName = customerFirstName;
        this.customerFirstNameProperty.set(customerFirstName);
    }

    public String getCustomerLastName() 
    {
        return customerLastName;
    }

    public void setCustomerLastName(String customerLastName) 
    {
        this.customerLastName = customerLastName;
        this.customerLastNameProperty.set(customerLastName);
    }

    public int getCustomerNumberProperty() 
    {
        return customerNumberProperty.get();
    }

    public void setCustomerNumberProperty(int customerNumber) 
    {
        this.customerNumberProperty.set(customerNumber);
        this.customerNumber = customerNumber;
    }

    public String getCustomerFirstNameProperty() 
    {
        return customerFirstNameProperty.get();
    }

    public void setCustomerFirstNameProperty(String customerFirstName) 
    {
        this.customerFirstNameProperty.set(customerFirstName);
        this.customerFirstName = customerFirstName;
    }

    public String getCustomerLastNameProperty() 
    {
        return customerLastNameProperty.get();
    }

    public void setCustomerLastNameProperty(String customerLastName) 
    {
        this.customerLastNameProperty.set(customerLastName);
        this.customerLastName = customerLastName;
    }
    
}
