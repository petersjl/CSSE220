package linearLightsOut;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Runs the Linear Lights Out application.
 * 
 * @author Joe Peters.
 */
public class LinearMain {
	
	public ArrayList<JButton> buttons;
	
	public LinearMain(int nButtons) {
		this.buttons = new ArrayList<JButton>();
		for(int i = 0;i<nButtons;i++) {
			JButton b = new JButton("");
			buttons.add(b);
		}
		randomize();
		while(checkWin()) {
			randomize();
		}
	}
	
	public void randomize() {
		Random r = new Random();
		for(int i = 0;i<this.buttons.size();i++) {
			if(r.nextBoolean()) {
				this.buttons.get(i).setText("O");
			}
			else {
				this.buttons.get(i).setText("X");
			}
		}
	}
	
	public boolean checkWin() {
		boolean win = true;
		for(int i = 0; i < this.buttons.size()-1; i++) {
			if(!this.buttons.get(i).getText().equals(this.buttons.get(i+1).getText())) {
				win = false;
			}
		}
		return win;
	}

	/**
	 * Starts here.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		String nButtonsString = JOptionPane
				.showInputDialog("How many buttons would you like?");
		int nButtons = Integer.parseInt(nButtonsString);
		
		while(nButtons<3) {
			nButtonsString = JOptionPane
					.showInputDialog("ERROR: You must have at least three buttons.\n\n How many buttons would you like?");
			nButtons = Integer.parseInt(nButtonsString);
		}
		
		
		LinearMain game = new LinearMain(nButtons);
		JFrame myFrame = new JFrame();
		JPanel panel = new JPanel();
		
		for(int i = 0; i<game.buttons.size(); i++) {
			JButton b = game.buttons.get(i);
			b.addActionListener(new linearListener(i,game,myFrame));
			panel.add(b);
		}
		
		
		JPanel setPanel = new JPanel();
		JButton newGame = new JButton("New Game");
		newGame.addActionListener(new ResetListener(myFrame, game));
		JButton quit = new JButton("Quit");
		quit.addActionListener(new QuitListener(myFrame));
		setPanel.add(newGame);
		setPanel.add(quit);
		myFrame.add(panel, BorderLayout.NORTH);
		myFrame.add(setPanel, BorderLayout.SOUTH);
		
		myFrame.setTitle("Linear Lights Out!");
		myFrame.pack();
		if(myFrame.getSize().getWidth()<350) {
			myFrame.setSize(350, (int)myFrame.getSize().getHeight());
		}
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.setVisible(true);
	}
}
