package chu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.SwingConstants;
import javax.swing.filechooser.FileSystemView;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import java.awt.Color;
import javax.swing.JScrollPane;

public class DataReader {

	private JFrame frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DataReader window = new DataReader();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public DataReader() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel titleLabel = new JLabel("File Reader");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("Tahoma", Font.PLAIN, 32));
		titleLabel.setBounds(151, 21, 479, 58);
		frame.getContentPane().add(titleLabel);
		
		JTextPane outputPane = new JTextPane();
		outputPane.setFont(new Font("Tahoma", Font.PLAIN, 20));
		outputPane.setEditable(false);
		outputPane.setBounds(80, 173, 629, 95);
		frame.getContentPane().add(outputPane);
		
		JButton button = new JButton("Input file to read");
		button.setFont(new Font("Tahoma", Font.PLAIN, 32));
		button.setBounds(179, 89, 429, 58);
		frame.getContentPane().add(button);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(80, 293, 629, 135);
		frame.getContentPane().add(scrollPane);
		
		JTextPane errorPane = new JTextPane();
		errorPane.setEditable(false);
		scrollPane.setViewportView(errorPane);
		errorPane.setForeground(new Color(255, 0, 0));
		errorPane.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				outputPane.setText("");
				errorPane.setText("");
				
				String[] messages = Implementation.implement();
				
				outputPane.setText(messages[0]);
				errorPane.setText(messages[1]);
			}
		});
		
	}
	
	//add 40 minutes to time taken for this assignment
	//test1 - average: 74.23166667 or around this, standard deviation: 16.37420419 or around this
	//test2 - average: none, 		standard deviation: none
	//test3 - average: 81.6, 		standard deviation: 16.10054347 or around this
	//test4 - average: none, 		standard deviation: none
}
