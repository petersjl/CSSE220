import java.awt.Color;
import java.awt.geom.Point2D;

import util.Random;

/**
 * 
 * @author petersjl
 * 
 * This class creates balls that act like those in the bouncer class, but grow to a set multiple of their starting size
 * and then delete themselves and spawn in two new exploders.
 */
public class Exploder extends AbstractBouncer {
	
	private double maxSize;
	
	public Exploder(BallEnvironment world) {
		super(world);
		this.color = Color.orange;
		this.maxSize = this.size*Random.randRange(2, 10);
	}

	public Exploder(BallEnvironment world, Point2D centerPoint) {
		super(world, centerPoint);
		this.color = Color.orange;
		this.maxSize = this.size*Random.randRange(2, 10);
	}

	@Override
	public void updateSize() {
		this.size *= 1.01;
		if(size>maxSize) {
			this.getWorld().addBall(new Exploder(this.getWorld(),this.getCenterPoint()));
			this.getWorld().addBall(new Exploder(this.getWorld(),this.getCenterPoint()));
			die();
		}

	}

	@Override
	public void updateColor() {
		// doesn't change color

	}

}
