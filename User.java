import java.util.List;
import java.io.*;
import java.util.Scanner;
/**
*<h1><b>User Class<b></h1><br>
*<h3>User class is supclass of Administrator, Lecturer, and Marker.</h3>
*/

public class User{
	protected Assignment assignment;
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
	*The login user
	*/
	private User user1;

	/**
	*To get login user
	*/
	public User getUser1(){
		return user1;
	}
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
	public User(){}

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
	/**
	*login() is used to log in MarkerApp, there are 3 kinds of role:</br> 
	*Administrator, Lecturer, and Marker</br>
	*First, user need to type user name, then type password, both of them cannot be empty.<br>
	*Comparing user name and password with records in data file, if they exsit in data file,<br>
	*it indicates the user login information is correct, otherwise system will display: username<br>
	*or password is incorrect!
	*/
// public boolean login()
// 	{

//     }

// protected boolean quitFn() {
//     System.out.println("Quitting.  Hope you saved the assignment first.");
//     return true;
// }

// protected boolean markFn (String[] arguments) {
//         if (assignment != null) assignment.markUI();
//         else System.out.println("You must create or load an assignment first!");
//         return false;
//     }

// protected boolean saveFn (String arguments[]) {
//         String name = arguments[0];

//         try {
//             FileOutputStream fout = new FileOutputStream(name, true);
//             ObjectOutputStream oos = new ObjectOutputStream(fout);
//             oos.writeObject(assignment);
//             oos.close();
//             fout.close();

//             System.out.println(name + " has been successfully saved!");
//         } catch (Exception e) {
//             e.printStackTrace();
//         }
//         return false;
//     }

//     protected boolean loadFn (String arguments[]) {
//         String name = arguments[0];

//         try {
//             FileInputStream fin = new FileInputStream(name);
//             ObjectInputStream  ois = new ObjectInputStream(fin);
//             assignment = (Assignment) ois.readObject();
//             ois.close();
//             fin.close();
//         } catch (Exception e) {
//             e.printStackTrace();
//         }
//          return false;
//     }

//     protected boolean statusFn (String arguments[]) {
//         if (assignment != null)
//             assignment.printStatus(new PrintStream(System.out));
//         else
//             System.out.println("Please create or load an assignment file first!");
//          return false;
//     }


    protected void UILoop() {}

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

    public void logout(){
    	System.out.println("Logout successfully!");
        MarkerApp.login();
    }

}
