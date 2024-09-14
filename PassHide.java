import java.io.Console;

public class PassHide {

   /**
    */
  public static String PassCall(String ask) {  //Eg = password= PassHide.PassCall("enter pass")
		Console console = System.console() ;

		char [] password = console.readPassword(ask);
        String pass = new String(password);
        
        
        return pass;
	}

    public static void main(String[] args) {
        String password=PassCall("Enter password");
        System.out.println("password is :"+password);

    }
}
