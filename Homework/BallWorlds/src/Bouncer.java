import java.awt.Color;

/**
 * 
 * @author petersjl
 *
 * This class creates balls that spawn at the origin and move with a random constant velocity towards the edges of their Ball World
 * and then bounce back.
 */

public class Bouncer extends AbstractBouncer {
	
	public Bouncer(BallEnvironment world) {
		super(world);
		this.color = Color.magenta;
	}

	@Override
	public void updateSize() {
		// size doesn't change
	}

	@Override
	public void updateColor() {
		// color doesn't change

	}

}
