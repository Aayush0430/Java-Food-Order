import java.sql.*;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthStyle;


public class Payment {
    public static void pay(int totalAmount) throws Exception{
        System.out.println("\nHow would you like to pay?");
        System.out.println("\t1.Cash\t2.Mobile payment!");
        Scanner scan = new Scanner(System.in);
        char choice = scan.next().charAt(0);
                switch (choice) {
            case '1':
                cashpay(totalAmount);
                break;
            case '2':
                qrpay();
                break;
        
            default:
                Animation.fast("\n\tInvalid choice pick again!!\n");
                Payment.pay(totalAmount);;
                break;
        }   
        Print.write();

     
    }
    public static void cashpay(int totalAmount) throws InterruptedException{
        // System.out.println("Please pay "+" at the counter...");
             Animation.fast("\n\tPlease pay Rs "+totalAmount+" at the counter...\n");
               PassHide.PassCall("\tPress enter to continue!");

        
         
    }
    public static void qrpay() throws Exception{
        System.out.println("");
        MobilePayment.test();
        Animation.fast("\tPlease scan the qr code to pay!\n");
        PassHide.PassCall("Enter to continue");
        //qr section
    }
}
