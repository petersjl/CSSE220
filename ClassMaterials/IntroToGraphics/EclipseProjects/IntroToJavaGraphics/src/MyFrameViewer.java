import javax.swing.JFrame;


public class MyFrameViewer {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(500,600);
		frame.setTitle("I'm a box");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		MC comp = new MC();
		frame.add(comp);
		
		frame.setVisible(true);
	}

}
