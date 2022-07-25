import java.awt.Color;
import java.awt.geom.Point2D;

public class Hero extends Entity {
	
	
	private boolean right;
	private boolean left;

	public Hero(GameWorld world) {
		super(world, new Point2D.Double(45,30*26-2));
		this.color = Color.GREEN;
		
	}

	@Override
	public void timePassed() {
		this.checkGround();
		if(!this.isOnGround) {
			if(this.velocity.getY() < 16) {
				this.velocity.setLocation(this.velocity.getX(), this.velocity.getY()+2);
			}
		}
		if(this.right) {
			this.velocity.setLocation(5, this.velocity.getY());
		}
		else if(this.left) {
			this.velocity.setLocation(-5, this.velocity.getY());
		}
		else {
			this.velocity.setLocation(0, this.velocity.getY());
		}
		updatePosition();
		
	}

	@Override
	public void updatePosition() {
		double x = this.getCenterPoint().getX()+this.velocity.getX();
		double y = this.getCenterPoint().getY()+this.velocity.getY();
		this.setCenterPoint(new Point2D.Double(x, y));
	}

	public void moveRight() {
		this.right = true;
		
	}

	public void stop() {
		this.right = false;
		this.left = false;
		
	}

	public void moveLeft() {
		this.left = true;
		
	}
	

}
