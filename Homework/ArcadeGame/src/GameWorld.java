import java.awt.Color;
import java.awt.Dimension;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Timer;

public class GameWorld implements Drawable, Temporal {
	
	private static final int UPDATE_INTERVAL_MS = 10;
	private final int HEIGHT = 900;
	private final int WIDTH = 810;
	private final Color BACKGROUND_COLOR = Color.LIGHT_GRAY;
	
	private LevelReader r;
	private ArrayList<ArrayList<Integer>> map;
	protected ArrayList<Point2D> ground;
	private Hero hero;
	
	private List<Entity> entities = new ArrayList<Entity>();
	private final List<Entity> entitiesToAdd = new ArrayList<Entity>();
	private final List<Entity> entitiesToRemove = new ArrayList<Entity>();
	
	private boolean isPaused = false;
	
	public GameWorld(){
		
		this.r = new LevelReader(1);
		
//		this.entities = r.getEntities();
		this.map = r.getLevelDat();
		
		//Test Level
//		this.map = new int[][] {{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
//								{1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
//								{1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
//								{1,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
//								{1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
//								{1,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
//								{1,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
//								{1,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
//								{1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
//								{1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
//								{1,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
//								{1,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
//								{1,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
//								{1,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,1},
//								{1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,1},
//								{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,1},
//								{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,1},
//								{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,1},
//								{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1},
//								{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,1},
//								{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1},
//								{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,1},
//								{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1},
//								{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,1},
//								{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1},
//								{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1},
//								{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
//								{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
//								{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
//								{3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3}};
		
		this.ground = createGround(this.map);
		this.hero = new Hero(this);
		this.entities.add(hero);
		Timer advanceStateTimer = new Timer(UPDATE_INTERVAL_MS, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				timePassed();
			}
			
		});
		
		advanceStateTimer.start();
	}
	
	public void createLevel(int levelNumber) {
		
		this.entities.clear();
		this.entitiesToAdd.clear();
		this.entitiesToRemove.clear();
		this.ground.clear();
		
		this.r = new LevelReader(levelNumber);
		
		this.entities.add(new Hero(this));
		
//		this.entities = r.getEntities();
		this.map = r.getLevelDat();
		this.ground = createGround(this.map);
	}
	
	private ArrayList<Point2D> createGround(ArrayList<ArrayList<Integer>> map) {
		
		ArrayList<Point2D> ground = new ArrayList<Point2D>();
		for(int r = 0; r < map.size(); r++) {
			for(int c = 0; c < map.get(0).size(); c++) {
				if(map.get(r).get(c)==3) {
					ground.add(new Point2D.Double(c, r));
				}
			}
		}
		return ground;
	}
	
	public void addEntity(Entity e) {
		this.entitiesToAdd.add(e);
	}
	
	public void removeEntity(Entity e) {
		this.entitiesToRemove.add(e);
	}
	
	public synchronized List<Drawable> getDrawableParts() {
		return new ArrayList<Drawable>(this.entities);
	}
	
	public Dimension getSize() {
		return new Dimension(WIDTH, HEIGHT);
	}
	
	public ArrayList<ArrayList<Integer>> getMap(){
		return map;
	}
	
	//--------------------------------------------
	// Temporal Interface
	
	@Override
	public void timePassed() {
		if (!this.isPaused) {
			for (Temporal t : this.entities) {
				t.timePassed();
			}
		}
		this.entities.removeAll(this.entitiesToRemove);
		this.entitiesToRemove.clear();
		this.entities.addAll(this.entitiesToAdd);
		this.entitiesToAdd.clear();

	}

	@Override
	public void die() {
		// ignored

	}

	@Override
	public void setIsPaused(boolean isPaused) {
		this.isPaused = !this.isPaused;
	}

	@Override
	public boolean getIsPaused() {
		return this.isPaused;
	}
	
	//-------------------------------------------
	// Drawable Interface

	@Override
	public Color getColor() {
		// null
		return null;
	}

	@Override
	public Shape getShape() {
		// null
		return null;
	}

	public void heroMoveRight() {
		hero.moveRight();
		
	}

	public void heroStop() {
		hero.stop();
		
	}

	public void heroMoveLeft() {
		hero.moveLeft();
		
	}

	public void heroJump() {
		hero.jump();
		
	}

}
