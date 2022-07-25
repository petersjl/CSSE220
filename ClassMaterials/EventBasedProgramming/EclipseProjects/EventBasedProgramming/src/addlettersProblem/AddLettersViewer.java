package addlettersProblem;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AddLettersViewer {

	public static void main(String[] args) {
		new AddLettersViewer();
	}
	
	public AddLettersViewer() {	
		JFrame frame = new JFrame();
		JLabel lab = new JLabel("> ");
		JPanel panel = new JPanel();
		JButton A = new JButton("Add A");
		JButton B = new JButton("Add B");
		JButton C = new JButton("Add C");
		A.addActionListener(new AddLettersListener(lab,A));
		B.addActionListener(new AddLettersListener(lab,B));
		C.addActionListener(new AddLettersListener(lab,C));
		panel.add(A);
		panel.add(B);
		panel.add(C);
		frame.add(lab, BorderLayout.NORTH);
		frame.add(panel, BorderLayout.SOUTH);

		// put your new JButtons, JLabels, etc here
		
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
