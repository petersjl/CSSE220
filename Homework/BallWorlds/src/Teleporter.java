import java.awt.Color;
import java.awt.geom.Point2D;

import util.Random;

/**
 * 
 * @author petersjl
 *
 * This class creates teleporter balls that randomly jump around the ball world that they exist in, while spawning in the center of the world.
 */
public class Teleporter extends Ball {
	
	private int frequency;
	private int totp;
	private Color color;
	private double size;

	public Teleporter(BallEnvironment world) {
		super(world, new Point2D.Double(world.getSize().getWidth()/2,world.getSize().getHeight()/2));
		this.color = Color.PINK;
		this.size = 30; 
		this.frequency = Random.randRange(50, 200);
	}

	@Override
	public Color getColor() {
		return color;
	}

	@Override
	public void updatePosition() {
		if(frequency == totp) {
			this.setCenterPoint(new Point2D.Double(Random.randInterval(0, this.getWorld().getSize().getWidth()),Random.randInterval(0, this.getWorld().getSize().getHeight())));
			this.frequency = Random.randRange(100, 1000);
			totp = 0;
		}
		else {
			totp++;
		}

	}

	@Override
	public void updateSize() {
		// doesn't change size

	}

	@Override
	public void updateColor() {
		// doesn't change color

	}

	@Override
	public double getDiameter() {
		return size;
	}

}
