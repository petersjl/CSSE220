import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;

public class SceneComponent extends JComponent {
	/**
	 * Draws Suns.
	 */
	@Override
	protected void paintComponent(Graphics g) {
	     super.paintComponent(g);
	     Graphics2D g2 = (Graphics2D)g;
	     
	     g2.setColor(Color.blue);
	     g2.fillRect(0, 0, 750, 375);
	     g2.setColor(Color.green);
	     g2.fillRect(0, 375, 750, 600-375);
	     Sun s = new Sun();
	     s.drawOn(g2);
	     for(int t = 0; t < 25;t++) {
	    	 PineTree tree = new PineTree(220+20*t,340,10,40);
	    	 tree.drawOn(g2);
	     }
	     for(int t2 = 0; t2<15;t2++) {
	    	 PineTree tree = new PineTree(210+35*t2,350,20,80);
	    	 tree.drawOn(g2);
	     }
	     for(int h = 0; h<5;h++) {
	    	 House house = new House(70+120*h,470,Color.red);
	    	 house.drawOn(g2);
	     }
	}
	
}
