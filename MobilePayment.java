import java.io.*;

public class MobilePayment {
  //  public static void test() throws Exception{
   public static void main(String[] args) throws Exception {
      String command= "";
      Process runtime = Runtime.getRuntime().exec("curl qrenco.de/https://www.nccs.edu.np");
      Show_Output(runtime);
    }
    public static void Show_Output(Process process) throws IOException {
      BufferedReader output_reader =
          new BufferedReader(new InputStreamReader(process.getInputStream()));
      String output = "";
      while ((output = output_reader.readLine()) != null) {
        System.out.println(output);
      }
    }






      //   public static void main(String[] args) throws Exception{
        
      //    String command = "curl qrenco.de/hello";
      //    ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/c", command);
      //    Process p = pb.start();





            // String command_to_playwith =" title Scan it";
            // String command_to_playwith = " curl qrenco.de/https://www.nccs.edu.np ";
            // System.out.println("Opening cmd window");
            // try {
            //    String command = "cmd /c" + " start" + command_to_playwith ;
            //    //Starting the new child process.
            //    Process childprocess11 = Runtime.getRuntime().exec(command);
            //    Thread.sleep(1000);
            //    System.out.println();
            // }
            // catch (Exception e){
            //    System.out.println("Error: " + e);
            // }

            // }


        
    // // public static void test() throws Exception {
    //     System.out.println("qr");
    //     ProcessBuilder builder = new ProcessBuilder(

    //         "pwsh.exe", "/c", "curl qrenco.de/https://nccs.edu.np/");

    //     builder.redirectErrorStream(true);
        
    //     Process p = builder.start();
        
    //     System.out.println("hello");
    //     BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
        
    //     String line;
        
    //     while (true) {
            
    //         line = r.readLine();
            
    //         if (line == null) { break; }
            
    //         System.out.println(line);
            
    //     }

   //  }

}