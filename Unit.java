import java.util.List;
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Unit implements Serializable{
	private String unitCode;
	private String unitName;
	private String unitDescription;
	List<Assignment> assignemnts;
	Lecturer lecturer;

public Unit(){}

public Unit(String uCode, String uName, String uDesc)
{
	
	this.unitCode = uCode;
	this.unitName = uName;
	this.unitDescription = uDesc;
}

	public String getUnitCode(){
		return unitCode;
	}

	public static void main(String[] args){
		Unit unit = new Unit();
		System.out.println("load file");
		unit.create();
	}

	public void create(){
		boolean flag = true;
		List<Unit> unitList = new ArrayList<Unit>();
		
		try{
			String uCode = "", uName, uDesc;
			//load data from file
			File file = new File("unitData.ser");

			if(file.length()!=0)
			{
				FileInputStream fin = new FileInputStream(file);
				ObjectInputStream ois = new ObjectInputStream(fin);
				
				unitList = (List<Unit>) ois.readObject();
				ois.close();	
				fin.close();
				//size of unitList
				int size = unitList.size();

				//verify unit code
				while(flag)
				{	
					//boolean unitFlag = true;
					System.out.println("please input unit code: ");
					//uCode is used to receive what user typed
					uCode = new Scanner(System.in).nextLine().trim();
					int k;
					//retrieve unitList
					for(k = 0; k < size; k++){
						//if unitCode is same
						if(uCode.equals(unitList.get(k).unitCode))
						{
							//unit is already here
							System.out.println("The unit has exsited!\n");
							//flag = false;
							break;
						}
					}
						if(k + 1 == size)
							flag = false;

				}


			}
			else
			{
					System.out.println("please input unit code: ");
					//uCode is used to receive what user typed
					uCode = new Scanner(System.in).nextLine();
			}

				System.out.println("please input unit name: ");
				uName = new Scanner(System.in).nextLine().trim();
				System.out.println("please input unit Description: ");
				uDesc = new Scanner(System.in).nextLine().trim();
				Unit newUnit = new Unit(uCode, uName,uDesc);
				unitList.add(newUnit);
				FileOutputStream fout = new FileOutputStream(file);
            	ObjectOutputStream oos = new ObjectOutputStream(fout);
            	oos.writeObject(unitList);
            	oos.close();
            	fout.close();
				System.out.println("CREATE SUCCESSFULLY");



		}catch(Exception e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		

	}
}