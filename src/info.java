import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class info extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblMadeBy;
	private JLabel lblPauliinaRauramo;
	private JLabel lblPlantDatabaseEditor;
	private JLabel lblVer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			info dialog = new info();
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
	public info() {
		setBounds(100, 100, 371, 218);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblMadeBy = new JLabel("Made by: ");
		lblMadeBy.setFont(new Font("Baskerville Old Face", Font.BOLD, 25));
		lblMadeBy.setBounds(117, 88, 125, 51);
		contentPanel.add(lblMadeBy);
		
		lblPauliinaRauramo = new JLabel("Pauliina Rauramo");
		lblPauliinaRauramo.setFont(new Font("Baskerville Old Face", Font.PLAIN, 25));
		lblPauliinaRauramo.setBounds(81, 120, 188, 51);
		contentPanel.add(lblPauliinaRauramo);
		
		lblPlantDatabaseEditor = new JLabel("Plant database editor");
		lblPlantDatabaseEditor.setFont(new Font("Baskerville Old Face", Font.BOLD, 25));
		lblPlantDatabaseEditor.setBounds(68, 10, 226, 38);
		contentPanel.add(lblPlantDatabaseEditor);
		
		lblVer = new JLabel("Version 1.0");
		lblVer.setFont(new Font("Baskerville Old Face", Font.PLAIN, 25));
		lblVer.setBounds(107, 47, 130, 28);
		contentPanel.add(lblVer);
	}
}
