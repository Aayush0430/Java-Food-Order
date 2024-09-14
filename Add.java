import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner;
import java.sql.*;

public class Add {
    public static void addItem(){
        Scanner scan = new Scanner(System.in);
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            String dburl="jdbc:mysql://localhost/restaurant";
            Connection conn= DriverManager.getConnection(dburl, "root", "root");
            Statement sta = conn.createStatement(); 

            //new item add
            System.out.println("\nAdd item:\n");

            System.out.println("Enter the name of the item:");
            String itemName = scan.next();
            System.out.println("Enter the Price of the item:");
            int itemPrice = scan.nextInt();
            



            String query="insert into menuitems(itemName,itemPrice) values('"+itemName+"','"+itemPrice+"')";
            int rs = sta.executeUpdate(query);
            if (rs==1) {
                System.out.println("\n\tItem was added successfully!");
            } else {
                System.out.println("\n\tItem was not added");
            }
        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        }
    }
}
