import java.util.ArrayList;


public class Student {
	private String name;
	private int absences;
	private ArrayList<Double> grades;
	//TODO: You'll probably need to have some more fields here
	
	/**
	 * makes a new student object
	 * 
	 * @param newName the name of the student
	 */
	public Student(String newName) {
		this.name = newName;
		this.absences = 0;
		this.grades= new ArrayList<Double>();
	}

	/**
	 * gets the name of the student
	 * 
	 * @return the name of the student
	 */
	public String getName() {
		return name;
	}
	
	public int getAbsences() {
		return absences;
	}
	
	/**
	 * finds the average of all values in the grades list
	 * 
	 * @return average of grades list
	 */
	public int averageGrade() {
		double total=0;
		for(int i = 0; i < grades.size();i++) {
			total+=grades.get(i);
		}
		return (int)Math.round(total/grades.size());
	}
	
	public void addAbsence() {
		this.absences++;
	}
	
	public void addGrade(double grade) {
		grades.add(grade);
	}
	
}
