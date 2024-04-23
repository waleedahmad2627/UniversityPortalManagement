package BusinessLogic;
import java.io.Serializable;
import java.util.ArrayList;

public class Attendance  implements Serializable{
	private String rollNo;
	private ArrayList<Boolean> presence;
	private ArrayList<String> date;
	
	public Attendance() {
		presence = new ArrayList<Boolean>();
		date = new ArrayList<String>();
		rollNo="";
	}
	
	public Attendance(String rollNo, ArrayList<Boolean> presence, ArrayList<String> date) {
		super();
		this.rollNo = rollNo;
		this.presence = presence;
		this.date = date;
	}
	public String getRollNo() {
		return rollNo;
	}
	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}
	public ArrayList<Boolean> getPresence() {
		return presence;
	}
	public void setPresence(ArrayList<Boolean> presence) {
		this.presence = presence;
	}

	public ArrayList<String> getDate() {
		return date;
	}

	@Override
	public String toString() {
		return "Attendance [rollNo=" + rollNo + ", presence=" + presence + ", date=" + date + "]";
	}

	public void setDate(ArrayList<String> date) {
		this.date = date;
	}
	
	
}
