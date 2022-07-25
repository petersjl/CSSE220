import java.awt.Color;

import java.awt.geom.Point2D;

import util.Random;

/**
 * 
 * @author petersjl
 *
 * This is an abstract class to control the behavior of balls that bounce off of the walls of the Ball World
 * that they live within.
 */

public abstract class AbstractBouncer extends Ball {
	
	protected Color color;
	protected double size;
	private Point2D velocity;

	public AbstractBouncer(BallEnvironment world) {
		super(world, new Point2D.Double(world.getSize().getWidth()/2,world.getSize().getHeight()/2));
		this.velocity = new Point2D.Double(Random.randInterval(-2, 2), Random.randInterval(-2, 2));
		this.size = 30;
	}
	
	public AbstractBouncer(BallEnvironment world, Point2D center) {
		super(world,center);
		this.velocity = new Point2D.Double(Random.randInterval(-2, 2), Random.randInterval(-2, 2));
		this.size = 30;
	}

	@Override
	public Color getColor() {
		return color;
	}

	@Override
	public void updatePosition() {
		double x = this.getCenterPoint().getX()+velocity.getX();
		double y = this.getCenterPoint().getY()+velocity.getY();
		
		if(x > this.getWorld().getSize().getWidth() || x < 0) {
			velocity.setLocation(-velocity.getX(), velocity.getY());
			x+= 2*velocity.getX();
		}
		if(y > this.getWorld().getSize().getHeight() || y < 0) {
			velocity.setLocation(velocity.getX(), -velocity.getY());
			y+=2*velocity.getY();
		}
		this.setCenterPoint(new Point2D.Double(x,y));

	}
	
	@Override
	public double getDiameter() {
		return size;
	}


}
