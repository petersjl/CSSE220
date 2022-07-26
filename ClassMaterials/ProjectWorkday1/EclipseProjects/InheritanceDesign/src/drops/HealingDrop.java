package drops;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import game.GameComponent;
import game.GameObject;


/**
 *  This class represents a red drop that when
 *  hitting a bouncing platform should remove a raindrop from it
 * 
 */
public class HealingDrop extends GameObject {

	private static final double SIZE = 10.0;
	private static final Color COLOR = Color.RED;
	
	public HealingDrop( GameComponent component, int range) {
		super(component, Math.random()*range, 0, 0, 1, SIZE, SIZE);
	}
	
	public void drawOn(Graphics2D g) {
		g.setColor(COLOR);
		Ellipse2D.Double drop = 
				new Ellipse2D.Double(this.getBoundingBox().x, this.getBoundingBox().y, this.getBoundingBox().getWidth(), this.getBoundingBox().getHeight() );
		g.fill(drop);
		g.setColor(Color.BLACK);
	}
	
	@Override
	public void update() {
		super.update();
		if (offBottom() ) {
			markToRemove();
		}
	}

	@Override
	public void onRemove() {
		// Do nothing special.
	}
	

}
