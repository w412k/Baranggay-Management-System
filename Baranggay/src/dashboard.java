import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.SwingConstants;

public class dashboard {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dashboard window = new dashboard();
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
	public dashboard() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 700, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("BARANGGAY HALL MANAGEMENT SYSTEM");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBackground(Color.CYAN);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(108, 33, 469, 51);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("BARANGGAY INFORMATION");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				baranggayinfo window = new baranggayinfo();
				window.frame.setVisible(true);
				frame.dispose();
			}
			
			
		});
		btnNewButton.setBounds(79, 130, 224, 64);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnBaranggayMembers = new JButton("BARANGGAY OFFICIALS");
		btnBaranggayMembers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				baranggaymembers window = new baranggaymembers();
				window.frame.setVisible(true);
				frame.dispose();
			}
			
			
		});
		btnBaranggayMembers.setBounds(391, 130, 224, 64);
		frame.getContentPane().add(btnBaranggayMembers);
		
		JButton btnPermits = new JButton("PERMITS");
		btnPermits.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				baranggaypermits window = new baranggaypermits();
				window.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnPermits.setBounds(79, 250, 224, 64);
		frame.getContentPane().add(btnPermits);
		
		JButton btnAttendance = new JButton("ATTENDANCE");
		btnAttendance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				attendance window = new attendance();
				window.frame.setVisible(true);
				
				frame.dispose();
			}
		});
		btnAttendance.setBounds(391, 250, 224, 64);
		frame.getContentPane().add(btnAttendance);
		
		JButton btnBlotter = new JButton("BLOTTER");
		btnBlotter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				blotter window = new blotter();
				window.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnBlotter.setBounds(228, 346, 224, 64);
		frame.getContentPane().add(btnBlotter);
		
		JLabel lblNewLabel_1 = new JLabel("WELCOME TO");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(277, 26, 127, 13);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("DASHBOARD");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(266, 74, 146, 36);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JButton btnNewButton_1 = new JButton("LOGOUT");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				login window = new login();
				window.frame.setVisible(true);
				
				frame.dispose();
			}
		});
		btnNewButton_1.setBounds(508, 417, 107, 21);
		frame.getContentPane().add(btnNewButton_1);
	}
	
	
}
