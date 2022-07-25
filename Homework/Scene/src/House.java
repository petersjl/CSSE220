import java.awt.Color;
import java.awt.Graphics2D;

public class House {
	private static final int HEIGHT = 50;
	private static final int WIDTH = 100;
	private static final int ROOF_HEIGHT = 20;

	private Color color;
	private int xpos;
	private int ypos;

	public House(int x, int y, Color color) {
		// TODO: save off the parameters into instance variables
		this.xpos = x;
		this.ypos = y;
		this.color = color;
	}

	public void drawOn(Graphics2D g2) {
		g2.setColor(color);
		g2.fillRect(xpos, ypos, WIDTH, HEIGHT);
		g2.drawLine(xpos, ypos, xpos+(WIDTH/2), ypos-ROOF_HEIGHT);
		g2.drawLine(xpos+WIDTH, ypos, xpos+(WIDTH/2), ypos-ROOF_HEIGHT);
	}

}
