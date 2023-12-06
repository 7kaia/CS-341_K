
public class D_B_Adapter extends Type_D_GameObject {
	
	private Type_B_GameObject sprite;
	public D_B_Adapter(Type_B_GameObject spr) {
		
		super(spr.getX(), spr.getY());
		this.sprite = spr;
		
	    this.imageList = sprite.getImageList();
		
	}
	
	
}
