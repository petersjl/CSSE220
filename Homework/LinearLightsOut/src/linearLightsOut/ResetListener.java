package linearLightsOut;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ResetListener implements ActionListener {
	
	private JFrame frame;
	private LinearMain game;
	
	public ResetListener(JFrame frame, LinearMain game) {
		this.game = game;
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		game.randomize();
		frame.setTitle("Linear Lights Out!");
		while(game.checkWin()) {
			game.randomize();
		}
		for(JButton b: game.buttons) {
			b.setEnabled(true);
		}

	}
	
}
