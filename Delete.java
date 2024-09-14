import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;
import java.sql.*;

public class Delete {
    public static void deleteItem(){
         Scanner scan = new Scanner(System.in);
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            String dburl="jdbc:mysql://localhost/restaurant";
            Connection conn= DriverManager.getConnection(dburl, "root", "root");
            Statement sta = conn.createStatement(); 

            //delete item add
            System.out.println("\nDelete item:\n");

            ViewMenu.menu();
            System.out.println("\nEnter the id of the item you want to remove:");
            int itemId = scan.nextInt();
            System.out.println("Confirm deletion!! (y/n)");
            Character confirmation=scan.next().charAt(0);
            
            if (confirmation.equals('y')) {
                String query="delete from menuitems where itemId="+itemId;
                int rs = sta.executeUpdate(query);
                if (rs==1) {
                    System.out.println("\n\tItem was deleted successfully!");
                } else {
                    System.out.println("\n\tItem was not found");
                }
            } 
        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        }
    
    }
}
