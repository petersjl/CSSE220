import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class GamePanel extends JPanel {
	
	private final int HEIGHT = 900;
	private final int WIDTH = 810;
	private final Color BACKGROUND_COLOR = Color.LIGHT_GRAY;
	
	private GameWorld world;
	
	public GamePanel() {
		setSize(WIDTH, HEIGHT);
		this.setPreferredSize(new Dimension(WIDTH,HEIGHT));
		this.setMaximumSize(new Dimension(WIDTH,HEIGHT));
		setBackground(BACKGROUND_COLOR);
		setLocation(0,60);
		this.world = new GameWorld();
		GameComponent component = new GameComponent(world);
		add(component);
	}
	
	public void createLevel(int levelNumber) {
		world.createLevel(levelNumber);
	}
	
	public void moveRight() {
		world.heroMoveRight();
	}
	
	public void moveLeft() {
		world.heroMoveLeft();
	}
	
	public void stop() {
		world.heroStop();
	}

	public void jump() {
		world.heroJump();
		
	}
	
}
