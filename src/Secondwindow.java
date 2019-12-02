import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class Secondwindow extends JDialog {
	private JTextField type;
	private JTextField watering;
	private JTextField Nimi;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Secondwindow dialog = new Secondwindow();
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
	public Secondwindow() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		{
			JButton btnNewButton = new JButton("Add to table");
			btnNewButton.setForeground(new Color(255, 255, 255));
			btnNewButton.setBackground(new Color(255, 153, 153));
			btnNewButton.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String tyyppi = type.getText();
					String vesi = watering.getText();
					String name = Nimi.getText();
					if(Nimi.getText().equals("")|| type.getText().equals("")||watering.getText().equals("")) {
						taytakentta dialog = new taytakentta();
						dialog.setLocationRelativeTo(null);
						dialog.setVisible(true);
						
					}else {
					String tee = " insert into Plants (Name,Type,WaterNeeds) values ('"+name+"','"+tyyppi+"','"+vesi+"')";
					hae(tee);
					}
				}
			});
			btnNewButton.setBounds(153, 183, 138, 45);
			getContentPane().add(btnNewButton);
		}
		{
			type = new JTextField();
			type.setBounds(207, 77, 96, 19);
			getContentPane().add(type);
			type.setColumns(10);
		}
		{
			watering = new JTextField();
			watering.setBounds(207, 125, 96, 19);
			getContentPane().add(watering);
			watering.setColumns(10);
		}
		{
			JLabel lblNimi = new JLabel("Name");
			lblNimi.setBounds(145, 37, 46, 13);
			getContentPane().add(lblNimi);
		}
		{
			JLabel lblTyyppi = new JLabel("Type");
			lblTyyppi.setBounds(145, 80, 46, 13);
			getContentPane().add(lblTyyppi);
		}
		{
			JLabel lblWateringNeeds = new JLabel("Watering");
			lblWateringNeeds.setBounds(141, 128, 56, 13);
			getContentPane().add(lblWateringNeeds);
		}
		{
			Nimi = new JTextField();
			Nimi.setBounds(207, 34, 96, 19);
			getContentPane().add(Nimi);
			Nimi.setColumns(10);
		}
	}
	public void hae(String SQL) {
		try {

			String URL = "jdbc:mysql://sql7.freemysqlhosting.net:3306/sql7313552";
			String dbname = "com.mysql.jdbc.Driver";
			String USER = "sql7313552";
			String PASS = "jFhcUwPW4c";
			

			Connection con = DriverManager.getConnection(URL, USER, PASS);
			Statement stmt = con.createStatement();

			stmt.executeUpdate(SQL);
			
			
			
			plantAdded varmista = new plantAdded();
			varmista.setLocationRelativeTo(null);
			varmista.setVisible(true);
			
			con.close();
			
			
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
