import java.util.Scanner;
import java.sql.*;

public class LoginPage {
    public static String currentUserName;//Name of current user

    public static void login() throws InterruptedException{
        System.out.println("\n-> Enter a choice:");
        System.out.println("\t1.Admin Login\t2.Guest Login\n");
        Scanner scan= new Scanner(System.in);
        char choice= scan.next().charAt(0);
        if (choice=='1') {

            adminLogin();
        } else if(choice=='2') {

            guestLogin();
        }else{
            Animation.fast("\tInvalid choice!\n");
        }
    }
    public static void adminLogin() throws InterruptedException{
                    System.out.print("\033c");   //clear screen
        Animation.fast("\n      ---- Admin Login Page ----\n");
        // System.out.print("\033c");   //clear screen

        // test// Restaurant.currentUser="admin";

        //---------- admin username and password-------------
        // String adminUsername = "asur", adminPassword= "asur.cha";

        Character test='y';

        do {
            System.out.println("Enter Admin Username:");
        Scanner scan = new Scanner(System.in);
        String usernameCheck =  scan.next();
        // System.out.println("\nEnter Admin Password:");
        String passwordCheck =  PassHide.PassCall("Enter Admin Password:");
        scan.nextLine();

        try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                String dburl="jdbc:mysql://localhost/restaurant";
                Connection conn= DriverManager.getConnection(dburl, "root", "root");
                Statement sta = conn.createStatement(); 
                String query="select username from adminPass";
                ResultSet rs = sta.executeQuery(query);
                rs.next();
                String dataUsername=rs.getString(1);
                if (dataUsername.equals(usernameCheck)) {
                    String passQuery="select password from adminPass";
                    ResultSet rpass=sta.executeQuery(passQuery);
                    rpass.next();
                    String datapass=rpass.getString(1);
                    if (datapass.equals(passwordCheck)) {
                        Thread.sleep(600);
                        Animation.fast("\n\tLog In Successful!!\n\n");
                        test='n';
                        Restaurant.currentUser="admin";


                        
                    }
                    else{
                        Thread.sleep(600);
                        Animation.fast("\n\tPassword incorrect!!\n\n");
                    }
                }
                else{
                    Thread.sleep(600);
                    Animation.fast("\n\n\tUsername incorrect!!\n\n");
                }
                conn.close();

            } catch (Exception e) {
                e.printStackTrace();
                // TODO: handle exception
            }

        } while (test=='y');
        
    }
    public static void guestLogin() throws InterruptedException{
        
        System.out.print("\033c");   //clear screen

        // Thread.sleep(400);
        // System.out.print("\033c");   //clear screen
        Scanner scan= new Scanner(System.in);
        // scan.next();

        Animation.superFast("      ---- Guest Login Page ----\n\n");
        // Thread.sleep(600);

        Animation.fast("Do you have an account (y/n)?\n");
        char yesno= scan.next().charAt(0);
        if (yesno=='n'|| yesno=='N') 
        {
            Thread.sleep(600);
            Animation.fast("Do you want to Sign up? (y/n)\n");           
             char signRequest=scan.next().charAt(0);
                if (signRequest=='y'||signRequest=='Y') {
                    SignUp.sign();
                    
                } else if(signRequest=='n'||signRequest=='N') {
                    // Restaurant.main(null);
                }
                else{
                    Thread.sleep(300);
                    Animation.fast("\tInvalid choice");
                }
        }
        
        else if(yesno=='y'||yesno=='Y'){
            System.out.println("Enter your Username:");
            // System.out.println("\nEnter your Username:");
            String guestUsername =  scan.next();
            Thread.sleep(300);
            // Animation.fast("Enter your Password:\n");
            // System.out.println("Enter your Password:");
            String password =  PassHide.PassCall("Enter your Password:\n");
            Animation.fast("\tverifying");
            Animation.superSlow("...");
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                String dburl="jdbc:mysql://localhost/restaurant";
                Connection conn= DriverManager.getConnection(dburl, "root", "root");
                Statement sta = conn.createStatement(); 
                String query="select count(*) from users where username='"+guestUsername+"'";
                ResultSet rs = sta.executeQuery(query);
                rs.next();
                int found=rs.getInt(1);
                if (found==1) {
                    String passQuery="select password from users where username='"+guestUsername+"'";
                    ResultSet rpass=sta.executeQuery(passQuery);
                    rpass.next();
                    String datapass=rpass.getString(1);
                    if (datapass.equals(password)) {
                        Thread.sleep(600);
                        Animation.fast("\n\tLog In Successful!!\n");
                        Restaurant.currentUser="member";
                        LoginPage.currentUserName=guestUsername;
                        if(Restaurant.throughMenu.equals("call")){
                            ViewMenu.menu();

                        }

                    }
                    else{
                        Thread.sleep(600);
                        Animation.fast("\n\tPassword incorrect!!");
                    }
                }
                else{
                    Thread.sleep(600);
                    Animation.fast("\n\n\tUsername not found!!");
                }
                conn.close();

            } catch (Exception e) {
                e.printStackTrace();
                // TODO: handle exception
            }
        }
        else{
                Thread.sleep(600);
                Animation.fast("\tinvalid Choice!\n");
                
        }
    }
}
//admin login dont know pass ask to try againa