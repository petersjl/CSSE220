import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class DataPanel extends JPanel {
	
	private final int HEIGHT = 60;
	private final int WIDTH = 810;
	private final Color BACKGROUND_COLOR = Color.PINK;
	
	public DataPanel() {
		this.setSize(WIDTH, HEIGHT);
		this.setPreferredSize(new Dimension(WIDTH,HEIGHT));
		this.setMaximumSize(new Dimension(WIDTH,HEIGHT));
		
		this.setBackground(BACKGROUND_COLOR);

	}

}
