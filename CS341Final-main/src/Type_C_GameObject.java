import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Type_C_GameObject extends GameObject implements KeyListener {

	public Type_C_GameObject(int x, int y) {
		super(x, y);
		setDirection(Direction.NONE);
		
		imageList = new LinkedList<Icon>();
	    imageList.add(new ImageIcon("images/Type_C_Left.png")); //the left image is actually right, and vice versa
	    imageList.add(new ImageIcon("images/Type_C_Right.png"));

	}
	
	
	
	public void setImage() {
		
		switch(getDirection()) {
			case Direction.RIGHT:
				currentImage = 0;
				break;
			case Direction.LEFT:
				currentImage = 1;
		
		}
	}



	public void move(Canvas c) {
		
		Icon icon = getCurrentImage();
		
		int iconHeight = icon.getIconHeight();
	    int canvasWidth = (int)c.getSize().getWidth();
	    int x = getX();
	    int velocity = getVelocity();
	    
	    if (!isHighlighted() && getDirection() == Direction.NONE) {
	    	if (currentImage == 0) {
	    		setDirection(Direction.RIGHT);
	    	} else {
	    		setDirection(Direction.LEFT);
	    	}
	    }
	    
    	switch(getDirection()) {
	    	case Direction.LEFT:
	            if (x - velocity < 0) {
	            	setX(0);
	            	if (!isHighlighted()) {
		            	setDirection(Direction.RIGHT);
		            }
	            } else {
	            	setX(x - velocity);
	            }
	            break;
	        case Direction.RIGHT:
	            if (x + iconHeight + velocity> canvasWidth) {
	              setX(canvasWidth - iconHeight);
	              if (!isHighlighted()) {
		            	setDirection(Direction.LEFT);
		          }
	            } else {
	            	setX(x + velocity);
	            }
	            break;
	        default:
    	}
	}
	
	
	public void keyTyped(KeyEvent e) {
	}

	public void keyReleased(KeyEvent e) {
		if (isHighlighted()) {
		    if (e.getKeyCode() != KeyEvent.VK_TAB) {
		    	setDirection(Direction.NONE);
		    }
		}
	}

	  public void keyPressed(KeyEvent e) {
		  
		  if (isHighlighted()) {
			  switch(e.getKeyCode()) {
					case KeyEvent.VK_LEFT:
						setDirection(Direction.LEFT);
						break;
					case KeyEvent.VK_RIGHT:
						setDirection(Direction.RIGHT);
						break;
					default:
			
			  }
		  }
		 
	 }
}
