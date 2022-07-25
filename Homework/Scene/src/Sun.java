import java.awt.Color;
import java.awt.Graphics2D;

public class Sun {
	
	private static final Color BORDER_COLOR = Color.BLACK;
	private static final int NUMBER_OF_RAYS = 8;
	private static final double RAY_LENGTH_SCALE = 0.5;
	private static final double RAY_WIDTH_SCALE = 0.1;
	private static final double RAY_DISTANCE_FROM_SUN_SCALE = .2;
	private static final double DEFAULT_SUN_DIAMETER = 100.0;
	private static final double DEFAULT_SUN_X = 100.0;
	private static final double DEFAULT_SUN_Y = 100.0;
	private static final Color DEFAULT_SUN_COLOR = Color.YELLOW;
	private static final double LITTLE_SUNS_X_OFFSET = 50; 
	
	private double x;
	private double y;
	private double circleDiameter;
	private double rayLength;
	private double rayWidth;
	private double rayDistanceFromSun;
	private Color color;
	
	public Sun() {
		this.x = DEFAULT_SUN_X;
		this.y = DEFAULT_SUN_Y;
		this.circleDiameter = DEFAULT_SUN_DIAMETER;
		this.rayLength = circleDiameter * RAY_LENGTH_SCALE;
		this.rayWidth = circleDiameter * RAY_WIDTH_SCALE;
		this.rayDistanceFromSun = circleDiameter * RAY_DISTANCE_FROM_SUN_SCALE;
		this.color = DEFAULT_SUN_COLOR;	
	}
	
	public Sun(double x, double y, double dia, Color col) {
		this.x = x;
		this.y = y;
		this.circleDiameter = dia;
		this.rayLength = circleDiameter * RAY_LENGTH_SCALE;
		this.rayWidth = circleDiameter * RAY_WIDTH_SCALE;
		this.rayDistanceFromSun = circleDiameter * RAY_DISTANCE_FROM_SUN_SCALE;
		this.color = col;
	}
	
	public void drawOn(Graphics2D g2) {
		
		g2.setColor(color);
		g2.fillOval((int)x, (int)y, (int)circleDiameter, (int)circleDiameter);
		g2.setColor(BORDER_COLOR);
		g2.drawOval((int)x, (int)y, (int)circleDiameter, (int)circleDiameter);
		g2.translate(x+circleDiameter/2, y+circleDiameter/2);
		
		for(int i=0; i<NUMBER_OF_RAYS;i++) {
			drawRay(g2);
			g2.rotate(Math.toRadians(45));
		}
		g2.translate(-(x+circleDiameter/2), -(y+circleDiameter/2));
	}
	
	public void drawRay(Graphics2D g2) {
		double startx = -rayWidth/2;
		double starty = circleDiameter/2 + rayDistanceFromSun;
		double width = rayWidth;
		double height = rayLength;
		g2.setColor(color);
		g2.fillRect((int) startx, (int) starty, (int) width, (int) height);
		g2.setColor(BORDER_COLOR);
		g2.drawRect((int) startx, (int) starty, (int) width, (int) height);
	}
}
