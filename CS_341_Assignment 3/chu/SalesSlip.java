package chu;

import java.util.ArrayList;

public class SalesSlip {
	
	private ArrayList<SalesItem> list;
	
	public SalesSlip() {
		list = new ArrayList<SalesItem>();
	}
	
	public void addSalesItem(String name, double price, int quantity) {
		list.add(new SalesItem(name, price, quantity));
	}
	
	
	public String getTotalSales() {
		double sale = 0;
		
		for (SalesItem s: list) {
			sale += s.getSales();
		}
		
		/*if ((int)(sale * 100) % 10 == 0) {
			return sale + "0";
		} 
		
		return "" + sale;*/
		return String.format("%.2f", sale);
	}
	
	
	public String toString() {
		String re = "";
		for (SalesItem s: list) {
			re += s.toString() + "\n";
		}
		return re;
	}
}
