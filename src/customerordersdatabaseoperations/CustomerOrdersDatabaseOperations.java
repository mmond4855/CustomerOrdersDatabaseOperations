package customerordersdatabaseoperations;

import java.sql.*;
import java.util.ArrayList;

public class CustomerOrdersDatabaseOperations 
{
    //Database objects...
    private static String dbProtocol = "jdbc:derby:";
    private static String dbDirectory = "E:/CIS3306 - Business Programming II/";
    private static String dbName = "CustomerOrders";
    private static String dbExtra = "";
    private static String userName = "Admin";
    private static String passWord = "MuCis";
    
    //Set connections
    public static void setConnection(String dbDirectoryIn, String dbNameIn)
    {
        dbDirectory = dbDirectoryIn;
        dbName = dbNameIn;
    }
    
    public static void setConnection(String dbDirectoryIn, String dbNameIn, String userNameIn, String passWordIn)
    {
        dbDirectory = dbDirectoryIn;
        dbName = dbNameIn;
        userName = userNameIn;
        passWord = passWordIn;
    }
    
    public static void setConnection(String dbProtocolIn, String dbDirectoryIn, String dbNameIn, String dbExtraIn, String userNameIn, String passWordIn)
    {
        dbProtocol = dbProtocolIn;
        dbDirectory = dbDirectoryIn;
        dbName = dbNameIn;
        userName = userNameIn;
        passWord = passWordIn;
    }
    
    //For connection to database.
    //This is thrown in the try argument.
    private static Connection openConnection() throws SQLException
    {
        String connectionURL = dbProtocol + dbDirectory + dbName + dbExtra;
        
        Connection connection1 = DriverManager.getConnection(connectionURL, userName, passWord);
        
        return connection1;
    }
    
    //Returns all of the customer records
    public static Customers retrieveAllCustomers()
    {
        String query1 = "SELECT * FROM Customer"; //SQL Statement
        Customers customers = new Customers();
        try(Connection connection1 = openConnection())
        {
            Statement statement = connection1.createStatement();
            ResultSet rs1 = statement.executeQuery(query1);
            
            while(rs1.next())
            {
                Customer customerNext = new Customer();
                
                customerNext.setCustomerNumber(rs1.getInt(1));
                customerNext.setCustomerFirstName(rs1.getString(2));
                customerNext.setCustomerLastName(rs1.getString(3));
                customers.add(customerNext);
            }
            
        }
        catch(SQLException e)
        {
            System.out.println(e.toString());
        }
        
        return customers;  
    }
    
    //Returns a single customer record
    public static Customer retrieveCustomer()
    {
        String query1 = "SELECT * FROM Customer WHERE CustomerNumber = ?";
        Customer customerNext = new Customer();
        
        try(Connection connection1 = openConnection())
        {
            PreparedStatement statement = connection1.prepareStatement(query1);
            ResultSet rs1 = statement.executeQuery();
            
            while(rs1.next())
            {    
                customerNext.setCustomerNumber(rs1.getInt(1));
                customerNext.setCustomerFirstName(rs1.getString(2));
                customerNext.setCustomerLastName(rs1.getString(3));
                
            }
            
        }
        catch(SQLException e)
        {
            System.out.println(e.toString());
        }
        
        return customerNext;
    
    }
    
    //Inserts a new customer
    public static void insertCustomer(Customer customer)
    {
        String insertStatementCustomer = "INSERT INTO Customer "
                        +"(CustomerNumber, CustomerFirstName, CustomerLastName)"
                        +" VALUES(?,?,?)";
        
        try(Connection connection1 = openConnection())
        {
            PreparedStatement statement = connection1.prepareStatement(insertStatementCustomer);
            
            statement.setInt(1, customer.getCustomerNumber());
            statement.setString(2, customer.getCustomerFirstName());
            statement.setString(3, customer.getCustomerLastName());
            statement.executeUpdate();
            
        }
        catch(SQLException e)
        {
            System.out.println(e.toString());
        }
    }
    
    //Changes the customer's first name
    public static void modifyCustomerFirstName(String modifyFieldValue, int conditionFieldValue)
    {
        String modifyStatement = "UPDATE Customer SET CustomerFirstName = ? "
                                +"WHERE CustomerNumber = ? "; 
        try (Connection connection1 = openConnection())
        {
            PreparedStatement statement = connection1.prepareStatement(modifyStatement);
            
            statement.setString(1, modifyFieldValue);
            statement.setInt(2, conditionFieldValue);
            statement.executeUpdate();
            
        }
        catch(SQLException e)
        {
            System.out.println(e.toString());
        }
    
    }
    
    //Changes the customer's last name
    public static void modifyCustomerLastName(String modifyFieldValue, int conditionFieldValue)
    {
        String modifyStatement = "UPDATE Customer SET CustomerLastName = ? "
                                +"WHERE CustomerNumber = ? "; 
        try (Connection connection1 = openConnection())
        {
            PreparedStatement statement = connection1.prepareStatement(modifyStatement);
            
            statement.setString(1, modifyFieldValue);
            statement.setInt(2, conditionFieldValue);
            statement.executeUpdate();
            
        }
        catch(SQLException e)
        {
            System.out.println(e.toString());
        }
    }
    
    //Deletes a customer record
    public static void deleteCustomer(int conditionFieldValue)
    {
        String deleteStatement = "DELETE FROM Customer WHERE CustomerNumber = ?";
        try(Connection connection1 = openConnection())
        {
            PreparedStatement statement = connection1.prepareStatement(deleteStatement);
            
            statement.setInt(1, conditionFieldValue);
            statement.executeUpdate();
        }
        catch(SQLException e)
        {
            System.out.println(e.toString());
        }
    
    }
    
    //Returns the field names in the database
    public static ArrayList getCustomerFieldNames()
    {
        String query1 = "SELECT * FROM Customer";
        ArrayList <String> columnNames = new ArrayList <String>();
        
        try(Connection connection1 = openConnection())
        {
            Statement statement = connection1.createStatement();
            ResultSet rs1 = statement.executeQuery(query1);
            ResultSetMetaData rsm1 = rs1.getMetaData();
            
            for(int columnNumber = 1; columnNumber <= rsm1.getColumnCount(); columnNumber++)
            {
                columnNames.add(rsm1.getColumnName(columnNumber));
            }
        }
        catch(SQLException e)
        {
        
            System.out.println(e.toString());
        }
        
        return columnNames;
    }
    
    //Inserts a new item.
    public static void insertItem(Item item)
    {
        String insertStatementItem = "INSERT INTO Item "
                        +"(CustomerNumber, ItemName, ItemCost)"
                        +" VALUES(?,?,?)";
        
        try(Connection connection1 = openConnection())
        {
            PreparedStatement statement = connection1.prepareStatement(insertStatementItem);
            
            statement.setInt(1, item.getCustomerNumber());
            statement.setString(2, item.getItemName());
            statement.setInt(3, item.getItemCost());
            statement.executeUpdate();
            
        }
        catch(SQLException e)
        {
            System.out.println(e.toString());
        }
    }
    
    
    //Returns a specific customer order.
    public static CustomerOrderEntries retrieveCustomerOder(int customerNumber)
    {
        String query1 = "SELECT * FROM Customer"
                        + "INNER JOIN Item"
                        + "ON Customer.CustomerNumber = Item.CustomerNumber"
                        + "WHERE Customer.CustomerNumber = ?";
        
        CustomerOrderEntries customerOrderEntries = new CustomerOrderEntries();
        
        try(Connection connection1 = openConnection())
        {
            PreparedStatement statement = connection1.prepareStatement(query1);
            statement.setInt(1, customerNumber);
            
            ResultSet rs1 = statement.executeQuery();
            
            while(rs1.next())
            {
                CustomerOrderEntry customerOrderEntryNext = new CustomerOrderEntry();
                
                customerOrderEntryNext.setCustomerNumber(rs1.getInt(1));
                customerOrderEntryNext.setCustomerFirstName(rs1.getString(2));
                customerOrderEntryNext.setCustomerLastName(rs1.getString(3));
                //We skip argument 4 because of the inner join.
                //The 4th argument pertains to Item.CustomerNumber
                //And because we already have the Customer.CustomerNumber in 
                //Arugment 1, we don't need argument 4.
                //Just go right to arugment #5.
                customerOrderEntryNext.setItemName(rs1.getString(5));
                customerOrderEntryNext.setItemCost(rs1.getInt(6));
                
                customerOrderEntries.add(customerOrderEntryNext);
            }
        }
        catch(SQLException e)
        {
            System.out.println(e.toString());
        }
        return customerOrderEntries;
    }
    
    //Returns all customer orders.
    public static CustomerOrderEntries retrieveCustomerOrders()
    {
        String query1 = "SELECT * FROM Customer"
                        + "INNER JOIN Item"
                        + "ON Customer.CustomerNumber = Item.CustomerNumber";
        
        CustomerOrderEntries customerOrderEntries = new CustomerOrderEntries();
        
        try(Connection connection1 = openConnection())
        {
            PreparedStatement statement = connection1.prepareStatement(query1);
            ResultSet rs1 = statement.executeQuery();
            
            while(rs1.next())
            {
                CustomerOrderEntry customerOrderEntryNext = new CustomerOrderEntry();
                
                customerOrderEntryNext.setCustomerNumber(rs1.getInt(1));
                customerOrderEntryNext.setCustomerFirstName(rs1.getString(2));
                customerOrderEntryNext.setCustomerLastName(rs1.getString(3));
                //We skip argument 4 because of the inner join.
                //The 4th argument pertains to Item.CustomerNumber
                //And because we already have the Customer.CustomerNumber in 
                //Arugment 1, we don't need argument 4.
                //Just go right to arugment #5.
                customerOrderEntryNext.setItemName(rs1.getString(5));
                customerOrderEntryNext.setItemCost(rs1.getInt(6));
                
                customerOrderEntries.add(customerOrderEntryNext);
            }
        }
        catch(SQLException e)
        {
            System.out.println(e.toString());
        }
        return customerOrderEntries;
    
    }
    
}
