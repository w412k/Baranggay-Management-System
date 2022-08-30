import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;


import net.proteanit.sql.DbUtils;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class blotter {

	JFrame frame;
	private JTextField txtcomplain;
	private JTextField txtcomplainant;
	private JTextField txtdate;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					blotter window = new blotter();
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
	public blotter() {
		initialize();
		Connect();
		table_load();
	}
	
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	private JTextField txtsearch;
	

	public void Connect() {
		
	
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/javacrud", "root", "");
		}
		
		catch (ClassNotFoundException ex)
		{
		}	
		catch (SQLException ex)
		{
			
		}
	}
	

	public void table_load()
	   {
	       try
	       {
	           pst = con.prepareStatement("select * from blotter");
	           rs =  pst.executeQuery();
	           table.setModel(DbUtils.resultSetToTableModel(rs));
	       }
	       catch(SQLException e)
	         {
	           e.printStackTrace();
	         }
	   }
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 916, 768);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("BLOTTER REPORT");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(257, 10, 364, 71);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("COMPLAIN");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(10, 70, 119, 25);
		frame.getContentPane().add(lblNewLabel_1);
		
		txtcomplain = new JTextField();
		txtcomplain.setBounds(136, 70, 711, 131);
		frame.getContentPane().add(txtcomplain);
		txtcomplain.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("COMPLAINANT");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(10, 223, 165, 25);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("DATE OF HEARING");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_2.setBounds(10, 272, 200, 25);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		txtcomplainant = new JTextField();
		txtcomplainant.setBounds(234, 230, 207, 19);
		frame.getContentPane().add(txtcomplainant);
		txtcomplainant.setColumns(10);
		
		txtdate = new JTextField();
		txtdate.setColumns(10);
		txtdate.setBounds(234, 279, 207, 19);
		frame.getContentPane().add(txtdate);
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connect();
				
				String complain, complainant, date;
				
				complain =  txtcomplain.getText ();
				complainant = txtcomplainant.getText ();
				date = txtdate.getText ();
				
				 
				 
				try {
				 pst = con.prepareStatement ("insert into blotter(complain, complainant, date) values (?, ?, ?) ");
				 pst.setString (1, complain) ;
				 pst.setString (2, complainant);
				 pst.setString (3, date);
				 pst.executeUpdate ();
				 
				 table_load();
				 
				 
				 JOptionPane.showMessageDialog(null, "Record Added!");
				 table_load () ;
				 
				 txtcomplain.setText ("");
				 txtcomplainant.setText ("");
				 txtdate.setText ("");
				 
				 
				 txtcomplain.requestFocus ();

				}
				
				 catch (SQLException el) {
					 
					 el.printStackTrace () ;

				 }
			}
		});
		btnNewButton.setBounds(500, 211, 105, 40);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connect();
				
				String complain, complainant, date, search;
				
				complain =  txtcomplain.getText ();
				complainant = txtcomplainant.getText ();
				date = txtdate.getText ();
				search = txtsearch.getText();
				
				 
				 
				try {
				 pst = con.prepareStatement ("update blotter set complain=?, complainant=?, date=?  where complainant=?");
				 pst.setString (1, complain) ;
				 pst.setString (2, complainant);
				 pst.setString (3, date);
				 pst.setString (4, search);
				 pst.executeUpdate ();
				 
				 table_load();
				 
				 
				 JOptionPane.showMessageDialog(null, "Record Updated!");
				 table_load () ;
				 
				 txtcomplain.setText ("");
				 txtcomplainant.setText ("");
				 txtdate.setText ("");
				 
				 
				 txtcomplain.requestFocus ();

				}
				
				 catch (SQLException el) {
					 
					 el.printStackTrace () ;

				 }
			}
			
		});
		btnUpdate.setBounds(615, 211, 105, 40);
		frame.getContentPane().add(btnUpdate);
		
		JButton btnRemove = new JButton("REMOVE");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String search;
				search = txtsearch.getText();
				 
				try {
				 pst = con.prepareStatement ("delete from blotter where complainant=?");
				 
				 pst.setString (1, search);
				 pst.executeUpdate ();
				 
				 table_load();
				 
				 
				 JOptionPane.showMessageDialog(null, "Record Removed!");
				 table_load () ;
				 txtcomplain.setText ("");
				 txtcomplainant.setText ("");
				 txtdate.setText ("");
				 txtcomplainant.requestFocus ();

				}
				
				 catch (SQLException el) {
					 
					 el.printStackTrace () ;

				 }
			}
		});
		btnRemove.setBounds(730, 211, 105, 40);
		frame.getContentPane().add(btnRemove);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 330, 870, 266);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("SEARCH COMPLAINANT");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1_1.setBounds(10, 623, 257, 25);
		frame.getContentPane().add(lblNewLabel_1_1_1);
		
		txtsearch = new JTextField();
		txtsearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				 try {
			          
			            String search = txtsearch.getText();

			                pst = con.prepareStatement("select complain, complainant, date from blotter where complainant = ?");
			                pst.setString(1,search);
			                ResultSet rs = pst.executeQuery();

			            if(rs.next()==true)
			            {
			              
			                String complain = rs.getString(1);
			                String complainant = rs.getString(2);
			                String date = rs.getString(3);
			                
			                
			                txtcomplain.setText(complain);
			                txtcomplainant.setText(complainant);
			                txtdate.setText(date);  
			               
			            }   
			            else
			            {
			            	 txtcomplain.setText ("");
				             txtcomplainant.setText ("");
				             txtdate.setText ("");
			                 
			            }
			        } 
				
				 catch (SQLException ex) {
			           
			        }			
			}
		});
		txtsearch.setColumns(10);
		txtsearch.setBounds(277, 623, 207, 26);
		frame.getContentPane().add(txtsearch);
		
		JButton btnNewButton_1 = new JButton("DASHBOARD");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dashboard window = new dashboard();
				window.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setBounds(10, 10, 160, 34);
		frame.getContentPane().add(btnNewButton_1);
	}
}
