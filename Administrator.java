import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.io.Console;
import java.io.BufferedReader;
import java.io.FileReader;


public class Administrator extends User{
// 	private String UserName;
// 	private String Password;
	List<Lecturer> lecturers;
	List<Unit> units;

	public void create()
	{
		try{


		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean flag = true;
		while(flag){
			System.out.println("please type unitCode: ");
			String uCode = br.readLine().trim();
			for(int i = 0; i < units.size(); i++){
				Unit ut = new Unit();
				if(uCode.equals(ut.getUnitCode()))
				{
					System.out.println("Unit code is already exist");
					break;
				}
			}
			flag = false;
		}
	}catch(Exception e){
		System.out.println(e.getMessage());
	}
		
	}

	public Administrator(String uname, String passwd, String fname, String lname){
		userName = uname;
		password = passwd;
		firstName = fname;
		lastName = lname;
		
	}
	public Administrator(){}

	public void help(){
		System.out.println("The abbrs for all operation:");
		System.out.println("c: create unit");
		System.out.println("a: assignmet lecturer to unit");
		System.out.println("o: logout");
		System.out.println("h: help");
		
		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// try{
		// 	while(true)
		// 	{	
		// 		System.out.println("Input q to exit: ");
		// 		String temp = br.readLine().trim();
		// 		if(temp.equals("q"))
		// 			break;
		// 	}
		// }catch(Exception e){
		// 	System.err.println(e.getMessage());
		// }

	}

	public static void main(String[] args) throws IOException{
		Administrator admin = new Administrator();
		admin.create();
		admin.help();
	}

	protected void UILoop() {
		Administrator tempAdmin = new Administrator();
        String line = "";
        while (true) {
            // Show a message to a user
            System.out.println("Enter Command:");
            //tempAdmin.help();

            // The system ask a user a commend
            line = new Scanner(System.in).nextLine().trim();

            // If the command is 'enter' or nothing, we do nothing.
            if (line.equalsIgnoreCase("")) continue;

            String commandList[] = line.split(" ");
            char command = commandList[0].charAt(0);
            String arguments[] = new String[commandList.length-1];
            System.arraycopy(commandList, 1, arguments, 0, arguments.length);

            boolean result = false;

            switch (command) {
                case 'q':
                    // exit the program
                    result = quitFn();
                    break;
                case 'o':
                	tempAdmin.logout();
                	break;
                case 'h':
                    tempAdmin.help();
                    break;
                default:
                    System.err.println(command + " is not a valid command! Try again!");
                    break;
            }
            if (result) break;
        }
    }
}