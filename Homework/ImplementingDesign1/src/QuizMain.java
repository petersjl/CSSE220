import java.util.ArrayList;
import java.util.HashMap;

/**
  *  This class is used to demonstrate a functional design
  *  involving Quizzes and Questions which can be updated and displayed
  * 
  */
public class QuizMain {
	
	//TODO add instance variables here
	ArrayList<Question> qs;
	ArrayList<Quiz> quizzes;
	
	public QuizMain() {
		// TODO In order to demonstrate functionality, please follow the TODOs below
		// You will have to create questions and quizzes when a QuizMain is created
		
		// TODO 1 Create five questions (can be silly/basic questions) use id 1,2,3,4,5 ...
		Question one = new Question(1,"What is 5x3?");
		Question two = new Question(2,"What is 4x8?");
		Question three = new Question(3,"What is the capital of the US?");
		Question four = new Question(4,"What is the capital of Canada?");
		Question five = new Question(5,"What is the opposite of up?");
		qs = new ArrayList<Question>();
		qs.add(one);
		qs.add(two);
		qs.add(three);
		qs.add(four);
		qs.add(five);
	

		// TODO 2 Create three or more quizzes  use id 1,2,3...
		//      (One quiz should share at least one question with another )
		ArrayList<Question> addone = new ArrayList<Question>();
		addone.add(one);addone.add(two);addone.add(three);
		Quiz qone = new Quiz(1,addone);
		ArrayList<Question> addtwo = new ArrayList<Question>();
		addtwo.add(two);addtwo.add(three);addtwo.add(four);
		Quiz qtwo = new Quiz(2,addtwo);
		ArrayList<Question> addthree = new ArrayList<Question>();
		addthree.add(five);
		Quiz qthree = new Quiz(3,addthree);
		
		quizzes = new ArrayList<Quiz>();
		quizzes.add(qone);quizzes.add(qtwo);quizzes.add(qthree);

	}
	
	
	
	public static void main(String[] args) {
		//We want to use instance variables of the QuizMain class so we need to construct a QuizMain object
		QuizMain myQuizSimulator = new QuizMain();
		
		// TODO 3 Display three or more different quizzes
		System.out.println("--------------------------------------------------");
		System.out.println("Showing three or more original quizzes:");
		System.out.println("--------------------------------------------------");
		myQuizSimulator.handleDisplayQuiz(1);
		myQuizSimulator.handleDisplayQuiz(2);
		myQuizSimulator.handleDisplayQuiz(3);
		
		
		
		// TODO 4 Change two quiz questions 
		// A. (One should be shared with two or more quizzes)
		// B. (One should be unique to one quiz)
		myQuizSimulator.handleUpdateQuizQuestion(1,"What is different 1?");
		myQuizSimulator.handleUpdateQuizQuestion(2,"What is different 2?");

		
		// TODO 5 Display the same three (or more) quizzes
		//	   A. One that has a unique question which changed
		//	   B. Two which share a question that has been changed		
		System.out.println("--------------------------------------------------");
		System.out.println("Showing three or more changed quizzes:");
		System.out.println("--------------------------------------------------");
		myQuizSimulator.handleDisplayQuiz(1);
		myQuizSimulator.handleDisplayQuiz(2);
		myQuizSimulator.handleDisplayQuiz(3);
		
	}
	
	/**
	 *  This method should display a quiz in a very similar fashion to the output provided
	 *  in example_output.txt, which is located in your repository
	 * 
	 * 
	 * @param quizId
	 */
	public void handleDisplayQuiz(int quizId) {
		Quiz q = this.quizzes.get(quizId-1);
		System.out.println("Quiz: " + quizId);
		for(Question quest:q.getQuestions()) {
			System.out.println(quest);
		}
	}
	
	/**
	 * 
	 * This method should replace the data in the question with id=questionId with the new questionData 
	 * 
	 * @param questionId
	 * @param questionData
	 */
	public void handleUpdateQuizQuestion(int questionId, String questionData) {
		//TODO complete this method
		this.qs.get(questionId-1).updateQuestion(questionData);
	}

}
