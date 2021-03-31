package a78;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.io.File;
import java.util.Scanner;

public class Filem {
    private String filename;

    public Filem(String filename) {
        this.filename = filename;
    }

    public Filem() {
    }

    //This method is used for authentication
    public static boolean readFile(String username, String password) {
        try {
            String filename = username.toString()+",txt";
            File myObj = new File("emar.txt");
            Scanner myReader = new Scanner(myObj);

            while(myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] parts = data.split(",");
                if (parts[0].equals(username) && parts[1].equals(password)) {
                    myReader.close();
                    return true;
                }
            }
        }
        catch ( Exception e)
        {
            JOptionPane.showMessageDialog((Component)null, "An error occurred.");
            e.printStackTrace();
        }
        return false;
    }

    public static float readFile(String username) {
        float balance = 0.0f;
        try {

            String filename = username.toString() + ",txt";
            File myObj = new File("emar.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] parts = data.split(",");
                System.out.println("at parts balance: "+parts[2]);
                balance = Float.parseFloat(parts[2]);
                System.out.println(balance);
                return balance;
            }
            myReader.close();
        }
         catch ( Exception e) {
            JOptionPane.showMessageDialog((Component)null, e.getMessage());
        }
        return balance;
    }

    //checks user balance
    public static String readFile() {
        float balance = 0.0f;
        try {

            String filename = username.toString() + ",txt";
            File myObj = new File("emar.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] parts = data.split(",");
                System.out.println("at parts balance: "+parts[2]);
                balance = Float.parseFloat(parts[2]);
                System.out.println(balance);
                return balance;
            }
            myReader.close();
        }
        catch ( Exception e) {
            JOptionPane.showMessageDialog((Component)null, e.getMessage());
        }
        return balance;
    }

    public static void writeFile(String username, String password,float balance, String fileName) {
        try {
            FileWriter fw = null;
            BufferedWriter bw = null;
            PrintWriter pw = null;
            JOptionPane.showMessageDialog((Component)null, "Writing New Balance...");
            fw = new FileWriter(fileName, false);
            bw = new BufferedWriter(fw);
            pw = new PrintWriter(bw);
            pw.println(username+","+password+","+balance);
            pw.close();
        } catch (FileNotFoundException var5) {
            System.out.println(var5.getMessage());
        } catch (IOException var6) {
            JOptionPane.showMessageDialog((Component)null, var6.getMessage());
        }

    }
}
