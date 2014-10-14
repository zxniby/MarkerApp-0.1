import java.util.List;
import java.util.Scanner;
import java.io.*;

public class Lecturer extends Marker{


    public Lecturer(String uname, String passwd, String fname, String lname){
        this.userName = uname;
        this.password = passwd;
        this.firstName = fname;
        this.lastName = lname;
        
    }
    public Lecturer(){}
    public void help(){
        System.out.println("c: create an Assignment!");
        System.out.println("s: save the current marking report");
        System.out.println("m: invork the marking process");
        System.out.println("p: print the current satus of marking");
        System.out.println("r: report the current marking status into a file");
        System.out.println("o: logout out");
        System.out.println("h: help");
        System.out.println("w: withheld");
        System.out.println("please input abbr of operation: ");

    }

        protected void lecturerUILoop() {


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