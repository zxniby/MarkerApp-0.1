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

	private boolean markFn (String[] arguments) {
        if (assignment != null) assignment.markUI();
        else System.out.println("You must create or load an assignment first!");
        return false;
    }

    private boolean saveFn (String arguments[]) {
        String name = arguments[0];

        try {
            FileOutputStream fout = new FileOutputStream(name, true);
            ObjectOutputStream oos = new ObjectOutputStream(fout);
            oos.writeObject(assignment);
            oos.close();
            fout.close();

            System.out.println(name + " has been successfully saved!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private boolean loadFn (String arguments[]) {
        String name = arguments[0];

        try {
            FileInputStream fin = new FileInputStream(name);
            ObjectInputStream  ois = new ObjectInputStream(fin);
            assignment = (Assignment) ois.readObject();
            ois.close();
            fin.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private boolean statusFn (String arguments[]) {
        if (assignment != null)
            assignment.printStatus(new PrintStream(System.out));
        else
            System.out.println("Please create or load an assignment file first!");
        return false;
    }

    private boolean reportFn (String arguments[]) {
        if (assignment != null)
            assignment.makeReports(arguments[0]);
        else
            System.out.println("Please create or load an assignment file first!");
        return false;
    }

}