package chu;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

public class Implementation {
	
	private static File inputFile;
	private static HashMap<String, Integer> keywords;
	private static String output = "";
	private static int LOC = 0;
	
	private static Stack<String> stack;
	private static LinkedHashSet<String> controlStructures;
	private static LinkedHashMap<String, Integer> methods;
	
	
	public static String buttonFunction() {
		initializeMap();
		LOC = 0;
		Scanner scan = null;
		output = "";
		
		
		stack = new Stack<String>();
		controlStructures = new LinkedHashSet<String>();
		methods = new LinkedHashMap<String, Integer>();
		
		try {
			requestInputFile();
			scan = new Scanner(inputFile);
			output += "File name: \"" + inputFile.getName() + "\"\n";
			
			readFile(scan);

		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			
		} finally {
			if (scan != null) {
				scan.close();
			}
		}
		
		output +="\nLines of Code: " + LOC + "\n";
		
		output += "\nKeywords:"; 
		keywords.forEach((word, num) -> output += keywordsToString(word, num));
		
		output += "\n\nControl Structures:\n";
		controlStructures.forEach((word) -> output += word + "\n");
		
		output += "\nMethods:";
		methods.forEach((word, num) -> output += "\nLOC: " + num + "\t" + word);
		
		return output;
	}
	
	private static void initializeMap() {
		keywords = new HashMap<String, Integer>();
		keywords.put("private", 0);
		keywords.put("public", 0);
		keywords.put("static", 0);
		keywords.put("void", 0);
		keywords.put("int", 0);
		keywords.put("int", 0);
		keywords.put("double", 0);
		keywords.put("String", 0);
		keywords.put("new", 0);
		keywords.put("break", 0);
		keywords.put("return", 0);
		keywords.put("try", 0);
		keywords.put("catch", 0);
		keywords.put("if", 0);
		keywords.put("else", 0);
		keywords.put("import", 0);
		keywords.put("null", 0);
		keywords.put("for", 0);
		keywords.put("while", 0);
		
	}
	
	
	private static String keywordsToString(String word, int num) {
		if (num > 0) {
			return "\n" + word + ": " + num;
		}
		return "";
	}
	
	
	private static void requestInputFile() {
		JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		int returnValue = jfc.showOpenDialog(null);
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			inputFile = jfc.getSelectedFile();
		}
	}
	
	
	private static void readFile(Scanner scan) {
		String function = null;
		
		String element = null;
		
		while (scan.hasNextLine()) {
			String nextLine = trimCode(scan.nextLine()); //trim the code to remove whitespace
			
			//Remove multi-line comments from the LOC count and check
			if (nextLine.contains("/*")) {
				stack.push("/*");
				nextLine = nextLine.split("/*")[0];
			} else if (nextLine.contains("*/")) {
				stack.pop();
				nextLine = nextLine.split("/*")[0];
			}
			
			if (nextLine.length() != 0 && !stack.contains("/*")) { //when code is not empty and not a comment
				if (!nextLine.endsWith("}")) {
					LOC++; //Adds to total count of LOC in program

					if (!(nextLine.contains("}") && !nextLine.contains("else")) && methods.containsKey(function)) {
						methods.put(function, methods.get(function) + 1);
					}
				}
				
				
				//check if code shows a control structure or method
				if (nextLine.contains("}")) {
					if (!stack.isEmpty()) {
						element = stack.pop();
					} else {
						element = null;
					}
				} 
				
				if (nextLine.contains("{")) { //This is because I always type "{" at the end of my line of code
					element = nextLine.substring(0, nextLine.length()-2);
					stack.push(element);
				} 
				
				if (element != null && (element.contains("static") || element.contains("public") || element.contains("private"))) {
					function = element;
					
					if (!methods.containsKey(function)) {
						methods.put(function, 1);
					}
				} else if (element != null) {
					controlStructures.add(element);
				}
				
				
				//Count the total # of keywords
				Scanner codeScan = new Scanner(nextLine);
				
				while (codeScan.hasNext()) {
					String word = codeScan.next();
					if (keywords.containsKey(word)) {
						keywords.put(word, keywords.get(word) + 1);
					}
				}
				codeScan.close();
				
			}
		}
	}
	
	
	private static String trimCode(String line) {
		String re = line;

		//Removes single-line comments out of code
		if (re.indexOf("//") != -1) {
			re = re.substring(0, re.indexOf("//"));
		}
		
		//Removes all tabs
		while (re.indexOf("\t") != -1) {
			int index = re.indexOf("\t");
			re = re.substring(0, index) + re.substring(index+1);
		}
		
		//If there is still code left, then finally, a LOC is a code ending with these characters
		if (re.endsWith("{") || re.endsWith("}") || re.endsWith(";")) {
			return re;
		}
		return "";
		
	}
	
}
