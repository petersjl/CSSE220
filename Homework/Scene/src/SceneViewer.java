import java.awt.Dimension;

import javax.swing.JFrame;

public class SceneViewer {

	public static final Dimension SCENE_VIEWER_SIZE = new Dimension(750, 600);

	/**
	 * Constructs and displays the JFrame which displays the Scene via a
	 * SceneComponent. 
	 * 
	 * @param args
	 *            Command-line arguments, ignored here.
	 */
	public static void main(String[] args) {
		JFrame frame = new JFrame();

		frame.setSize(SCENE_VIEWER_SIZE);
		frame.setTitle("Look at that scene!");

		frame.add(new SceneComponent());

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}

}
