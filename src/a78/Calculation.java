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

    public void Calculation(float serviceCost, float optionCost, float balance, float total)
    {
        this.serviceCost = serviceCost;
        this.optionCost = optionCost;
        this.balance = balance;
        this.total = total;
    }

    public void total()
    {
        setTotal(serviceCost + balance + optionCost);
    }

    public void total(float serviceCost,float balance, float optionCost)
    {
        setTotal(serviceCost + balance + optionCost);
    }

    public void displayServiceCost()
    {
        JOptionPane.showMessageDialog((Component) null,"The Total Service Cost is: "+ String.valueOf(getServiceCost()));
    }

    public void displayOptionCost()
    {
        JOptionPane.showMessageDialog((Component) null,"The Total Options Cost is: "+ String.valueOf((getOptionCost())));
    }

    public void displayItemCost()
    {
        JOptionPane.showMessageDialog((Component) null,"The Total Items Cost is: "+ String.valueOf((getbalance())));
    }

    public void displayTotalCost()
    {
        total();
        JOptionPane.showMessageDialog((Component) null,"The Total Cost is: "+ String.valueOf((getTotal())));
    }


}
