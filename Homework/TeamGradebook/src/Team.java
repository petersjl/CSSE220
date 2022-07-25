import java.util.ArrayList;


public class Team {
	
	// You'll need to add methods, constructors and fields here
	private ArrayList<Student> members;
	private String teamName;
	private ArrayList<Double>teamGrades;
	
	public Team(String teamName, ArrayList<Student> memberNames) {
		this.teamName=teamName;
		this.members = memberNames;
		this.teamGrades= new ArrayList<Double>();
	}
	
	public String getName() {
		return teamName;
	}
	
	public ArrayList<Student> getMembers(){
		return members;
	}
	
	/**
	 * adds a given grade to the grades list
	 * 
	 * @param grade
	 */
	public void addGrade(double grade) {
		this.teamGrades.add(grade);
	}
	
	/**
	 * finds the average of all values in the teamGrades list
	 * 
	 * @return the average grade value
	 */
	public double averageGrade() {
		double total=0;
		for(int i = 0; i < teamGrades.size();i++) {
			total+=teamGrades.get(i);
		}
		return total/teamGrades.size();
	}
}
