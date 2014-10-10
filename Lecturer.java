import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.io.Console;
import java.io.BufferedReader;
import java.io.FileReader;

public class Lecturer extends User{


	public Lecturer(String uname, String passwd, String fname, String lname){
		userName = uname;
		password = passwd;
		firstName = fname;
		lastName = lname;
		
	}
	public Lecturer(){}
	public void help(){
		System.out.println("The abbrs for all operation:");
		System.out.println("c: create assingment");
		System.out.println("a: assign marker to assignment");
		System.out.println("m: mark submission");
		System.out.println("w: set withheld");
		System.out.println("l: clean withheld");
		System.out.println("r: get unit summary report");
		System.out.println("o: logout");
		System.out.println("please input abbr of operation: ");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try{
			while(true)
			{	
				System.out.println("Input q to exit: ");
				String temp = br.readLine().trim();
				if(temp.equals("q"))
					break;
			}
		}catch(Exception e){
			System.err.println(e.getMessage());
		}


	}

    private boolean createFn(String[] arguments) {
        if (arguments.length != 2) {
            System.out.print("You must specify a spec file and a student list");
            return false;
        } else {
            String assignFile = arguments[0];
            String studFile = arguments[1];
            assignment = new Assignment(assignFile, studFile);
            return false;
        }
    }


}