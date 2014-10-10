import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.io.Console;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.*;
import java.util.Scanner;

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
        System.out.println("c: create a marking report!");
        System.out.println("s: save the current marking report");
        System.out.println("m: invork the marking process");
        System.out.println("p: print the current satus of marking");
        System.out.println("r: report the current marking status into a file");
        System.out.println("o: logout out");
        System.out.println("h: help");
        System.out.println("please input abbr of operation: ");

	}

    protected void UILoop() {

        String line = "";
        while (true) {
            // Show a message to a user
            System.out.println("Enter Command:");

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
                case 'c':
                    // create a marking report
                    createFn(arguments);
                    break;
                case 's':
                    // save the current marking report
                    saveFn(arguments);
                    break;
                case 'l':
                    // load the specified marking report
                    loadFn(arguments);
                    break;
                case 'm':
                    // invork the marking process
                    markFn(arguments);
                    break;
                case 'p':
                    // print the current status of marking
                    statusFn(arguments);
                    break;
                case 'r':
                    // report the current marking status into a file
                    reportFn(arguments);
                    break;
                case 'h':
                     help();
                     break;
                case 'o':
                      logout();
                default:
                    System.err.println(command + " is not a valid command! Try again!");
                    break;
            }
            if (result) break;
        }
    }

	protected boolean markFn (String[] arguments) {
        if (assignment != null) assignment.markUI();
        else System.out.println("You must create or load an assignment first!");
        return false;
    }

    protected boolean saveFn (String arguments[]) {
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

    protected boolean loadFn (String arguments[]) {
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

    protected boolean statusFn (String arguments[]) {
        if (assignment != null)
            assignment.printStatus(new PrintStream(System.out));
        else
            System.out.println("Please create or load an assignment file first!");
        return false;
    }
    

    protected boolean reportFn (String arguments[]) {
        if (assignment != null)
            assignment.makeReports(arguments[0]);
        else
            System.out.println("Please create or load an assignment file first!");
        return false;
    }

    protected boolean createFn(String[] arguments) {
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

    protected boolean quitFn() {
    System.out.println("Quitting.  Hope you saved the assignment first.");
    return true;
}

}