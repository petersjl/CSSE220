import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class BubbleFrame extends JFrame {
	
	private int levelNumber;
	private GamePanel game;
	
	public BubbleFrame() {
		
		this.levelNumber = 1;
		
		JPanel data = new DataPanel();
		this.game = new GamePanel();
		
		add(data, BorderLayout.NORTH);
		add(game, BorderLayout.CENTER);
		
		setSize(825, 1007);
		setLocationRelativeTo(null);
		setResizable(true);
		addKeyListener(new gameListener(game));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		System.out.println(data.getSize()+""+game.getSize());
		setVisible(true);
		System.out.println(this.getSize());
		
	}
	
	public class gameListener implements KeyListener{
		
		private GamePanel game;
		
		public gameListener(GamePanel game) {
			this.game = game;
		}
		
		@Override
		public void keyPressed(KeyEvent e) {
			switch(e.getKeyCode()) {
			
			case 39 :
				this.game.moveRight();
				break;
			
			case 37 :
				this.game.moveLeft();
				break;
			case 32 :
				this.game.jump();
				break;
				
			default : break;
			}
			
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			switch(e.getKeyCode()) {
			
			case 39 :
				this.game.stop();
				break;
			
			case 37 :
				this.game.stop();
				break;
			}
			
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			switch(arg0.getKeyChar()) {
				
			case 'u' :	
				if(levelNumber == 5) {createErrorMessage(1);break;}
				else {
					levelNumber++;
//					game.createLevel(levelNumber);
					break;
				}
			case 'd' :	
				if(levelNumber == 1) {createErrorMessage(0);break;}
				else {
					levelNumber--;
//					game.createLevel(levelNumber);
					break;
				}
			case 'U' :
				if(levelNumber == 5) {createErrorMessage(1);break;}
				else {
					levelNumber++;
//					game.createLevel(levelNumber);
					break;
				}
			case 'D' :
				if(levelNumber == 1) {createErrorMessage(0);break;}
				else {
					levelNumber--;
//					game.createLevel(levelNumber);
					break;
				}
			}
			
		}
		
	}
	
	private void createErrorMessage(int i) {
		//TODO
	}

}
