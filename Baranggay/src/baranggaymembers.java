import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import net.proteanit.sql.DbUtils;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class baranggaymembers {

	JFrame frame;
	private JTextField txtname;
	private JTextField txtage;
	private JTextField txtposition;
	private JTextField txtaddress;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					baranggaymembers window = new baranggaymembers();
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
	public baranggaymembers() {
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
	           pst = con.prepareStatement("select * from member");
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
		frame.setBounds(100, 100, 1142, 544);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("BARANGGAY MEMBERS");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(275, 10, 326, 49);
		frame.getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(37, 57, 326, 307);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("NAME");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(114, 10, 95, 24);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("AGE");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(114, 76, 95, 24);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("POSITION");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_2.setBounds(114, 149, 95, 24);
		panel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("ADDRESS");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_3.setBounds(114, 221, 95, 24);
		panel.add(lblNewLabel_1_3);
		
		txtname = new JTextField();
		txtname.setBounds(42, 34, 239, 32);
		panel.add(txtname);
		txtname.setColumns(10);
		
		txtage = new JTextField();
		txtage.setColumns(10);
		txtage.setBounds(42, 97, 239, 32);
		panel.add(txtage);
		
		txtposition = new JTextField();
		txtposition.setColumns(10);
		txtposition.setBounds(42, 170, 239, 32);
		panel.add(txtposition);
		
		txtaddress = new JTextField();
		txtaddress.setColumns(10);
		txtaddress.setBounds(42, 242, 239, 32);
		panel.add(txtaddress);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(374, 58, 703, 306);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnSave = new JButton("SAVE");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connect();
				
				String name, age, position, address;
				
				 name =  txtname.getText ();
				 age = txtage.getText ();
				 position = txtposition.getText ();
				 address = txtaddress.getText ();
				 
				 
				try {
				 pst = con.prepareStatement ("insert into member(name,age,position,address) values (?, ?, ?,?) ");
				 pst.setString (1, name) ;
				 pst.setString (2, age);
				 pst.setString (3, position);
				 pst.setString (4, address);
				 pst.executeUpdate ();
				 
				 table_load();
				 
				 
				 JOptionPane.showMessageDialog(null, "Record Added!");
				 table_load () ;
				 
				 txtname.setText ("");
				 txtage.setText ("");
				 txtposition.setText ("");
				 txtaddress.setText("");
				 
				 txtname.requestFocus ();

				}
				
				 catch (SQLException el) {
					 
					 el.printStackTrace () ;

				 }
			}
		});
		btnSave.setBounds(91, 374, 85, 39);
		frame.getContentPane().add(btnSave);
		
		JButton btnClear = new JButton("CLEAR");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 txtname.setText ("");
				 txtage.setText ("");
				 txtposition.setText ("");
				 txtaddress.setText("");
			}
		});
		btnClear.setBounds(212, 374, 85, 39);
		frame.getContentPane().add(btnClear);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String name, age, position,address,search;
				
				 name =  txtname.getText ();
				 age = txtage.getText ();
				 position = txtposition.getText ();
				 address= txtaddress.getText();
				 search = txtsearch.getText();
				 
				try {
				 pst = con.prepareStatement ("update member set name=?, age=?, position=?,address=?  where name=?");
				 pst.setString (1, name);
				 pst.setString (2, age);
				 pst.setString (3,position);
				 pst.setString (4, address);
				 pst.setString (5, search);
				 pst.executeUpdate ();
				 
				 table_load();
				 
				 
				 JOptionPane.showMessageDialog(null, "Record Updated!");
				 table_load () ;
				 
				 txtname.setText ("");
				 txtage.setText ("");
				 txtposition.setText ("");
				 txtaddress.setText("");
				 txtname.requestFocus ();

				}
				
				 catch (SQLException el) {
					 
					 el.printStackTrace () ;

				 }
			}
		});
		btnUpdate.setBounds(554, 374, 102, 39);
		frame.getContentPane().add(btnUpdate);
		
		JButton btnRemove = new JButton("REMOVE");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String search;
				search = txtsearch.getText();
				 
				try {
				 pst = con.prepareStatement ("delete from member where name=?");
				 
				 pst.setString (1, search);
				 pst.executeUpdate ();
				 
				 table_load();
				 
				 
				 JOptionPane.showMessageDialog(null, "Record Removed!");
				 table_load () ;
				 txtname.setText ("");
				 txtage.setText ("");
				 txtposition.setText ("");
				 txtaddress.setText("");
				 txtname.requestFocus ();

				}
				
				 catch (SQLException el) {
					 
					 el.printStackTrace () ;

				 }
			}
		});
		btnRemove.setBounds(791, 374, 102, 39);
		frame.getContentPane().add(btnRemove);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(34, 424, 329, 73);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("SEARCH NAME");
		lblNewLabel_1_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_3_1.setBounds(85, 10, 142, 24);
		panel_1.add(lblNewLabel_1_3_1);
		
		txtsearch = new JTextField();
		txtsearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				 try {
			          
			            String search = txtsearch.getText();

			                pst = con.prepareStatement("select name,age,position, address from member where name = ?");
			                pst.setString(1,search);
			                ResultSet rs = pst.executeQuery();

			            if(rs.next()==true)
			            {
			              
			                String name = rs.getString(1);
			                String age = rs.getString(2);
			                String position = rs.getString(3);
			                String address = rs.getString(4);
			                
			                txtname.setText(name);
			                txtage.setText(age);
			                txtposition.setText(position);  
			                txtaddress.setText(address);  
			            }   
			            else
			            {
			            	 txtname.setText ("");
							 txtage.setText ("");
							 txtposition.setText ("");
							 txtaddress.setText("");
			                 
			            }
			        } 
				
				 catch (SQLException ex) {
			           
			        }			
			}
		});
		txtsearch.setColumns(10);
		txtsearch.setBounds(42, 31, 239, 32);
		panel_1.add(txtsearch);
		
		JButton btnNewButton = new JButton("DASHBOARD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dashboard window = new dashboard();
				window.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(37, 10, 160, 34);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("ATTENDANCE");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				attendance window = new attendance();
				window.frame.setVisible(true);
				
				frame.dispose();
			}
		});
		btnNewButton_1.setBounds(408, 443, 134, 39);
		frame.getContentPane().add(btnNewButton_1);
	}
}
