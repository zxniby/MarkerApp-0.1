import java.io.*;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: ybkan
 * Date: 7/08/14
 * Time: 1:53 PM
 * This MarkerApp class is the main class which can assess the assignments of students in target units.
 * The detailed guidline of the use of this class is found in "README_forstudents.txt" in the top directory.
 */
public class MarkerApp {

    // The assignment object to be shared in this class
   
    //private User user;

    /**
     * This function iteratively performs user actions according to user commends.
     * Depending on a particular input character, a function will be performed.
     * However, please ensure that each function performs correctly with appropriate
     * input parameters.
     */
    public static void main(String args[]) {
        //MarkerApp markerApp = new MarkerApp();
        
		// User tempuser = new User();
		// boolean flag;

    //     boolean flag = true;
    //     String tempRole;
    //     String tempFname;
    //     String tempLname;
    //     String tempUname;
    //     String tempPasswd;
		
    //     while(flag){
            
    //         Console console = System.console();
    //         String uname, passwd;
    //     //read username from user's input
    //         do{
    //             System.out.println("UserName:");
    //             uname = console.readLine().trim();
    //             if(uname.equals(""))
    //                 System.out.println("UserName cannot be empty!");
    //             else
    //                 break;
    //         }while(true);
    //     //read password from user's input
    //         do{
                
    //             System.out.println("password:");
    //             char[] passwdChar = console.readPassword();
    //             passwd = new String(passwdChar);
    //             if(passwd.equals(""))
    //                 System.out.println("Password cannot be empty!");
    //             else
    //                 break;
    //         }while(true);
            
    //         try{
    //             BufferedReader br  = new BufferedReader(new FileReader("data"));
    //             StringBuilder sb = new StringBuilder();
    //             String line;
    //             //check whether read record from text file
    //             while((line = br.readLine()) != null){
    //                 String[] parts = line.split(",");
    //                 tempUname = parts[1];
    //                 tempPasswd = parts[2];
    //             //if username and password are correct
    //                 if(uname.equals(tempUname)&&passwd.equals(tempPasswd))
    //                 {
    //                     tempRole = parts[0];
    //                     tempFname = parts[3];
    //                     tempLname = parts[4];
    //                     flag = false;
    //                     if(tempRole.equals("Admin"))
    //                     {
    //                         //initial user1 as a administrator
    //                         Administrator admin = new Administrator(tempUname, tempPasswd, tempFname, tempLname);
    //                         admin.help();
    //                         admin.UILoop();
    //                     }
    //                     //if role of user is lecturer
    //                     else if(tempRole.equals("Lecturer")){
    //                     //initial user1 as a lecturer
    //                         Lecturer lec = new Lecturer(tempUname, tempPasswd, tempFname, tempLname);
    //                         lec.help();
    //                         lec.UILoop();
    //                     }

    //                     //if role of user is marker
    //                     else if(tempRole.equals("Marker"))
    //                     //initial user1 as a marker
    //                     {
    //                         Marker mkr = new Lecturer(tempUname, tempPasswd, tempFname, tempLname);
    //                         mkr.help();
    //                         mkr.UILoop();
    //                     } 
    //                     else
    //                         System.out.println("Data is wrong, please check data.txt");
    //                 }
    //             }
    //         }catch(Exception e){
    //                 System.out.println(e.getMessage());
    //             }
                
    // }
        login();
}

public static void login(){
        System.out.println("****************************************************");
        System.out.println("*                                                  *");
        System.out.println("*                    MarkerApp                     *");
        System.out.println("*                                                  *");
        System.out.println("*                Xiangnan & Yafei                  *");
        System.out.println("*                                                  *");
        System.out.println("****************************************************");
        boolean flag = true;
        String tempRole;
        String tempFname;
        String tempLname;
        String tempUname;
        String tempPasswd;
        
        while(flag){
            
            Console console = System.console();
            String uname, passwd;
        //read username from user's input
            do{
                System.out.println("UserName:");
                uname = console.readLine().trim();
                if(uname.equals(""))
                    System.out.println("UserName cannot be empty!");
                else
                    break;
            }while(true);
        //read password from user's input
            do{
                
                System.out.println("password:");
                char[] passwdChar = console.readPassword();
                passwd = new String(passwdChar);
                if(passwd.equals(""))
                    System.out.println("Password cannot be empty!");
                else
                    break;
            }while(true);
            
            try{
                BufferedReader br  = new BufferedReader(new FileReader("data"));
                StringBuilder sb = new StringBuilder();
                String line;
                //check whether read record from text file
                while((line = br.readLine()) != null){
                    String[] parts = line.split(",");
                    tempUname = parts[1];
                    tempPasswd = parts[2];
                //if username and password are correct
                    if(uname.equals(tempUname)&&passwd.equals(tempPasswd))
                    {
                        tempRole = parts[0];
                        tempFname = parts[3];
                        tempLname = parts[4];
                        flag = false;
                        if(tempRole.equals("Admin"))
                        {
                            //initial user1 as a administrator
                            Administrator admin = new Administrator(tempUname, tempPasswd, tempFname, tempLname);
                            admin.help();
                            admin.UILoop();
                        }
                        //if role of user is lecturer
                        else if(tempRole.equals("Lecturer")){
                        //initial user1 as a lecturer
                            Lecturer lec = new Lecturer(tempUname, tempPasswd, tempFname, tempLname);
                            lec.help();
                            lec.UILoop();
                        }

                        //if role of user is marker
                        else if(tempRole.equals("Marker"))
                        //initial user1 as a marker
                        {
                            Marker mkr = new Lecturer(tempUname, tempPasswd, tempFname, tempLname);
                            mkr.help();
                            mkr.UILoop();
                        } 
                        else
                            System.out.println("Data is wrong, please check data.txt");
                    }
                }
            }catch(Exception e){
                    System.out.println(e.getMessage());
                }
                
    }
}
}

