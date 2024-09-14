import java.util.Scanner;
import java.sql.*;

public class Members {
    public static void remove(){
         Scanner scan = new Scanner(System.in);
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            String dburl="jdbc:mysql://localhost/restaurant";
            Connection conn= DriverManager.getConnection(dburl, "root", "root");
            Statement sta = conn.createStatement(); 

            //delete item add
            System.out.println("\n---------Remove Members:----------\n");

            //display members
            String membquery="Select username from users";
            ResultSet ms=sta.executeQuery(membquery);
            while(ms.next()){
                String uName=ms.getString(1);
                System.out.println("\t"+uName);
            }
            System.out.println("");
             


            System.out.println("\nEnter the name of the member you want to remove:");
            String memberName = scan.next();
            System.out.println("Confirm deletion!! (y/n)");
            Character confirmation=scan.next().charAt(0);
            
            if (confirmation.equals('y')) {
                String query="delete from users where username='"+memberName+"'";
                int rs = sta.executeUpdate(query);
                if (rs==1) {
                    Animation.fast("\n\tMember ("+memberName+") was removed successfully!");
                } else {
                    Animation.fast("\n\tMember was not found\n");
                }
            } 
        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        }
    }
    
}
