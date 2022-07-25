package addlettersProblem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AddLettersListener implements ActionListener {
	
	JLabel l;
	JButton b;
	
	public AddLettersListener(JLabel l, JButton b) {
		this.l = l;
		this.b = b;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		l.setText(l.getText() + b.getText().charAt(b.getText().length()-1));
	}

}
