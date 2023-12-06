import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;
import javax.swing.Icon;
import javax.swing.ImageIcon;


//GAME OBJECT OF TYPE D REQUIRES A KEY LISTENER
public class Type_D_GameObject extends GameObject implements KeyListener {
	
	private int counter;
	
  public Type_D_GameObject(int x, int y) {
    super(x, y);
    setDirection(Direction.NONE);
    
    imageList = new LinkedList<Icon>();
    imageList.add(new ImageIcon("images/Type_D_Up.png"));
    imageList.add(new ImageIcon("images/Type_D_Down.png"));
    imageList.add(new ImageIcon("images/Type_D_Left.png"));
    imageList.add(new ImageIcon("images/Type_D_Right.png"));
    counter = 0;
    
  }

  public void move(Canvas c) {
    Icon icon = getCurrentImage();

    int  iconHeight   = icon.getIconHeight();
    int  iconWidth    = icon.getIconWidth();
    int  canvasHeight = (int)c.getSize().getHeight();
    int  canvasWidth  = (int)c.getSize().getWidth();
    
    if (!isHighlighted() && counter == 0) {
    	setDirection((int)(Math.random() * 4) + 1);
    }
    
    counter++;
	if (counter > 20) {
		counter = 0;
	}
    
    //MOVE BLUE GAME OBJECT
    switch (getDirection()) {
      case Direction.UP:
        setY(getY() - getVelocity());
        if (getY() < 0) {
          setY(0);
          if (!isHighlighted()) {
          	setDirection(Direction.DOWN);
          }
        }
        break;
      case Direction.DOWN:
        setY(getY() + getVelocity());
        if (getY() + iconHeight > canvasHeight) {
          setY((int)(canvasHeight - iconHeight));
          if (!isHighlighted()) {
          	setDirection(Direction.UP);
          }
        }
        break;
      case Direction.LEFT:
        setX(getX() + getVelocity());
        if (getX() + iconWidth > canvasWidth) {
          setX((int)(canvasWidth - iconWidth));
          if (!isHighlighted()) {
          	setDirection(Direction.RIGHT);
          }
        }
        break;
      case Direction.RIGHT:
        setX(getX() - getVelocity());
        if (getX() < 0) {
          setX(0);
          if (!isHighlighted()) {
          	setDirection(Direction.LEFT);
          }
        }
        break;
	default:
		break;
    }

  }

  //SPECIFY THE IMAGE TO DISPLAY
  //   USED FOR ANIMATION
  public void setImage() {
	    switch (getDirection()) {
	      case Direction.NONE:
	        break;
	      case Direction.UP:
	        currentImage = 0;
	        break;
	      case Direction.DOWN:
	        currentImage = 1;
	        break;
	      case Direction.LEFT:
	        currentImage = 2;
	        break;
	      case Direction.RIGHT:
	        currentImage = 3;
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
		  if (e.getKeyCode() == KeyEvent.VK_UP) {
		      setDirection(Direction.UP);
		  }
		  if (e.getKeyCode() == KeyEvent.VK_DOWN) {
		      setDirection(Direction.DOWN);
		  }
		  if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
		      setDirection(Direction.LEFT);
		  }
		  if (e.getKeyCode() == KeyEvent.VK_LEFT) {
		      setDirection(Direction.RIGHT);
		  }
	  }
	
    
  }

}
