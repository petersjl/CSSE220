package ballStrikeCounter;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Tracker {
	private JLabel label = new JLabel();
	public int balls;
	public int strikes;

	// Call this to update the text on the label.
	public void updateLabel(int numBalls, int numStrikes) {
		this.label.setText("<html>Balls: " + numBalls + "<br />Strikes: " + numStrikes + "</HTML>");
	}
	

	public static void main(String[] args) {
		new Tracker();
	}

	public Tracker() {
		balls = 0;
		strikes = 0;
		
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();

		frame.add(label, BorderLayout.CENTER);
		frame.add(panel, BorderLayout.SOUTH);
		
		// TODO: Add buttons and listeners to make things work.
		
		JButton ball = new JButton("Add Ball");
		JButton strike = new JButton("Add Strike");
		
		ball.addActionListener(new BallListener(balls,strikes,this));
		strike.addActionListener(new StrikeListener(balls,strikes,this));
		
		panel.add(ball);
		panel.add(strike);
		

		// The following line is given to show you how to use the given method:
		updateLabel(0, 0);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}
