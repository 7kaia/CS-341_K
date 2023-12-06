import java.awt.event.KeyListener;
import java.util.LinkedList;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Type_B_GameObject {

	private int x;
	private int y;
	private LinkedList<Icon> imageList;
	
	public Type_B_GameObject(int x, int y) {
		this.x = x;
		this.y = y;
		
	    imageList = new LinkedList<Icon>();
	    imageList.add(new ImageIcon("images/Type_B__Up.png"));
	    imageList.add(new ImageIcon("images/Type_B_Down.png"));
	    imageList.add(new ImageIcon("images/Type_B_Left.png"));
	    imageList.add(new ImageIcon("images/Type_B_Right.png"));
		
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public LinkedList<Icon> getImageList() {
		return imageList;
	}

}
