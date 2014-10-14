import java.util.List;
import java.io.*;
import java.util.Scanner;


public class User{
    /**
    *The role of User
    */
    protected String role;
    /**
    *The userName of User
    */
    protected String userName;
        /**
    *The password of User
    */
    protected String password;
        /**
    *The first name of User
    */
    protected String firstName;
        /**
    *The last name of User
    */
    protected String lastName;
        /**



    /**
    *To get user name
    */
    public String getUserName(){
        return userName;
    }
        /**
    *To get password
    */
    public String getPassword(){
        return password;
    }
    
    
    
    public User()
    {
        userName = "";
        password = "";
        firstName = "";
        lastName = "";
    }

        /**
    *The complete constructor
    *@param uname This is the user name
    *@param uname This is the password
    *@param uname This is the first name
    *@param uname This is the last name
    */

    
    
    
    public User(String uname, String passwd, String fname, String lname)
    {
        userName = uname;
        password = passwd;
        firstName = fname;
        lastName = lname;
    }

        /**
    *Default constructor
    */

    /**
    *The help() method is rewrited in Administator, Lecturer, and Marker class, used to display help menu
    */
    public void help(){
    };

    /**
    *The create() method is rewrite in Administrator class, used to create unit
    */
    public void create(){

    }


    private void UILoop() {}

//         // String line = "";
//         // while (true) {
//         //     // Show a message to a user
//         //     System.out.println("Enter Command:");

//         //     // The system ask a user a commend
//         //     line = new Scanner(System.in).nextLine().trim();

//         //     // If the command is 'enter' or nothing, we do nothing.
//         //     if (line.equalsIgnoreCase("")) continue;

//         //     String commandList[] = line.split(" ");
//         //     char command = commandList[0].charAt(0);
//         //     String arguments[] = new String[commandList.length-1];
//         //     System.arraycopy(commandList, 1, arguments, 0, arguments.length);

//         //     boolean result = false;
//         //     switch (command) {
//         //         case 'q':
//         //             // exit the program
//         //             result = quitFn();
//         //             break;
//         //         case 'c':
//         //             // create a marking report
//         //             createFn(arguments);
//         //             break;
//         //         case 's':
//         //             // save the current marking report
//         //             saveFn(arguments);
//         //             break;
//         //         case 'l':
//         //             // load the specified marking report
//         //             loadFn(arguments);
//         //             break;
//         //         case 'm':
//         //             // invork the marking process
//         //             markFn(arguments);
//         //             break;
//         //         case 'p':
//         //             // print the current status of marking
//         //             statusFn(arguments);
//         //             break;
//         //         case 'r':
//         //             // report the current marking status into a file
//         //             reportFn(arguments);
//         //             break;
//         //         // case 'h':
//         //         //     help();
//         //         //     break;
//         //         default:
//         //             System.err.println(command + " is not a valid command! Try again!");
//         //             break;
//         //     }
//         //     if (result) break;
//         // }
//     }

    /**
     * logout method
     */
    
    public void logout(){
        System.out.println("Logout successfully!");
        login();
    }
    
    
    /**
    *login() is used to log in MarkerApp, there are 3 kinds of role:
    *Administrator, Lecturer, and Marker
    *First, user need to type user name, then type password, both of them cannot be empty.
    *Comparing user name and password with records in data file, if they exsit in data file,
    *it indicates the user login information is correct, otherwise system will display: username
    *or password is incorrect!
    */
    
    public void login(){

        boolean flag = true;
        
        
        String tempRole;
        String tempFname;
        String tempLname;
        String tempUname;
        String tempPasswd;
        
        while(flag){
            String uname = "";
            String passwd = "";
            //read username from user's input
            do{
                System.out.println("UserName:");
                
                uname = new Scanner(System.in).nextLine();
                if(uname.equals(""))
                    System.out.println("UserName cannot be empty!");
                else{
                    userName = uname;
                    break;
                }
            }while(true);
            //read password from user's input
            do{
                
                System.out.println("password:");
                passwd =  new Scanner(System.in).nextLine();
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
                            admin.adminUILoop();
                        }
                        //if role of user is lecturer
                        else if(tempRole.equals("Lecturer")){
                        //initial user1 as a lecturer
                            Lecturer lec = new Lecturer(tempUname, tempPasswd, tempFname, tempLname);
                            lec.help();
                            lec.lecturerUILoop();
                        }

                        //if role of user is marker
                        else if(tempRole.equals("Marker"))
                        //initial user1 as a marker
                        {
                            Marker mkr = new Marker(tempUname, tempPasswd, tempFname, tempLname);
                            mkr.help();
                            mkr.markerUILoop();
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
