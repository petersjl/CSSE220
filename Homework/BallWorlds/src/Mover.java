import java.awt.Color;

import java.awt.geom.Point2D;

import util.Random;

/**
 * 
 * @author petersjl
 *
 *
 * This class creates balls that start at the center of the world and then move with a random constant velocity towards 
 * and off the screen.
 */
public class Mover extends Ball {
	
	private Color color;
	private Point2D velocity;
	private double size;
	
	public Mover(BallEnvironment world) {
		super(world, new Point2D.Double(world.getSize().getWidth()/2,world.getSize().getHeight()/2));
		this.velocity = new Point2D.Double(Random.randInterval(-2, 2), Random.randInterval(-2, 2));
		this.color = Color.green;
		this.size = 20;
	}

	@Override
	public Color getColor() {
		return color;
	}

	@Override
	public void updatePosition() {
		double x = this.getCenterPoint().getX()+velocity.getX();
		double y = this.getCenterPoint().getY()+velocity.getY();
		this.setCenterPoint(new Point2D.Double(x,y));

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
		// TODO Auto-generated method stub
		return size;
	}

}
