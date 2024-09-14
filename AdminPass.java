import java.util.Scanner;
import java.sql.*;

public class AdminPass {
public static void changePass(){
    Scanner scan = new Scanner(System.in);
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            String dburl="jdbc:mysql://localhost/restaurant";
            Connection conn= DriverManager.getConnection(dburl, "root", "root");
            Statement sta = conn.createStatement(); 

            //new item add
            Animation.fast("\n\tChange Admin Password:\n");
            System.out.println("Enter the new password:");
            String newAdminPassword = scan.next();
            System.out.println("Enter the new password again:");
            String newAdminPasswordAgain = scan.next();
            if (newAdminPassword.equals(newAdminPasswordAgain)) {
                
                String query="select password from adminPass";
                ResultSet rs = sta.executeQuery(query);
                rs.next();
                String dataPassword=rs.getString(1);
               
                if (dataPassword.equals(newAdminPassword)) {
                    Animation.fast("\n\tNew password cannot be same as old password!!\n");
                }else{
                     System.out.println("Enter the old password:");
                     String oldAdminPassword = scan.next();
                    if (dataPassword.equals(oldAdminPassword)) {
                    String AdminPassChangeQuery="UPDATE adminPass SET password = '"+newAdminPassword+"'";
                    int rsAdmin = sta.executeUpdate(AdminPassChangeQuery);

                        Animation.fast("\n\n\tAdmin Password changed successfully!\n");
                } else {
                    Animation.fast("\n\tOld Password incorrect!!\n\n");
                }
                }
            }else{
                    Animation.fast("\n\tPasswords donot match!!\n");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        }
}
    //password enter again
    
}
