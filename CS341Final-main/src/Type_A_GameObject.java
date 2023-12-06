import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Type_A_GameObject extends GameObject implements KeyListener {

	public Type_A_GameObject(int x, int y) {
		super(x, y);
		setDirection(Direction.NONE);
		
		imageList = new LinkedList<Icon>();
	    imageList.add(new ImageIcon("images/Type_A_Up.png"));
	    imageList.add(new ImageIcon("images/Type_A_Down.png"));

	}

	public void move(Canvas c) {
		
		Icon icon = getCurrentImage();
		
		int iconHeight = icon.getIconHeight();
	    int canvasHeight = (int)c.getSize().getHeight();
	    int y = getY();
	    int velocity = getVelocity();
	    
	    if (!isHighlighted() && getDirection() == Direction.NONE) {
	    	if (currentImage == 0) {
	    		setDirection(Direction.UP);
	    	} else {
	    		setDirection(Direction.DOWN);
	    	}
	    }
	    
    	switch(getDirection()) {
	    	case Direction.UP:
	            setY(y - velocity);
	            if (y - velocity < 0) {
	            	setY(0);
	            	if (!isHighlighted()) {
		            	setDirection(Direction.DOWN);
		          }
	            } else {
	            	setY(y - velocity);
	            }
	            break;
	        case Direction.DOWN:
	            if (y + iconHeight + velocity> canvasHeight) {
	              setY(canvasHeight - iconHeight);
	              if (!isHighlighted()) {
		            	setDirection(Direction.UP);
		          }
	            } else {
	            	setY(y + velocity);
	            }
	            break;
	        default:
    	}

	}

	public void setImage() {
		
		switch(getDirection()) {
		case Direction.UP:
			currentImage = 0;
			break;
		case Direction.DOWN:
			currentImage = 1;
			break;
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
					case KeyEvent.VK_UP:
						setDirection(Direction.UP);
						break;
					case KeyEvent.VK_DOWN:
						setDirection(Direction.DOWN);
						break;
					default:
			
			  }
		  }
		 
	 }

}
