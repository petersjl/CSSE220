import java.awt.Color;
import java.awt.Graphics2D;

public class PineTree {
	
	private int xpos;
	private int ypos;
	private int width;
	private int height;
	private Color brown = new Color(145,112,33);
	private Color green = new Color(40,135,22);
	
	public PineTree(int x, int y, int w, int h) {
		this.xpos = x;
		this.ypos = y;
		this.width = w;
		this.height = h;
	}
	
	public void drawOn(Graphics2D g2) {
		g2.setColor(brown);
		g2.fillRect(xpos+width*1/3, ypos+height*2/3, width*1/3, height*1/3);
		int[] trix = {xpos,xpos+(width/2),xpos+width};
		int[] triy = {ypos+(height*2/3),ypos,ypos+(height*2/3)};
		g2.setColor(green);
		g2.fillPolygon(trix, triy, 3);
	}
}
