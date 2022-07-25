import java.util.HashMap;
import java.util.Set;

public class Quiz {
	
	private HashMap<Integer, Question> questions;
	
	public Quiz() {
		this.questions = new HashMap<Integer, Question>();
	}
	
	public void addQuestion(int id, Question question) {
		questions.put(id, question);
	}
	
	public String toString(int QuizId) {
		String output = "";
		output= output+ "Quiz " + Integer.toString(QuizId);
		Set<Integer> s = questions.keySet();
		for(Integer q:s) {
			output = output +"\n Question " + Integer.toString(q) + ": " + questions.get(q).getPrompt();
		}
		output+="\n";
		
		return output;
	}
	
	public HashMap<Integer, Question> getQuestions(){
		return questions;
	}
}
