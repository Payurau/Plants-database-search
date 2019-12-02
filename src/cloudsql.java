import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;
import javax.swing.JDesktopPane;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.List;
import javax.swing.JScrollBar;
import javax.swing.JEditorPane;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.DefaultComboBoxModel;

public class cloudsql extends JFrame {

	private JPanel contentPane;
	private JTextField Nimikentta;
	private JTextField typekentta;
	private JTextField wateringkentta;
	private JLabel lblSearchFromDatabase;
	private JMenuBar menuBar;
	private JMenu mnAdd;
	private JMenuItem mntmNewRow;
	private JMenu mnAbout;
	private JMenuItem mntmNewMenuItem;
	private JScrollPane scrollPane;
	private JTextArea textFound;
	private JMenu mnShowTable;
	private JButton btnNewButton_1;
	private JMenuItem mntmInfo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cloudsql frame = new cloudsql();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public cloudsql() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 568, 434);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnAdd = new JMenu("EDIT");
		menuBar.add(mnAdd);
		
		mntmNewRow = new JMenuItem("ADD NEW FLOWER");
		mntmNewRow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Secondwindow dialog = new Secondwindow();
				dialog.setLocationRelativeTo(null);
				dialog.setVisible(true);
				
			}
		});
		mnAdd.add(mntmNewRow);
		
		mntmNewMenuItem = new JMenuItem("EDIT FLOWER");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editTable editoi = new editTable();
				editoi.setLocationRelativeTo(null);
				editoi.setVisible(true);
			}
		});
		mnAdd.add(mntmNewMenuItem);
		
		mnAbout = new JMenu("ABOUT");
		menuBar.add(mnAbout);
		
		mntmInfo = new JMenuItem("INFO");
		mntmInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				info dialog = new info();
				dialog.setLocationRelativeTo(null);
				dialog.setVisible(true);
			}
		});
		mnAbout.add(mntmInfo);
		
		mnShowTable = new JMenu("SHOW...");

		
		
		menuBar.add(mnShowTable);
		
		btnNewButton_1 = new JButton("SHOW TABLE");
        btnNewButton_1.setPreferredSize(new Dimension(107, 20));
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_1.setBackground(Color.LIGHT_GRAY);
		mnShowTable.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frame = new JFrame("Plants Table");
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                //Create and set up the content pane.
                showDatabase newContentPane = new showDatabase();
                newContentPane.setOpaque(true); //content panes must be opaque
                frame.setContentPane(newContentPane);

                //Display the window.
                frame.pack();
                frame.setVisible(true);

			}
		});
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNimi = new JLabel("NAME");
		lblNimi.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
		lblNimi.setBounds(181, 52, 98, 32);
		contentPane.add(lblNimi);
		
		JLabel lblTekij = new JLabel("TYPE");
		lblTekij.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
		lblTekij.setBounds(181, 94, 54, 31);
		contentPane.add(lblTekij);
		
		JLabel lblJulkaisuvuosi = new JLabel("WATERING");
		lblJulkaisuvuosi.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
		lblJulkaisuvuosi.setBounds(154, 134, 159, 32);
		contentPane.add(lblJulkaisuvuosi);
		
		JButton btnHae = new JButton("HAE");
		btnHae.setForeground(new Color(255, 255, 255));
		btnHae.setBackground(new Color(255, 153, 153));
	
		btnHae.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nimihaku = Nimikentta.getText();
				String tyyppihaku = typekentta.getText();
				String wateringhaku = wateringkentta.getText();
				if(Nimikentta.getText().equals("")&&typekentta.getText().equals("")&&wateringkentta.getText().equals("")) {
					taytakentta dialog = new taytakentta();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setLocationRelativeTo(null);
					dialog.setVisible(true);
				}
				if(Nimikentta.getText().equals("")) {
					System.out.println("Name not searched");
				}
				else  {
					String sql = "SELECT * FROM Plants WHERE Name LIKE '"+nimihaku+"';";
					hae(sql);
				}
				if(typekentta.getText().equals("")) {
					System.out.println("Type not searched");
				}
				else  {
					String sql2 = "SELECT * FROM Plants WHERE Type LIKE '"+tyyppihaku+"';";
					hae(sql2);
				}
				if(wateringkentta.getText().equals("")) {
					System.out.println("Watering not searched");
				}
				else  {
					String sql3 = "SELECT * FROM Plants WHERE WaterNeeds LIKE '"+wateringhaku+"';";					
					hae(sql3);
				}
				
				
			}
		});
		btnHae.setBounds(212, 190, 122, 32);
		contentPane.add(btnHae);
		
		Nimikentta = new JTextField();
		Nimikentta.setBounds(271, 63, 122, 20);
		contentPane.add(Nimikentta);
		Nimikentta.setColumns(10);
		
		typekentta = new JTextField();
		typekentta.setBounds(271, 104, 122, 20);
		contentPane.add(typekentta);
		typekentta.setColumns(10);
		
		wateringkentta = new JTextField();
		wateringkentta.setBounds(271, 145, 122, 20);
		contentPane.add(wateringkentta);
		wateringkentta.setColumns(10);
		
		lblSearchFromDatabase = new JLabel("SEARCH FROM DATABASE");
		lblSearchFromDatabase.setFont(new Font("Baskerville Old Face", Font.PLAIN, 22));
		lblSearchFromDatabase.setBounds(124, 10, 301, 43);
		contentPane.add(lblSearchFromDatabase);
		
		scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(null);
		scrollPane.setBounds(96, 265, 238, 99);
		scrollPane.setSize(400, 100);
		contentPane.add(scrollPane);
		
		textFound = new JTextArea();
		scrollPane.setViewportView(textFound);
		textFound.setWrapStyleWord(true);
		textFound.setLineWrap(true);
		textFound.setEditable(false);
		textFound.setFont(new Font("Baskerville Old Face", Font.PLAIN, 18));
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
			
			 if(!rs.isBeforeFirst()) {
	        	 textFound.append("Nothing found"+"\n");
	         }else {
			         while(rs.next()) {
			        	 textFound.append("ID: "+rs.getString(1) + " " + "Name: "+rs.getString(2) + " " + "Type: "+rs.getString(3)+","+" "+"Watering: "+rs.getString(4)+"\n");

			         }
	         }
			        
			
		} catch (Exception e) {
			System.out.println(e);
		}


	}
	}

