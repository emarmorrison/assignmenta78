package a78;
import java.io.File;
import java.io.IOException;
import javax.swing.*;
import java.awt.*;

public class Driver {
    public static void main(String[] args) {

       /* File file = new File("emar.txt"); //initialize File object and passing path as argument
        boolean result;
        try
        {
            result = file.createNewFile();  //creates a new file
            if(result)      // test if successfully created a new file
            {
                System.out.println("file created "+file.getCanonicalPath()); //returns the path string
            }
            else
            {
                System.out.println("File already exist at location: "+file.getCanonicalPath());
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();    //prints exception if any
        }
*/
        Customer cus = new Customer();

        cus = cus.login();
        if (cus.getUsername().length() > 0) {
            userInput(cus);
        }
    }

    public static void userInput( Customer cus) {
        System.out.println("Sooon");
        String input;
        System.out.println("******Welcome To Online Banking*******\n\n\n");
        //cal.setFirstname(JOptionPane.showInputDialog("Please enter your First Name "));
        // cal.setLastname(JOptionPane.showInputDialog("Please enter your Last Name "));

        input=JOptionPane.showInputDialog("******Welcome To Online Banking*******\n\n\n1. Make A Deposit \n2. Make A Withdrawal\n3. Check Your Balance \n\n 9. Exit ");

        if(input.equals("1"))
            cus.deposit();
        else if(input.equals("2"))
            cus.withdraw();
        else if(input.equals("3"))
            cus.display(cus.getUsername());
        else
            JOptionPane.showMessageDialog((Component) null,"Invalid Input");

    }
}
