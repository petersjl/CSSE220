import java.awt.Color;

import java.awt.geom.Point2D;

import util.Random;


/**
 * 
 * @author petersjl
 * 
 * This class creates balls at random locations and sizes that pulse from black to white over a set interval;
 */
public class Pulsar extends Ball {
	
	private Color color;
	private int colorval;
	private boolean toBlack;
	private double size;
	
	public Pulsar(BallEnvironment world) {
		super(world, new Point2D.Double(Random.randRange(0,(int) world.getSize().getWidth()),Random.randRange(0,(int) world.getSize().getHeight())));
		this.toBlack = false;
		this.colorval = 0;
		color = new Color(colorval, colorval, colorval);
		this.size = Random.randInterval(10, 50);
		
	}

	@Override
	public Color getColor() {
		return color;
	}

	@Override
	public void updatePosition() {
		// doesn't move

	}

	@Override
	public void updateSize() {
		// doesn't change size

	}

	@Override
	public void updateColor() {
		if(!toBlack) {
			colorval+=5;
			if(colorval>255) {
				toBlack=!toBlack;
				colorval-=10;
			}
			this.color = new Color(colorval, colorval, colorval);
		}
		else {
			colorval -= 5;
			if(colorval<0) {
				toBlack=!toBlack;
				colorval+=10;
			}
			this.color = new Color(colorval, colorval, colorval);
		}

	}

	@Override
	public double getDiameter() {
		return size;
	}

}
