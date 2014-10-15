import java.util.List;
import java.io.*;
import java.util.Scanner;
public class Unit{
	private int unitCode;
	private String unitName;
	private String unitDescription;
	List<Assignment> assignemnts;
	Lecturer lecturer;

	public int getUnitCode(){
		return unitCode;
	}

	public void create(){
		System.out.println("please input unit code: ");
		unitCode = new Scanner(System.in).nextLine();
		FileInputStream fin = new FileInputStream(unitList)
		ObjectInputStream ois = new ObjectInputStream(fout)

	}
}