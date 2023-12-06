import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.Timer;

public class Canvas extends JComponent implements ActionListener, KeyListener {
	// DEFAULT SERIAL NUMBER
	private static final long serialVersionUID = 1L;

	//GAME LOOP USES A FRAME AND TIMER
	private JFrame frame;
	private Timer gameLoopTimer;
	
	private List<GameObject> gameObjectList;
	private int highlighted = 0;
	


	public Canvas() {
		// TASK 1: CREATE A LIST OF CHARACTERS THAT WILL APPEAR ON THE CANVAS
		gameObjectList = new LinkedList<GameObject>();

		// TASK 2: CREATE A WINDOW FOR THE APPLICATION
		frame = new JFrame("Animation Canvas");
		frame.setSize(800, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(this);
		
		Canvas c = this;

		// TASK 3: CONSTRUCT A TIMER FOR GAME LOOP
		gameLoopTimer = new Timer(10, this);
		gameLoopTimer.start();
		
		
		setFocusTraversalKeysEnabled(false);
	    addKeyListener(this);

		// TASK 4: MAKE THE WINDOW VISIBLE
		frame.setVisible(true);
		
	}
	
	/**
	 * Adds GameObjects to the List, which are latter added to the Canvas
	 */
	public synchronized void addGameObject(GameObject sprite) {
		gameObjectList.add(sprite);
	}

	/**
	 * Draws the GameObject graphic onto the Canvas
	 */
	public synchronized void paint(Graphics g) {
		for (GameObject s : gameObjectList) {
			s.draw(this, g);
		}
		
		drawRectangleOnHighlighted(g);
	}
	
	
	// ****************************************************
	// Canvas must implement the inherited abstract method
	// ActionListener.actionPerformed(ActionEvent)
	public synchronized void actionPerformed(ActionEvent e) {
		for (GameObject gameObject : gameObjectList) {
			gameObject.move(this);
			gameObject.setImage();
		}
		
		repaint();
	}
	
	private void drawRectangleOnHighlighted(Graphics g) {
		if (gameObjectList != null && gameObjectList.size() > highlighted) {
			g.setColor(Color.RED);
			GameObject s = gameObjectList.get(highlighted);
			for (int i = 0; i < 5; i++) {
				g.drawRect(s.getX() + i, s.getY() + i, s.getCurrentImage().getIconWidth() - (2 * i), s.getCurrentImage().getIconHeight() - (2 * i));
			}
		}	

	}


	
	
	// ****************************************************
	// Canvas must implement the inherited abstract methods
	// for KeyListener
	
	  public void keyTyped(KeyEvent e) {
	  }

	  public void keyPressed(KeyEvent e) {
	  }

	  public void keyReleased(KeyEvent e) {
		  
		  if (e.getKeyCode() == KeyEvent.VK_TAB) {
			  GameObject previous = gameObjectList.get(highlighted);
			  previous.setHighlight(false);

			  highlighted = highlighted + 1;
		      if (highlighted == gameObjectList.size()) {
		    	  highlighted = 0;
		      }
		  }
		  
		  GameObject s = gameObjectList.get(highlighted);
		  s.setHighlight(true);
		  s.setDirection(Direction.NONE);
		  s.setVelocity(s.getVelocity()+1);
 
	 }

}
