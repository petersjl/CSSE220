/**
  * 
  * TODO This class should documented with a purpose!
  *
  * 
 */
public class Question {
		private int id;
		private String question;
		
		public Question(int id, String question) {
			this.id =id;
			this.question = question;
		}
		
		public String toString() {
			return "Question[" + Integer.toString(id) +"]: " + question;
		}
		
		public void updateQuestion(String question) {
			this.question = question;
		}
}
