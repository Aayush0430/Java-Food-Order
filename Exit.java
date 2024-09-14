import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Exit {//██
    public static void visitAgain() throws InterruptedException{
        // public static void main(String[] args) throws InterruptedException{
        // System.out.print("\033c");
       Animation.fast("\t----Exited----\n");
       try {
           File file = new File("exit.txt");
        Scanner scan = new Scanner(file);
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            System.out.println(line);
            Thread.sleep(75);
            
        }
        
    } catch (Exception e) {
        // TODO: handle exception
    }
    }
}
