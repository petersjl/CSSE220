
public class NumberBet implements Bet{

	private int numberBetOn;
	private double amount;
	
	public NumberBet(int numberBetOn, double betAmount) {
		this.numberBetOn = numberBetOn;
		this.amount = betAmount;
	}
	
	@Override
	public boolean isWinResult(int rollResult) {
		return rollResult == this.numberBetOn;
	}
	
	@Override
	public double winAmount() {
		return this.amount*6;
	}
}
