import java.sql.*;

public class Receipt {
    public static void showReceipt() throws InterruptedException{
        Animation.superFast("\tPlacing your order");
        Animation.superSlow("......");
        System.out.println("\n\n            ----- Receipt -----");
        try {
            Thread.sleep(400);
            Class.forName("com.mysql.cj.jdbc.Driver");
            String dburl="jdbc:mysql://localhost/restaurant";
            Connection conn = DriverManager.getConnection(dburl, "root", "root");
            Statement sta= conn.createStatement();
            
            int totalAmount=0;
            System.out.println("+--------------------------------------------+");
            System.out.printf("|%-15s|%-10s|%-8s|%-8s|%n","Name","Quantity","Price","Amount");
            System.out.println("+--------------------------------------------+");

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
                System.out.printf("|%-15s|%-10s|%-8s|%-8s|%n",menuItemName,itemquantity,itemPrice,totalPrice);

                String receiptQuery="insert into receipt(itemName,itemPrice,itemQuantity,total) values('"+itemName+"',"+itemPrice+","+itemquantity+","+totalPrice+")";
                int rr=stat.executeUpdate(receiptQuery);


                totalAmount+=totalPrice;
            }
            System.out.println("+--------------------------------------------+");
            
            System.out.printf("|%-35s|%-8s|%n","Total",totalAmount);
            System.out.println("+--------------------------------------------+");

            Payment.pay(totalAmount);


        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
