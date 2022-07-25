
public class HighBet implements Bet {
	
	private double amount;
	
	public HighBet(double betAmount) {
		this.amount = betAmount;
	}

	@Override
	public boolean isWinResult(int rollResult) {
		if(rollResult == 5 || rollResult == 6) {
			return true;
		}
		return false;
	}
	
	@Override
	public double winAmount() {
		return amount * 3;
	}

}
