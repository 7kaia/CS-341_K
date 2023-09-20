package chu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.CardLayout;
import javax.swing.JList;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;

public class Main {

	private JFrame frame;
	private JTextField itemField;
	private JTextField priceField;
	private JTextField quantityField;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public Main() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 868, 676);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextPane salesPane = new JTextPane();
		salesPane.setEditable(false);
		salesPane.setFont(new Font("Tahoma", Font.PLAIN, 28));
		salesPane.setBounds(315, 553, 367, 47);
		frame.getContentPane().add(salesPane);
		
		JButton addButton = new JButton("Add Item to the Sales List");
		addButton.setFont(new Font("Tahoma", Font.PLAIN, 28));
		addButton.setBounds(170, 282, 461, 47);
		frame.getContentPane().add(addButton);
		
		JLabel totalLabel = new JLabel("Total Sales: $");
		totalLabel.setFont(new Font("Tahoma", Font.PLAIN, 28));
		totalLabel.setHorizontalAlignment(SwingConstants.CENTER);
		totalLabel.setBounds(120, 553, 185, 47);
		frame.getContentPane().add(totalLabel);
		
		JLabel quantityLabel = new JLabel("Quantity:");
		quantityLabel.setHorizontalAlignment(SwingConstants.CENTER);
		quantityLabel.setFont(new Font("Tahoma", Font.PLAIN, 28));
		quantityLabel.setBounds(120, 225, 134, 47);
		frame.getContentPane().add(quantityLabel);
		
		JLabel priceLabel = new JLabel("Cost: $");
		priceLabel.setHorizontalAlignment(SwingConstants.CENTER);
		priceLabel.setFont(new Font("Tahoma", Font.PLAIN, 28));
		priceLabel.setBounds(145, 168, 109, 47);
		frame.getContentPane().add(priceLabel);
		
		JLabel itemLabel = new JLabel("Item:");
		itemLabel.setHorizontalAlignment(SwingConstants.CENTER);
		itemLabel.setFont(new Font("Tahoma", Font.PLAIN, 28));
		itemLabel.setBounds(165, 111, 89, 47);
		frame.getContentPane().add(itemLabel);
		
		JLabel titleLabel = new JLabel("Sales List");
		titleLabel.setFont(new Font("Tahoma", Font.PLAIN, 34));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setBounds(132, 44, 579, 47);
		frame.getContentPane().add(titleLabel);
		
		JLabel errorLabel = new JLabel("");
		errorLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		errorLabel.setForeground(new Color(255, 0, 0));
		errorLabel.setVerticalAlignment(SwingConstants.TOP);
		errorLabel.setBounds(120, 336, 602, 22);
		frame.getContentPane().add(errorLabel);
		
		itemField = new JTextField();
		itemField.setFont(new Font("Tahoma", Font.PLAIN, 28));
		itemField.setBounds(264, 111, 367, 47);
		frame.getContentPane().add(itemField);
		itemField.setColumns(10);
		
		priceField = new JTextField();
		priceField.setFont(new Font("Tahoma", Font.PLAIN, 28));
		priceField.setColumns(10);
		priceField.setBounds(264, 168, 367, 47);
		frame.getContentPane().add(priceField);
		
		quantityField = new JTextField();
		quantityField.setFont(new Font("Tahoma", Font.PLAIN, 28));
		quantityField.setColumns(10);
		quantityField.setBounds(264, 225, 367, 47);
		frame.getContentPane().add(quantityField);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(167, 368, 515, 158);
		frame.getContentPane().add(scrollPane);
		
		JTextArea outputBox = new JTextArea();
		scrollPane.setViewportView(outputBox);
		outputBox.setEditable(false);
		outputBox.setFont(new Font("Monospaced", Font.PLAIN, 18));
		
		SalesSlip salesList = new SalesSlip();
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				errorLabel.setText("");
				String name = itemField.getText();
				double price = 0;
				int quantity = 0;
				
				try {
					price = Double.parseDouble(priceField.getText());
					quantity = Integer.parseInt(quantityField.getText());
				} catch (Exception exc) {
					errorLabel.setText("Invalid inputs in the fields.");
				}
				
				if (price == 0 || quantity == 0 || name.length() == 0) {
					errorLabel.setText("Please fill in all the fields.");
				} else {
					salesList.addSalesItem(name, price, quantity);
					outputBox.setText(salesList.toString());
					
					salesPane.setText("" + salesList.getTotalSales());
				}
			}
		});
		
		
	}
}
