package BusinessLogic;

import java.io.Serializable;
import java.util.ArrayList;

public class Marks  implements Serializable{
	private String rollNo;
	private String grade;
	private ArrayList<Integer> assignments;
	private ArrayList<Integer> quizes;
	private ArrayList<Integer> Sessionals;
	private Integer finalMarks;
	public Marks(){
		quizes = new ArrayList<Integer>();
		assignments = new ArrayList<Integer>();
		Sessionals = new ArrayList<Integer>();
		grade = rollNo = "";
		finalMarks = 0;
	}
	
	@Override
	public String toString() {
		return "Marks [rollNo=" + rollNo + ", grade=" + grade + ", assignments=" + assignments + ", quizes=" + quizes
				+ ", Sessionals=" + Sessionals + ", finalMarks=" + finalMarks + "]";
	}

	
	
	public Marks(String rollNo, String grade, ArrayList<Integer> assignments, ArrayList<Integer> quizes,
			ArrayList<Integer> sessionals, Integer finalMarks) {
		super();
		this.rollNo = rollNo;
		this.grade = grade;
		this.assignments = assignments;
		this.quizes = quizes;
		Sessionals = sessionals;
		this.finalMarks = finalMarks;
	}

	public String getRollNo() {
		return rollNo;
	}
	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public ArrayList<Integer> getAssignments() {
		return assignments;
	}
	public void setAssignments(ArrayList<Integer> assignments) {
		this.assignments = assignments;
	}
	public ArrayList<Integer> getQuizes() {
		return quizes;
	}
	public void setQuizes(ArrayList<Integer> quizes) {
		this.quizes = quizes;
	}
	public ArrayList<Integer> getSessionals() {
		return Sessionals;
	}
	public void setSessionals(ArrayList<Integer> sessionals) {
		Sessionals = sessionals;
	}
	public Integer getFinalMarks() {
		return finalMarks;
	}
	public void setFinalMarks(Integer finalMarks) {
		this.finalMarks = finalMarks;
	}
	
}
