package File;
import java.io.FileWriter;
import java.sql.*;

public class ClearReceipt {
    public static void main(String[] args) {
        try {
           FileWriter fw=new FileWriter("File/Receipt.txt"); 
          fw.write("");
          fw.close();
           System.out.println("\tCleared successfully!!");
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
