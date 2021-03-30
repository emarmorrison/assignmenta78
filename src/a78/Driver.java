package a78;

import javax.swing.*;
import java.awt.*;

public class Driver {
    public static void main(String[] args) {

        a78.Auth auth = new a78.Auth();

        if(auth.login())
            userInput();
    }

    public static void userInput()
    {
        String input;
        a78.Calculation cal = new a78.Calculation();
        System.out.println("******Welcome To Online Banking*******\n\n\n");
        cal.setFirstname(JOptionPane.showInputDialog("Please enter your First Name "));
        cal.setLastname(JOptionPane.showInputDialog("Please enter your Last Name "));

        input=JOptionPane.showInputDialog("1. Make A Deposit \n 2. Make A Withdrawal\n 3. Check Your Balance \n\n 9. Exit ");

        if(input.equals("1"))
            cal.setServiceCost(100);
        else if(input.equals("2"))
            cal.setServiceCost(150);
        else if(input.equals("3"))
            cal.setServiceCost(0);
        else
            JOptionPane.showMessageDialog((Component) null,"Invalid Input");

        input=JOptionPane.showInputDialog("Options\n\n 1. Storage Small - $8\\day\n 2. Storage Large - $20.11\\day \n 3. No Options ");
        if(input.equals("1"))
            cal.setOptionCost(8);
        else if(input.equals("2"))
            cal.setOptionCost(20.11f);
        else if(input.equals("3"))
            cal.setOptionCost(0.0f);
        else
            JOptionPane.showMessageDialog((Component) null,"Invalid Input");

        input=JOptionPane.showInputDialog("Items\n\n 1. Boxes Small - $2.50/per box\n2. Boxes Large - $4.50 per box \n 3. No Items ");
        if(input.equals("1"))
            cal.setItemsCost(2.50f);
        else if(input.equals("2"))
            cal.setItemsCost(4.50f);
        else if(input.equals("3"))
            cal.setItemsCost(0.0f);
        else
            JOptionPane.showMessageDialog((Component) null,"Invalid Input");

        display(cal);

    }
    public static void display( a78.Calculation cal)
    {
        cal.displayItemCost();
        cal.displayOptionCost();
        cal.displayServiceCost();
        cal.displayTotalCost();
    }
}
