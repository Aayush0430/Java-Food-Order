import java.util.*;

import javax.swing.text.View;

import java.sql.*;

public class ViewMenu {
     public static void menu(){
         Scanner scan= new Scanner(System.in);
         
        System.out.println("   --------MENU--------");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String dburl="jdbc:mysql://localhost/restaurant";
            Connection conn= DriverManager.getConnection(dburl, "root", "root");
            Statement sta = conn.createStatement(); 
            String query="select * from menuItems";
            // String query="delete from menuItems where itemName=\"momo\" ";
            ResultSet rs = sta.executeQuery(query);
            if (Restaurant.currentUser=="admin") {
                System.out.println("+------------------------------+");
                System.out.printf("|%-5s|%-15s|%-8s|%n","Id","Name","Price");
                System.out.println("+------------------------------+");

                while (rs.next()) {
                    int id=rs.getInt(1); 	
                        String iName=rs.getString(2);
                        int iPrice=rs.getInt(3);
                        System.out.printf("|%-5s|%-15s|%-8s|%n",id,iName,iPrice);
                    }
                System.out.println("+------------------------------+");
            } else {
                System.out.println("+------------------------+");
                System.out.printf("|%-15s|%-8s|%n","Name","Price");
                System.out.println("+------------------------+");

                while (rs.next()) {
                    int id=rs.getInt(1); 	
                        String iName=rs.getString(2);
                        int iPrice=rs.getInt(3);
                        System.out.printf("|%-15s|%-8s|%n",iName,iPrice);
                    }
                System.out.println("+------------------------+");
            }
            if(Restaurant.currentUser=="guest"||Restaurant.currentUser=="member"){
                        System.out.println("Do you want to place an order? (y/n)");
                        Character orderChoice=scan.next().charAt(0);
                        // Order.orderItem();////////////////////////////////////////////////////////
                    if (orderChoice=='y'||orderChoice=='Y') {
                        if (Restaurant.currentUser.equals("member")) {
                            Order.orderItem();
                        }else{
                            Restaurant.throughMenu="call";
                            Thread.sleep(300);
                            Animation.fast("\nPlease Log in First");
                            Animation.superSlow("...");
                            LoginPage.guestLogin();
                        }
                    }else if(orderChoice=='n'||orderChoice=='N'){
                        
                    } 
                    else{
                        Thread.sleep(500);
                        Animation.fast("\tInvalid Option!!\n");
                                    
                    }
            }
            conn.close();
            if(Restaurant.currentUser.equals("admin")){
                PassHide.PassCall("Enter to continue");
            }
            
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
    
}
