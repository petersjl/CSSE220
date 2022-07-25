
public class Question {
	private boolean answer;
	private String prompt;
	
	public Question(boolean answer, String prompt) {
		this.answer = answer;
		this.prompt = prompt;
	}
	
	public String toString() {
		return null;
	}
	
	public void updateQuestion(boolean answer, String prompt) {
		this.answer = answer;
		this.prompt = prompt;
	}
	
	public String getPrompt() {
		return this.prompt;
	}
	
	public boolean checkAnswer(boolean answer) {
		return this.answer==answer;
	}

}
