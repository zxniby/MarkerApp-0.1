import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.io.Console;
import java.io.BufferedReader;
import java.io.FileReader;

public class Marker extends User{
	// private String UserName;
	// private String Password;
	public Marker(String uname, String passwd, String fname, String lname){
		userName = uname;
		password = passwd;
		firstName = fname;
		lastName = lname;
		
	}
	public Marker(){}

	public void help(){
		System.out.println("The abbrs for all operation:");
		System.out.println("m: mark submission");
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

}