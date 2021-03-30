package a78;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.Scanner;

public class Auth {
    public Auth() {
    }

    public static boolean login() {
        String username = "";
        String password = "";

        for (int x = 0; x < 3; ++x) {
            username = JOptionPane.showInputDialog("Please enter your username ");
            password = JOptionPane.showInputDialog("Please enter your password ");
            if (readFile(username, password)) {
                return true;
            }

            JOptionPane.showMessageDialog((Component) null, "Invalid Credentials You Have: " + String.valueOf(2 - x) + " Tries Remaining");

            if(x == 2)
            {
                JOptionPane.showMessageDialog((Component) null, "You have exceeded your try’s, goodbye");
                return false;
            }
        }
        return false;
    }

    public static boolean readFile(String username, String password) {
        try {
            File myObj = new File("file.txt");
            Scanner myReader = new Scanner(myObj);

            while(myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] parts = data.split(",");
                if (parts[0].equals(username) && parts[1].equals(password)) {
                    return true;
                }
            }

            myReader.close();
        } catch (FileNotFoundException var6) {
            JOptionPane.showMessageDialog((Component)null, "An error occurred.");
            var6.printStackTrace();
        }
        return false;
    }
    public static void writeFile(String data, String fileName) {
        try {
            FileWriter fw = null;
            BufferedWriter bw = null;
            PrintWriter pw = null;
            JOptionPane.showMessageDialog((Component)null, "Writing records...");
            fw = new FileWriter(fileName, true);
            bw = new BufferedWriter(fw);
            pw = new PrintWriter(bw);
            pw.println(data);
            pw.close();
        } catch (FileNotFoundException var5) {
            System.out.println(var5.getMessage());
        } catch (IOException var6) {
            JOptionPane.showMessageDialog((Component)null, var6.getMessage());
        }

    }
}

