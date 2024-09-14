import java.util.Scanner;
import java.sql.*;

public class Order {
    public static void orderItem(){

        try {
             Class.forName("com.mysql.cj.jdbc.Driver");
            String dburl="jdbc:mysql://localhost/restaurant";
            Connection conn= DriverManager.getConnection(dburl, "root", "root");
            Statement sta = conn.createStatement(); 
            Thread.sleep(500);
            System.out.println("\nPlace your Order!!\n");
            Thread.sleep(300);
            Scanner scan = new Scanner(System.in);
            char stop='n';
            String iName;
            int iServings;

            int counter=0;
            
           
                
            do {
                
                System.out.println("Which item do you want to order?");
                iName=scan.next();
                
                System.out.println("How many servings?");
                iServings=scan.nextInt();
                
                String countquery="select count(*) from menuitems where itemName='"+iName+"'";
                ResultSet r = sta.executeQuery(countquery);
                r.next();
                int found=r.getInt(1);
                
                if(found==1){
                    String query="insert into Ordered(ItemName,ItemQuantity) values('"+iName+"',"+iServings+")";
                    int rs = sta.executeUpdate(query);
                    counter++;
                }
                else{
                    Thread.sleep(600);
                    Animation.fast("\n\tItem deos not exist!!");
                }
                Thread.sleep(300);
                Animation.fast("\n\tOrder more? (y/n)");
                char more=scan.next().charAt(0);
                if(more=='n'||more=='N'){
                    stop='y';
                    Thread.sleep(600);
                }else if (more=='y'||more=='Y'){

                }else{
                    Animation.fast("\tInvalid Option\n");
                }

                
                
            } while (stop=='n');
            if(counter!=0){
                Receipt.showReceipt();
            }
            // delete all

            String deleteQuery="delete from ordered";
            int rd=sta.executeUpdate(deleteQuery);
        } catch (Exception e) {
            // TODO: handle exception
        }
        
    }
}
