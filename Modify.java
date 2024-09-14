import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;
import java.sql.*;

public class Modify {
    public static void modifyItem(){
        Scanner scan = new Scanner(System.in);
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            String dburl="jdbc:mysql://localhost/restaurant";
            Connection conn= DriverManager.getConnection(dburl, "root", "root");
            Statement sta = conn.createStatement(); 

            //new item add
            System.out.println("\nModify item:\n");
            ViewMenu.menu();
            System.out.println("Enter the id of item which you want to modify:");
            int itemId= scan.nextInt();
            System.out.println("Enter the new Price of the item:");
            int newItemPrice = scan.nextInt();
            

            String query="UPDATE menuitems SET itemPrice = "+newItemPrice+" WHERE itemId="+itemId;
            int rs = sta.executeUpdate(query);
            if (rs==1) {
                System.out.println("\n\tItem was Modified successfully!");
            } else {
                System.out.println("\n\tItem was not found!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        }
    }
}
