import java.util.Scanner;

public class Logout {
    public static void out() throws InterruptedException{
        Scanner scan = new Scanner(System.in);
        System.out.println("\n");
        Animation.fast("\tConfirm(y/n):");
        Character choice= scan.next().charAt(0);
        if (choice=='y'||choice=='Y') {
            Animation.fast("\tLogged out!");
            Animation.slow("        ");
            System.out.println("\n");
            Restaurant.currentUser="guest";
        } else if(choice=='n'||choice=='N') {
            
        }else{
            Animation.fast("\tInvalid option!\n");
        }
        
        
    }
}
