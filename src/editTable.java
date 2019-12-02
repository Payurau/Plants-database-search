import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.JRadioButton;

public class editTable extends JDialog {
	private JTextField type;
	private JTextField watering;
	private JTextField Nimi;
	private JTextField findFlower;
	private JButton search;
	private JLabel loytyiko;
	private JRadioButton rdbtnName;
	private JRadioButton rdbtnType;
	private JRadioButton rdbtnWatering;
	private JButton btnNewButton_1;
	private JButton btnDeleteFlower;
	private JLabel lblChooseWhatTo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			editTable dialog = new editTable();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setLocationRelativeTo(null);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public editTable() {
		setBounds(100, 100, 450, 396);
		getContentPane().setLayout(null);
		{
			type = new JTextField();
			type.setBounds(195, 228, 96, 19);
			getContentPane().add(type);
			type.setColumns(10);
		}
		{
			watering = new JTextField();
			watering.setBounds(195, 257, 96, 19);
			getContentPane().add(watering);
			watering.setColumns(10);
		}
		{
			Nimi = new JTextField();
			Nimi.setBounds(195, 192, 96, 19);
			getContentPane().add(Nimi);
			Nimi.setColumns(10);
		}
		{
			JLabel lblFlowerNameThat = new JLabel("<html>Search for the flower's name <br>\r\nyou want to edit/delete:</html>");
			lblFlowerNameThat.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
			lblFlowerNameThat.setBounds(116, 0, 239, 64);
			getContentPane().add(lblFlowerNameThat);
		}
		
		findFlower = new JTextField();
		findFlower.setBounds(126, 85, 96, 19);
		getContentPane().add(findFlower);
		findFlower.setColumns(10);
		
		search = new JButton("Search");
		search.setForeground(new Color(255, 255, 255));
		search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String find = findFlower.getText();
				String tulos =  "SELECT * FROM Plants WHERE Name LIKE '"+find+"';";
				hae(tulos);
				
			}
		});
		search.setBackground(new Color(255, 153, 153));
		search.setFont(new Font("Baskerville Old Face", Font.PLAIN, 16));
		search.setBounds(230, 84, 83, 21);
		getContentPane().add(search);
		{
			loytyiko = new JLabel("");
			loytyiko.setForeground(Color.BLACK);
			loytyiko.setFont(new Font("Baskerville Old Face", Font.PLAIN, 16));
			loytyiko.setBounds(153, 114, 148, 19);
			getContentPane().add(loytyiko);
		}
		
		rdbtnName = new JRadioButton("Name");
		rdbtnName.setBounds(116, 191, 73, 21);
		getContentPane().add(rdbtnName);
		
		rdbtnType = new JRadioButton("Type");
		rdbtnType.setBounds(116, 227, 53, 21);
		getContentPane().add(rdbtnType);
		
		rdbtnWatering = new JRadioButton("Watering");
		rdbtnWatering.setBounds(116, 256, 83, 21);
		getContentPane().add(rdbtnWatering);
		
		ButtonGroup bgroup = new ButtonGroup();
        bgroup.add(rdbtnType);
        bgroup.add(rdbtnWatering);
        bgroup.add(rdbtnName);
        {
        	btnNewButton_1 = new JButton("Edit Flower");
        	btnNewButton_1.setForeground(new Color(255, 255, 255));
        	btnNewButton_1.setBackground(new Color(255, 153, 153));
        	btnNewButton_1.setFont(new Font("Baskerville Old Face", Font.PLAIN, 16));
        	btnNewButton_1.addActionListener(new ActionListener() {
        		public void actionPerformed(ActionEvent e) {
        			String tyyppi = type.getText();
					String vesi = watering.getText();
					String name = Nimi.getText();
					String find = findFlower.getText();
        			  if(rdbtnName.isSelected()) {
        		        	System.out.println("nimi");
        		        	if(Nimi.getText().equals("")) {
        		        		write varmista = new write();
        		    			varmista.setLocationRelativeTo(null);
        		    			varmista.setVisible(true);
        		        		System.out.println("Tayta kentta");
        		        	}else {
        		        	String tee = " update Plants set Name='"+name+"' where Name='"+find+"';";
        					muokkaa(tee);
        		        	}
        		        }
        		        else if(rdbtnType.isSelected()) {
        		        	if(type.getText().equals("")) {
        		        		write varmista = new write();
        		    			varmista.setLocationRelativeTo(null);
        		    			varmista.setVisible(true);
        		        		System.out.println("Tayta kentta");
        		        	}else {
        		        	
        		        	System.out.println("type");
        		        	String tee = " update Plants set Type='"+tyyppi+"' where Name='"+find+"';";
        					muokkaa(tee);}
        		        }
        		        else if (rdbtnWatering.isSelected()) {
        		        	if(watering.getText().equals("")) {
        		        		write varmista = new write();
        		    			varmista.setLocationRelativeTo(null);
        		    			varmista.setVisible(true);
        		        		System.out.println("Tayta kentta");
        		        	}else {
        		
        		        	System.out.println("watering");
        		        	String tee = " update Plants set WaterNeeds='"+vesi+"' where Name='"+find+"';";
        					muokkaa(tee);}
        		        }else {
        		        	System.out.println("Valitse");
        		        	valitseNappi varmista = new valitseNappi();
        					varmista.setLocationRelativeTo(null);
        					varmista.setVisible(true);
        		        }
        		}
        	});
        	btnNewButton_1.setBounds(151, 298, 112, 33);
        	getContentPane().add(btnNewButton_1);
        }
        {
        	btnDeleteFlower = new JButton("Delete Flower");
        	btnDeleteFlower.setForeground(new Color(255, 255, 255));
        	btnDeleteFlower.setBackground(new Color(255, 153, 153));
        	btnDeleteFlower.addActionListener(new ActionListener() {
        		public void actionPerformed(ActionEvent e) {
					String find = findFlower.getText();
					if(findFlower.getText().equals("")) {
						choosedelete varmista = new choosedelete();
    					varmista.setLocationRelativeTo(null);
    					varmista.setVisible(true);
					}else {
        			String tee = " delete from Plants where Name='"+find+"';";
					poista(tee);
					}
        		}
        	});
        	btnDeleteFlower.setFont(new Font("Baskerville Old Face", Font.PLAIN, 12));
        	btnDeleteFlower.setBounds(323, 83, 103, 24);
        	getContentPane().add(btnDeleteFlower);
        }
        
        lblChooseWhatTo = new JLabel("Choose what to edit:");
        lblChooseWhatTo.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
        lblChooseWhatTo.setBounds(128, 143, 167, 39);
        getContentPane().add(lblChooseWhatTo);
        
	}
	public void hae(String SQL) {
		try {

			String URL = "jdbc:mysql://sql7.freemysqlhosting.net:3306/sql7313552";
			String dbname = "com.mysql.jdbc.Driver";
			String USER = "sql7313552";
			String PASS = "jFhcUwPW4c";


			Connection con = DriverManager.getConnection(URL, USER, PASS);
			Statement stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery(SQL);
			
			
			if (rs.next()) {
				System.out.println("ID: "+rs.getString(1) + " " + "Name: "+rs.getString(2) + " " + "Type: "+rs.getString(3)+","+" "+"Watering: "+rs.getString(4)+"\n");
			loytyiko.setText("Flower found!");
				con.close();
			
			}else {
			System.out.println("Name not found");
			loytyiko.setForeground(Color.red);
			loytyiko.setText("Name not found!");
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}

	}
	
	public  void muokkaa(String SQL) {
		try {

			String URL = "jdbc:mysql://sql7.freemysqlhosting.net:3306/sql7313552";
			String dbname = "com.mysql.jdbc.Driver";
			String USER = "sql7313552";
			String PASS = "jFhcUwPW4c";


			Connection con = DriverManager.getConnection(URL, USER, PASS);
			Statement stmt = con.createStatement();
			
			stmt.executeUpdate(SQL);

			plantedited varmista = new plantedited();
			varmista.setLocationRelativeTo(null);
			varmista.setVisible(true);
			
			con.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}

	}
	
	public void poista(String SQL) {
		try {

			String URL = "jdbc:mysql://sql7.freemysqlhosting.net:3306/sql7313552";
			String dbname = "com.mysql.jdbc.Driver";
			String USER = "sql7313552";
			String PASS = "jFhcUwPW4c";


			Connection con = DriverManager.getConnection(URL, USER, PASS);
			Statement stmt = con.createStatement();
			
			stmt.executeUpdate(SQL);

			poisto varmista = new poisto();
			varmista.setLocationRelativeTo(null);
			varmista.setVisible(true);
			
			con.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}

	}
	}

