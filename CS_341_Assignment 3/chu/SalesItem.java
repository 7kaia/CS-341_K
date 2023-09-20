package chu;

public class SalesItem {
	
	private String name;
	private double price;
	private int quantity;
	
	
	public SalesItem(String n, double p, int q) {
		name = n;
		price = p;
		quantity = q;
	}
	
	
	public String getName() {
		return name;
	}
	
	public double getPrice() {
		return price;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	
	public void setName(String n) {
		name = n;
	}
	
	public void setPrice(double p) {
		price = p;
	}
	
	public void setQuantity(int q) {
		quantity = q;
	}
	
	public double getSales() {
		return price * quantity;
	}
	
	public String toString() {
		/*String re = name + "\t\t$";
		
		re += String.format("%.2f", price);
		
		if ((int)(price * 100) % 10 == 0) {
			re += price + "0";
		} else {
			re += price;
		}
		
		return re + "\t\t" + quantity;*/ //QUICKER WAY TO WRITE IT BELOW
		
		return name + "\t\t$" + String.format("%.2f", price) + "\t\t" + quantity;
	}
}
