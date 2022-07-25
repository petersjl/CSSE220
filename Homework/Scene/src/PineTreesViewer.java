import java.awt.Dimension;

import javax.swing.JFrame;

public class PineTreesViewer {

	public static final Dimension PINE_TREES_VIEWER_SIZE = new Dimension(500, 400);
	
	/**
	 * Constructs and displays the JFrame which displays Houses via a
	 * HousesComponent. 
	 * 
	 * @param args
	 *            Command-line arguments, ignored here.
	 */
	public static void main(String[] args) {
		JFrame frame = new JFrame();

		frame.setSize(PINE_TREES_VIEWER_SIZE);
		frame.setTitle("I see trees!");

		frame.add(new PineTreesComponent());

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}


}
