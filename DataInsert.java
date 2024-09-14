import java.util.*;
import java.sql.*;

public class DataInsert {
    public static void main(String[] args) {
        Scanner scan= new Scanner(System.in);
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String dburl="jdbc:mysql://localhost/restaurant";
            Connection conn= DriverManager.getConnection(dburl, "root", "root");
            Statement sta = conn.createStatement(); 
            String tableName="Ordered";

            System.out.println(tableName);

            String query="create table "+tableName+" (ItemName varchar(20), ItemQuantity Integer)";
            int rs = sta.executeUpdate(query);

                System.out.println(rs+" affected rows");
            // do {
            //     System.out.println("enter Item name");  
            //     String iName = scan.nextLine();
            //     System.out.println("enter Item Price");  
            //     String iPrice = scan.nextLine();
            //     String query="insert into menuItems(itemName,itemPrice) values('"+iName+"',"+iPrice+")";
            //     // String query="delete from menuItems where itemName=\"momo\" ";
            //     int r = sta.executeUpdate(query);
            //     System.out.println(r+" affected rows");

            // } while (true);

        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        }
    }
}
