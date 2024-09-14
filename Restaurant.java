import java.io.IOException;
import java.util.Scanner;
public class Restaurant {
   Restaurant(){
    
   }

   public static String throughMenu="nocall";
   public static String currentUser="guest";
    public static void main(String[] args) throws InterruptedException {
        Scanner scan=new Scanner(System.in);
        // scan.next();
        // System.out.print("\033c");   //clear screen
        System. out. flush();
        Thread.sleep(200);
        // Animation.fast("       ----- WElCOME TO RESTAURANT SERVICES -----");
        System.out.println("\n");
        
        boolean continueLoop=true;
        int choice=0;
        do {
            System.out.print("\033c");   //clear screen
            System. out. flush();
            Thread.sleep(200);
            System.out.println("       ----- WElCOME TO RESTAURANT SERVICES -----");
            System.out.println("\nChoose an option:");
        // System.out.print("\033c");//////////////////////////////////////////
        if (Restaurant.currentUser.equals("guest")) {
            System.out.println("1.View menu\t2.Login");
            System.out.println("3.Sign up\t4.Exit\n");
            try {
                choice = scan.nextInt();
                if(choice!=1 && choice!=2 && choice!=3 && choice!=4){
                    Animation.fast("\n\tInvalid Option!!\n");
                    continue;
                    
                }
            } catch (Exception e) {
                Animation.fast("\n\tInvalid Option!!\n");
                scan.next();
                continue;
            }

             Thread.sleep(600);

        }
        else if(Restaurant.currentUser.equals("member")){
            
             System.out.println("1.View menu\t2.Logout");
             System.out.println("3.Exit");
                
             Integer choiceMember;
              try {
                choiceMember = scan.nextInt();
                if(choiceMember!=1 && choiceMember!=2 && choiceMember!=3){
                    Animation.fast("\n\tInvalid Option!!\n");
                    continue;
                    
                }
            } catch (Exception e) {
                Animation.fast("\n\tInvalid Option!!\n");
                scan.next();
                continue;
            }

             Thread.sleep(600);
            
             switch (choiceMember) {
                case 1:
                    choice=1;
                    break;
                case 3:
                    choice=4;
                    break;
                case 2:
                    choice=5;
                    break;
                default:
                    Animation.fast("\n\tInvalid Option!!\n");                    
                    break;
             }

        }
        else if (Restaurant.currentUser.equals("admin")){
            Integer choiceAdmin;
            System.out.println("1.Add new item\t2.Delete item");
            System.out.println("3.Modify item\t4.Remove Members");
            System.out.println("5.View Menu\t6.Change Password");
            System.out.println("7.Logout\t8.Exit");
                try {
                    choiceAdmin = scan.nextInt();
                    if(choiceAdmin!=1 && choiceAdmin!=2 && choiceAdmin!=3 && choiceAdmin!=4 && choiceAdmin!=5 && choiceAdmin!=6 && choiceAdmin!=7 && choiceAdmin!=8 ){
                        Animation.fast("\n\tInvalid Option!!\n");
                        continue;
                        
                    }
                } catch (Exception e) {
                    Animation.fast("\n\tInvalid Option!!\n");
                    scan.next();
                    continue;
                }
            Thread.sleep(600);

            switch (choiceAdmin) {
                case 1:
                    choice=6;
                    break;
                case 2:
                    choice=7;
                    break;
                case 3:
                    choice=8;
                    break;
                case 4:
                    choice=10;
                    break;
                case 5:
                    choice=1;
                    break;
                case 6:
                    choice=9;
                    break;
                case 7:
                    choice=5;
                    break;
                case 8:
                    choice=4;
                    break;
                default:
                    System.out.println("invalid Option ");
                    break;
             }
        }
        
            switch (choice) {
            case 1:
                ViewMenu.menu();
                break;

            case 2:
                LoginPage.login();
                break;

            case 3:
                SignUp.sign();
                break;

            case 4:
                continueLoop=false;
                break;
            case 5:
                Logout.out();
                break;
            case 6:
                Add.addItem();
                break;
            case 7:
                Delete.deleteItem();
                break;
            case 8:
                Modify.modifyItem();
                break;
            case 9:
                AdminPass.changePass();
                break;
            case 10:
                Members.remove();
                break;
            
            default:
                
                break;
        }
        choice=0;
     } while (continueLoop);

    Exit.visitAgain();
    System.exit(0);
    // System.out.println("hi");
    }
    
}
