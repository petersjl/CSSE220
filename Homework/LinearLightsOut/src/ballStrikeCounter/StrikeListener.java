package ballStrikeCounter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StrikeListener implements ActionListener {

	private Tracker track;
	
	public StrikeListener(int balls, int strikes, Tracker track) {
		this.track = track;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(track.strikes == 2) {
			track.balls = 0;
			track.strikes = 0;
		}
		else {
			track.strikes++;
		}
		track.updateLabel(track.balls,track.strikes);

	}

}
