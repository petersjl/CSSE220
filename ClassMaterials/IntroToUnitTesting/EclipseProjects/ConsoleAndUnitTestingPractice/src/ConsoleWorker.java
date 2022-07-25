import java.util.Scanner;

/**
 * This is an example of using a Scanner to read console input.
 * 
 * @author Delvin Defoe. Created Sep 16, 2015.
 */
public class ConsoleWorker {
	
	private Scanner inputScanner;
	private String name;
	private int birthMonth;
	private int birthDay;
	private int birthYear;
	private double annualSalary;
	
	/**
	 * Constructs a new ConsoleWorker, initializing the input scanner
	 *
	 */
	public ConsoleWorker(){
		this.inputScanner = new Scanner(System.in);
	}
	
	/**
	 * Returns the user's name
	 *
	 * @return user name
	 */
	public String getName(){
		return this.name;
	}
	
	/**
	 * Returns the user's birth month
	 *
	 * @return user birth month
	 */
	public int getBirthMonth(){
		return this.birthMonth;
	}
	
	/**
	 * Returns the user's birth day
	 *
	 * @return user birth day
	 */
	public int getBirthDay(){
		return this.birthDay;
	}
	
	/**
	 * Returns the user's birth year
	 *
	 * @return user birth year
	 */
	public int getBirthYear(){
		return this.birthYear;
	}
	
	/**
	 * Returns the user's annual salary
	 *
	 * @return user annual salary
	 */
	public double getAnnualSalary(){
		return this.annualSalary;
	}	

	/**
	 * Starts here.
	 * 
	 * @param args
	 *            ignored
	 */
	public static void main(String[] args) {
		ConsoleWorker worker = new ConsoleWorker();

		// TODO uncomment the code below and implement 
		// the missing methods, adding appropriate prompts 
		// before each input.
		worker.setName();
		worker.setBirthMonth();
		worker.setBirthDay();
		worker.setBirthYear();
		worker.setAnualSalary();

		System.out.printf("%s was born %02d/%02d/%d and earns $%03.2f.%n", worker.getName(), worker.getBirthMonth(),
				worker.getBirthDay(), worker.getBirthYear(), worker.getAnnualSalary());

	}

	private void setAnualSalary() {
		System.out.print("Enter a sallary (ex. 15.00): ");	
		this.annualSalary=inputScanner.nextDouble();
		System.out.println();
	}

	private void setBirthYear() {
		System.out.print("Enter a year (number format): ");
		this.birthYear=inputScanner.nextInt();
		System.out.println();
	}

	private void setBirthDay() {
		System.out.print("Enter a day (number format): ");
		this.birthDay=inputScanner.nextInt();
		System.out.println();
	}

	private void setBirthMonth() {
		System.out.print("Enter a month (number format): ");
		this.birthMonth=inputScanner.nextInt();
		System.out.println();
	}

	private void setName() {
		System.out.print("Enter a name: ");
		this.name = inputScanner.nextLine();
		System.out.println();
	}

}
