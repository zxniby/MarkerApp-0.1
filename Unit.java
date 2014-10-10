import java.util.List;
public class Unit{
	private int unitCode;
	private String unitName;
	private String unitDescription;
	List<Assignment> assignemnts;
	Lecturer lecturer;

	public int getUnitCode(){
		return unitCode;
	}
}