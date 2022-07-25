package ballStrikeCounter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BallListener implements ActionListener {
	
	private Tracker track;
	
	public BallListener(int balls, int strikes, Tracker track) {
		this.track = track;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(track.balls == 3) {
			track.balls = 0;
			track.strikes = 0;
		}
		else {
			track.balls++;
		}
		
		track.updateLabel(track.balls,track.strikes);

	}

}
