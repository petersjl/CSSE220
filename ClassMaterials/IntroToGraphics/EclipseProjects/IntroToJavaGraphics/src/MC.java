import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JComponent;

@SuppressWarnings("serial")
public class MC extends JComponent{

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		for(int i = 1;i<= (this.getWidth()-50) /10;i++) {
			Rectangle box = new Rectangle(10, 10, 10*i, 10*i);
			g2.draw(box);
		}
	}

}
