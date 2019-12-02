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
import java.awt.Color;

public class write extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblPlantAddedTo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			write dialog = new write();
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
	public write() {
		setBounds(100, 100, 300, 150);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JButton okButton = new JButton("OK");
			okButton.setBackground(new Color(255, 153, 153));
			okButton.setForeground(new Color(255, 255, 255));
			okButton.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
			okButton.setBounds(96, 69, 102, 34);
			contentPanel.add(okButton);
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			okButton.setActionCommand("OK");
			getRootPane().setDefaultButton(okButton);
		}
		
		lblPlantAddedTo = new JLabel("Don't leave the field empty!");
		lblPlantAddedTo.setFont(new Font("Baskerville Old Face", Font.PLAIN, 22));
		lblPlantAddedTo.setBounds(28, 10, 248, 58);
		contentPanel.add(lblPlantAddedTo);
	}
}
