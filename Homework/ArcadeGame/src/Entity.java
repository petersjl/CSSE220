import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Point2D;

public abstract class Entity implements Drawable, Temporal {
	
	protected Point2D velocity;
	private GameWorld world;
	private Point2D centerPoint;
	protected boolean isOnGround;
	protected Color color;
	protected Shape shape;
	
	public Entity(GameWorld world, Point2D center) {
		this.world = world;
		this.centerPoint = center;
		this.velocity = new Point2D.Double(0, 5);
	}
	
	public void jump() {
		if(this.isOnGround) {
			this.velocity = new Point2D.Double(this.velocity.getX(),-28);
		}
	}

	@Override
	public abstract void timePassed();

	@Override
	public void die() {
		world.removeEntity(this);

	}

	@Override
	public void setIsPaused(boolean isPaused) {
		// null

	}

	@Override
	public boolean getIsPaused() {
		// null
		return false;
	}

	@Override
	public Color getColor() {
		return this.color;
	}

	@Override
	public Shape getShape() {
		double x = getCenterPoint().getX();
		double y = getCenterPoint().getY();
		return new Rectangle((int)x - 15, (int)y - 15, 30, 30);
	}
	
	public Point2D getCenterPoint() {
		return this.centerPoint;
	}
	
	public void setCenterPoint(Point2D center) {
		this.centerPoint = center;
	}
	
	protected GameWorld getWorld() {
		return this.world;
	}
	
	public void checkGround() {
		
		int xl = (int)this.getCenterPoint().getX()-15;
		int xr = (int)this.getCenterPoint().getX()+15;
		int y = (int)this.getCenterPoint().getY()+15;
		
		if(isOnGround) {
			this.isOnGround = false;
			for(Point2D p : world.ground) {
				int px = (int)p.getX()*30;
				int py = (int)p.getY()*30;
				if((xl > px-1 && xl < px+31) || (xr-1 > px && xr < px+31)) {
					if(y > py && y < py+30) {
						this.isOnGround = true;
						break;
					}
				}
			}
			
		}
		else {
			for(Point2D p : world.ground) {
				int px = (int)p.getX()*30;
				int py = (int)p.getY()*30;
				if((xl > px-1 && xl < px+31) || (xr > px-1 && xr < px+31)) {
					if(y > py && y < py+30) {
						this.setCenterPoint(new Point2D.Double(this.getCenterPoint().getX(), py-15));
						this.velocity = new Point2D.Double(this.velocity.getX(), 0);
						this.isOnGround = true;
					}
				}
			}
		}
	}
	
	public void checkWall() {
		int xl = (int)this.getCenterPoint().getX()-15;
		int xr = (int)this.getCenterPoint().getX()+15;
		if(xl < 30) {
			this.setCenterPoint(new Point2D.Double(45, this.getCenterPoint().getY()));
		}
		if(xr > 30*26) {
			this.setCenterPoint(new Point2D.Double(30*26-15, this.getCenterPoint().getY()));
		}
	}
	
	public abstract void updatePosition();
	

}
