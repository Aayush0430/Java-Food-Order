// Creating a text File using FileWriter 
import java.io.FileWriter; 
import java.io.IOException; 
class Write { 
    public static void main(String[] args) throws IOException 
    { 
        // Accept a string  
        String str =  String.format("ram-%s","raju");
  
        // attach a file to FileWriter  
        FileWriter fw=new FileWriter("output.txt"); 
  
        // read character wise from string and write  
        // into FileWriter  
        // for (int i = 0; i < str.length(); i++) 
            fw.write(str); 
  
        System.out.println("Writing successful"); 
        //close the file  
        fw.close(); 
    } 
}