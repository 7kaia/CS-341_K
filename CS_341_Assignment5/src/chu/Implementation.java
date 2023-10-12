package chu;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

public class Implementation {
	private static File inputFile;
	private static LinkedList list;
	private static int listSize;
	private static String errorText;
	
	public static String[] implement() {
		//messages[0] will hold outputText
		//messages[1] will hold errorText
		String[] messages = {"", ""};
		
		Scanner scan = null;
		try {
			requestInputFile();
			scan = new Scanner(inputFile);
			
			listSize = 0;
			errorText = "";
			
			list = readInputFile(scan);
			
			if (listSize <= 1) {
				errorText += "Data Not Computed: Invalid size of data (" + listSize + ") to calculate average and standard deviation\n";

			} else {
				double average = list.calculateAverage();
				String outputText = "Average = " + average + "\nStandard Deviation = " + list.calculateStandardDeviation(average);  
				messages[0] = outputText;
			}
			
		} catch (FileNotFoundException except) {
			errorText += "File Selection ERROR: File not found\n";
			
		} finally {
			scan.close();
		}
		
		messages[1] = errorText;
		return messages;
	}
	
	private static void requestInputFile() {
		JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		int returnValue = jfc.showOpenDialog(null);
		
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			inputFile = jfc.getSelectedFile();
		}
	}
	
	private static LinkedList readInputFile(Scanner scan) {
		LinkedList list = new LinkedList();
		while (scan.hasNextLine()) {
			String value = scan.nextLine().trim();
			if (value.length() == 0) {
				errorText += "File Reader ERROR: Empty line\n";
				
			} else {
				
				try {
					double num = Double.parseDouble(value);
					list.addNode(new Node(num));
					listSize++;
					
				} catch (Exception e) {
					errorText += "File Reader ERROR: Invalid Data \"" + value + "\"\n";
				}
			}

		}
		return list;
	}
}
