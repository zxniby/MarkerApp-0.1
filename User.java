import java.util.List;
import java.io.Console;
import java.io.BufferedReader;
import java.io.FileReader;
/**
*<h1><b>User Class<b></h1><br>
*<h3>User class is supclass of Administrator, Lecturer, and Marker.</h3>
*/

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
public boolean login()
	{
		boolean flag = false;
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
					String tempUname = parts[1];
					String tempPasswd = parts[2];
				//if username and password are correct
					if(uname.equals(tempUname)&&passwd.equals(tempPasswd))
					{
						String tempRole = parts[0];
						String tempFname = parts[3];
						String tempLname = parts[4];
						flag = true;
						//if role of user is administartor
						if(tempRole.equals("Admin")){
						//initial user1 as a administrator
							user1 = new Administrator(tempUname, tempPasswd, tempFname, tempLname);
						}
						//if role of user is lecturer
						else if(tempRole.equals("Lecturer")){
						//initial user1 as a lecturer
							user1 = new Lecturer(tempUname, tempPasswd, tempFname, tempLname);
						}

						//if role of user is marker
						else if(tempRole.equals("Marker"))
						//initial user1 as a marker
							user1 = new Lecturer(tempUname, tempPasswd, tempFname, tempLname);
						else
						//if the role of the person is none of administrator, lecturer, and marker, then return false
							flag = false;
						break;
					}

				}
			}catch(Exception e)
				{
					System.out.println(e.getMessage());
				}
				return flag;
		}

private boolean quitFn() {
    System.out.println("Quitting.  Hope you saved the assignment first.");
    return true;
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
