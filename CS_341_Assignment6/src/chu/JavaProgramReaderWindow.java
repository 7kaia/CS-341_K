package chu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;

public class JavaProgramReaderWindow {

	private JFrame frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JavaProgramReaderWindow window = new JavaProgramReaderWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public JavaProgramReaderWindow() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1300, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel titleLabel = new JLabel("Java Program Reader");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("Tahoma", Font.PLAIN, 32));
		titleLabel.setBounds(435, 29, 418, 55);
		frame.getContentPane().add(titleLabel);
		
		JButton button = new JButton("Input Java file");
		button.setFont(new Font("Tahoma", Font.PLAIN, 28));
		button.setBounds(495, 94, 306, 55);
		frame.getContentPane().add(button);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 167, 1236, 586);
		frame.getContentPane().add(scrollPane);
		
		JTextPane outputPane = new JTextPane();
		scrollPane.setViewportView(outputPane);
		outputPane.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				outputPane.setText("");
				String output = Implementation.buttonFunction();
				outputPane.setText(output);
			}
		});;
		
		
	}
}
