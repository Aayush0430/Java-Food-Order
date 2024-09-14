import java.util.Scanner;
import java.sql.*;
public class SignUp {
    public static void sign() throws InterruptedException{
        Scanner scan= new Scanner(System.in);
        System.out.print("\033c");   //clear screen

        System.out.println("\n           ---- WELCOME TO SIGN UP ----\n");
        System.out.println("Please fill the following information:\n");
        Animation.fast("Enter new Username:\n");
        // System.out.println("Enter new Username:");
        String username=scan.next();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String dburl="jdbc:mysql://localhost/restaurant";
            Connection conn= DriverManager.getConnection(dburl, "root", "root");
            Statement sta = conn.createStatement(); 
            String query="select count(*) from users where username='"+username+"'";
            ResultSet rs = sta.executeQuery(query);
            rs.next();
            int found=rs.getInt(1);
            if (found==1) {
                Animation.fast("\n\tUsername already exists\n\n\tTry again!!\n\n");
                // System.out.println("\n\nUsername already exists");
                
            }
            else{
                Animation.fast("Enter your phone no.:\n");
                String phone=scan.next();

                Animation.fast("Enter your email:\n");
                String email=scan.next();

                Animation.fast("Enter new password:\n");
                String password=scan.next();
                
                Animation.fast("Enter password again:\n");
                // System.out.println("Enter password again: ");
                String passwordAgain=scan.next();
                Thread.sleep(300);
                System.out.println("\n");
                if (password.equals(passwordAgain)) {
                    String passquery="insert into users values('"+username+"','"+password+"','"+phone+"','"+email+"')";
                    int r = sta.executeUpdate(passquery);
                    if(r==1){
                        Animation.fast("\tSign Up was Successful!!\n");
                    }
                    else{
                        Animation.fast("\tSign Up was UnSuccessful!!\n");

                    }
                }
                else{
                    Animation.fast("\tPasswords did not match!\n\tTry again!!\n\n");
                    // System.out.println("\nPasswords did not match!");
                    SignUp.sign();
                }
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        }
    }
   
}
