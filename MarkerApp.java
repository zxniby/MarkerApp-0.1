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
        
		User tempuser = new User();
		//Console console = System.console();
		boolean flag;
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true){
			if(tempuser.login())
				break;
			else
				System.out.println("username or password is incorrect,please try again:");
		}
		User user = tempuser.getUser1();
        user.help();
        user.UILoop();
		
        
        //markerApp.UILoop();
    }
}
