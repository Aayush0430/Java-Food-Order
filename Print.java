import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Print {
    public static void write(){
        // public static void main(String[] args) {
                       
        try (FileWriter f = new FileWriter("File/Receipt.txt", true);
                BufferedWriter b = new BufferedWriter(f);
                PrintWriter p = new PrintWriter(b);) {

            //username----------------------------
            ////import username
            p.printf("User: %s   ",LoginPage.currentUserName);

			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
            LocalDateTime now = LocalDateTime.now();  
            p.println(dtf.format(now)); 

            Class.forName("com.mysql.cj.jdbc.Driver");
            String dburl="jdbc:mysql://localhost/restaurant";
            Connection conn = DriverManager.getConnection(dburl, "root", "root");
            Statement sta= conn.createStatement();
            
            int totalAmount=0;
            // f.write("+--------------------------------------------+\n");
            p.println("+--------------------------------------------+");
            p.printf("|%-15s|%-10s|%-8s|%-8s|%n","Name","Quantity","Price","Amount");
            p.println("+--------------------------------------------+");
			
            String query="select * from ordered";
            ResultSet rs= sta.executeQuery(query);
            while (rs.next()) {
                String itemName=rs.getString(1);
                int itemquantity=rs.getInt(2);

                // System.out.println(itemName+  itemquantity);

                //get price of the item
                Statement stat= conn.createStatement();

                String menuquery="select itemName,itemPrice from menuitems where itemName='"+itemName+"'";
                ResultSet r =stat.executeQuery(menuquery);
                r.next();
                String menuItemName=r.getString(1);
                int itemPrice=r.getInt(2);

                int totalPrice=itemPrice*itemquantity;
                p.printf("|%-15s|%-10s|%-8s|%-8s|%n",menuItemName,itemquantity,itemPrice,totalPrice);
				
                String receiptQuery="insert into receipt(itemName,itemPrice,itemQuantity,total) values('"+itemName+"',"+itemPrice+","+itemquantity+","+totalPrice+")";
                int rr=stat.executeUpdate(receiptQuery);

                totalAmount+=totalPrice;
            }

            p.println("+--------------------------------------------+");
            p.printf("|%-35s|%-8s|%n","Total",totalAmount);
            p.println("+--------------------------------------------+\n\n");
			p.flush();
            f.close();
            b.close();
            // System.out.println("added");
        } catch (Exception e) {
			e.printStackTrace();
            // TODO: handle exception
        }
    }
}
