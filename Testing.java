import java.util.Scanner;

public class Testing {
    public static void main(String[] args) {
        Scanner scan= new Scanner(System.in);
        System.out.println("Enter a number:\n");
        String num=scan.nextLine();
        System.out.println(num);
        switch (num) {
            case "10":
                System.out.println("hello");
                break;
        
            default:
                break;
        }
        scan.close();
    }
}



