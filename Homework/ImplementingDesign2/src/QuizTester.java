import java.util.HashMap;
import java.util.Set;

public class QuizTester {
	
	private String searchString;
	
	public QuizTester(String searchString) {
		this.searchString = searchString;
	}
	
	public double getScore(Quiz q) {
		int correct = 0;
		int count = 0;
		double score = 0.0;
		String checkTo = this.searchString;
		HashMap<Integer, Question> questions = q.getQuestions();
		Set<Integer> s = questions.keySet();
		for(Integer qnum:s) {
			String prompt = questions.get(qnum).getPrompt();
			String check = prompt.substring(0, checkTo.length());
			boolean answer = false;
			for(int i = 0; i<prompt.length()-checkTo.length();i++) {
				if(check.equals(checkTo)) {
					answer = true;
					i = prompt.length();
				}
				else {
					check = prompt.substring(i,i+checkTo.length());
				}
				
			}
			if(questions.get(qnum).checkAnswer(answer)) {
				correct++;
			}
			count++;
		}
		score = (double)correct/count;
		
		return score;
	}
	
	public double getAllScore(HashMap<Integer,Quiz> quizzes) {
		double average = 0.0;
		double total = 0.0;
		double count = 0.0;
		Set<Integer> s = quizzes.keySet();
		for(Integer q:s) {
			total+=getScore(quizzes.get(q));
			count++;
		}
		average = total/count;
		return average;
	}
}
