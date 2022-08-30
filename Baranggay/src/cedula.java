import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class cedula {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cedula window = new cedula();
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
	public cedula() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 596, 313);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblCedulaRequirements = new JLabel("CEDULA REQUIREMENTS");
		lblCedulaRequirements.setHorizontalAlignment(SwingConstants.CENTER);
		lblCedulaRequirements.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCedulaRequirements.setBounds(0, 10, 553, 32);
		frame.getContentPane().add(lblCedulaRequirements);
		
		JLabel lblNewLabel_1 = new JLabel("PLEASE BRING THE FOLLOWING:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(10, 68, 258, 13);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Accomplished Community Tax Declaration Form (CTDF) (from City Treasurer's Office)");
		lblNewLabel_2.setBounds(72, 101, 428, 24);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Government issued valid ID.");
		lblNewLabel_2_1.setBounds(72, 131, 223, 24);
		frame.getContentPane().add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Proof of Income.");
		lblNewLabel_2_2.setBounds(72, 165, 223, 24);
		frame.getContentPane().add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("Payslip.");
		lblNewLabel_2_3.setBounds(72, 196, 223, 24);
		frame.getContentPane().add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_4 = new JLabel("BIR form 2316.");
		lblNewLabel_2_4.setBounds(72, 230, 223, 24);
		frame.getContentPane().add(lblNewLabel_2_4);
		
		JButton btnNewButton = new JButton("BACK <<--");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				baranggaypermits window = new baranggaypermits();
				window.frame.setVisible(true);
				
				frame.dispose();
			}
		});
		btnNewButton.setBounds(453, 245, 100, 21);
		frame.getContentPane().add(btnNewButton);
	}

}
