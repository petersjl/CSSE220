import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.Timer;

public class GameComponent extends JComponent {
	
	private static final int FRAMES_PER_SECOND = 30;
	private static final int REPAINT_INTERVAL_MS = 1000 / FRAMES_PER_SECOND;

	private GameWorld world;
	
	public GameComponent(GameWorld world) {
		
		this.world = world;
		
		setPreferredSize(world.getSize());
		setMaximumSize(world.getSize());
		
		Timer repaintTimer = new Timer(REPAINT_INTERVAL_MS, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				repaint();
			}
			
		});
		repaintTimer.start();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;

		drawWorld(g2, this.world.getMap());

		List<Drawable> drawableParts = this.world.getDrawableParts();
		for (Drawable d : drawableParts) {
			drawDrawable(g2, d);
		}
	}
	
	private void drawDrawable(Graphics2D g, Drawable d) {
		Color color = d.getColor();
		g.setColor(color);
		g.fill(d.getShape());
	}
	
	private void drawWorld(Graphics2D g, ArrayList<ArrayList<Integer>> map) {
		
		g.setColor(Color.BLACK);
		
		for(int r = 0; r < map.size(); r++) {
			for(int c = 0; c < map.get(0).size(); c++) {
				if(map.get(r).get(c) != 0) {
					Rectangle rect = new Rectangle(c*30, r*30, 30, 30);
					g.fill(rect);
				}
			}
		}
	}

}
