import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class baranggaypermits {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					baranggaypermits window = new baranggaypermits();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public baranggaypermits() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 845, 368);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("BARANGGAY PERMITS");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(263, 10, 273, 50);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("DASHBOARD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dashboard window = new dashboard();
				window.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(10, 10, 160, 34);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1_1 = new JButton("BARANGGAY CLEARANCE");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				baranggayclearance window = new baranggayclearance();
				window.frame.setVisible(true);
				
				frame.dispose();
			}
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1_1.setBounds(441, 98, 251, 66);
		frame.getContentPane().add(btnNewButton_1_1);
		
		JButton btnNewButton_1_1_2 = new JButton("CEDULA");
		btnNewButton_1_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				cedula window = new cedula();
				window.frame.setVisible(true);
				
				frame.dispose();
			}
		});
		btnNewButton_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1_1_2.setBounds(133, 98, 251, 66);
		frame.getContentPane().add(btnNewButton_1_1_2);
	}

}
