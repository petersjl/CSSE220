import java.util.ArrayList;

/**
  * 
  * TODO This class should documented with a purpose!
  *
  * 
 */
public class Quiz {
	
	private int id;
	private ArrayList<Question> questions;
	
	public Quiz(int id, ArrayList<Question> questions) {
		this.id = id;
		this.questions = new ArrayList<Question>();
		for(Question q: questions) {
			this.questions.add(q);
		}
	}
	
	public void displayQuestions() {
		for(Question q:questions) {
			System.out.println(q);
		}
	}
	
	public int getId() {
		return id;
	}
	
	public ArrayList<Question> getQuestions(){
		return questions;
	}

}
