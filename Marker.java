
import java.util.*;



import java.io.*;



public class Marker extends User{

    protected Assignment assignment;  
    // private String UserName;
    // private String Password;
    public Marker(){}
    public Marker(String uname, String passwd, String fname, String lname){
        userName = uname;
        password = passwd;
        firstName = fname;
        lastName = lname;
        
    }
    
    public void markerUILoop() {


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
                case 'w':
                    // set submission as withheld
                    setWithheldFn();
                    break;
                default:
                    System.err.println(command + " is not a valid command! Try again!");
                    break;
            }
            if (result) break;
        }
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

    protected boolean markFn (String[] arguments) {
        if (assignment != null) assignment.markUI();
        else System.out.println("You must create or load an assignment first!");
        return false;
    }

    protected void saveFn (String arguments[]) {
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
    }


    protected boolean statusFn (String arguments[]) {
        if (assignment != null)
            assignment.printStatus(new PrintStream(System.out));
        else
            System.out.println("Please create or load an assignment file first!");
        return false;
    }
    
    
    /**setWithheldFn method is for instructing users to finish set withheld operation*/

    protected void setWithheldFn() {
        if (assignment != null)
            assignment.setWithheldUI();
        else
            System.out.println("Please create or load an assignment file first!");
        
    }
    

    protected boolean reportFn (String arguments[]) {
        if (assignment != null)
            assignment.makeReports(arguments[0]);
        else
            System.out.println("Please create or load an assignment file first!");
        return false;
    }


    protected boolean quitFn() {
    System.out.println("Quitting.  Hope you saved the assignment first.");
    return true;
    }
    
    
    public void help(){
        System.out.println("s: save the current marking report");
        System.out.println("m: invork the marking process");
        System.out.println("p: print the current satus of marking");
        System.out.println("r: report the current marking status into a file");
        System.out.println("o: logout out");
        System.out.println("h: help");
        System.out.println("w: withheld");
        System.out.println("please input abbr of operation: ");

    }

}
