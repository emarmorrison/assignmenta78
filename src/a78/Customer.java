package a78;

import javax.swing.*;
import java.awt.*;

public class Customer
{
    private String firstname;
    private String lastname;
    private String username;
    private String password;
    private float balance;
    private float total;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }


    public void total(float serviceCost,float balance, float optionCost)
    {
        setTotal(serviceCost + balance + optionCost);
    }

    public void deposit( )
    {

        Filem filem= new Filem();
        float initailBalance = 0.0f;
      try {

          initailBalance = filem.readFile(getUsername()+".txt");
          float amount = Float.parseFloat(JOptionPane.showInputDialog("Please Enter The amount to deposit"));
          if (amount < 1)
              System.out.println("You Cant make negative deposit");
          else if (amount > 1000)
              System.out.println("Please visit to make deposits over $1000");
          else {
              initailBalance += amount;
              filem.writeFile(getUsername(), getPassword(), initailBalance, "emar.txt");
              display();
          }
      }
      catch (Exception e)
      {
          System.out.println(e.getMessage());
      }

    }

    public void withdraw( )
    {

        Filem filem= new Filem();
        float initailBalance = 0.0f;
        try {
            setBalance(filem.readFile(getUsername()+".txt"));

            float amount = Float.parseFloat(JOptionPane.showInputDialog("Please Enter The amount to withdraw"));
            System.out.println("Amount" + amount);

            if(amount > getBalance())
                System.out.println("You have insufficient Balance");
            if (amount < 1)
                System.out.println("You Cant make negative withdrawal");
            else if (amount > 1000)
                System.out.println("Please visit to make withdrawal over $1000");
            else {
                setBalance( getBalance() - amount);
                filem.writeFile(getUsername(), getPassword(), getBalance(), getUsername()+".txt");
                display();
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

    }
    public void display()
    {
        JOptionPane.showMessageDialog((Component) null,"************ NEW BALANCE **********\n\n\t"+getBalance());
    }


    public void display(String username)
    {
        JOptionPane.showMessageDialog((Component) null,"************ NEW BALANCE **********\n\n\t"+getBalance());
    }
    //used for logging on to the system
    public Customer login()
    {
        String username = "";
        String password = "";
        Customer cus = new Customer();
        Filem auth = new Filem();

        for (int x = 0; x < 1; ++x) {
            username = JOptionPane.showInputDialog("Please enter your username ");
            password = JOptionPane.showInputDialog("Please enter your password ");
            if (auth.readFile(username, password)) {

                cus.setUsername(username);
                cus.setPassword(password);
                return cus;
            }

            JOptionPane.showMessageDialog((Component) null, "Invalid Credentials You Have: " + String.valueOf(2 - x) + " Tries Remaining");

            if(x == 2)
            {
                JOptionPane.showMessageDialog((Component) null, "You have exceeded your try’s, goodbye");
                return cus;
            }
        }
        return cus;
    }


}
