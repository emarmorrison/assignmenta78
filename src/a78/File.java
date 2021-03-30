package a78;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.Scanner;

public class File {

    private String filename;

    public File(String filename) {
        this.filename = filename;
    }

    //This method is used for authentication
    public static boolean readFile(String username, String password) {
        try {
            String filename = username.toString()+",txt";
            File myObj = new File(filename);
            Scanner myReader = new Scanner((Readable) myObj);

            while(myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] parts = data.split(",");
                if (parts[0].equals(username) && parts[1].equals(password)) {
                    return true;
                }
            }

            myReader.close();
        } catch ( Exception e) {
            JOptionPane.showMessageDialog((Component)null, "An error occurred.");
            e.printStackTrace();
        }
        return false;
    }

    //this this is used to get balance
    public static boolean readFile(String username) {
        try {
            String filename = username.toString()+",txt";
            File myObj = new File(filename);
            Scanner myReader = new Scanner((Readable) myObj);

            while(myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] parts = data.split(",");
                if (parts[0].equals(username) && parts[1].equals(password)) {
                    return true;
                }
            }

            myReader.close();
        } catch ( Exception e) {
            JOptionPane.showMessageDialog((Component)null, "An error occurred.");
            e.printStackTrace();
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
