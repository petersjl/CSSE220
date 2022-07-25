package linearLightsOut;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;

public class linearListener implements ActionListener {
	
	private int id;
	private LinearMain game;
	private JFrame frame;
	
	public linearListener(int id, LinearMain game, JFrame frame) {
		this.id = id;
		this.game = game;
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(id == 0) {
			switchSign(game.buttons.get(id));
			switchSign(game.buttons.get(id+1));
			checkWin();
		}
		else if(id == game.buttons.size()-1) {
			switchSign(game.buttons.get(id-1));
			switchSign(game.buttons.get(id));
			checkWin();
		}
		else {
			switchSign(game.buttons.get(id-1));
			switchSign(game.buttons.get(id));
			switchSign(game.buttons.get(id+1));
			checkWin();
		}
		

	}
	
	private void switchSign(JButton b) {
		if(b.getText()=="O") {
			b.setText("X");
		}
		else {
			b.setText("O");
		}
	}
	
	private void checkWin() {
		if(game.checkWin()) {
			frame.setTitle("You Won!");
			for(JButton b: game.buttons) {
				b.setEnabled(false);
			}
		}	
		
	}

}
