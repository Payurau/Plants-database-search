import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

public class poisto extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblPlantAddedTo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			poisto dialog = new poisto();
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
	public poisto() {
		setBounds(100, 100, 320, 150);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JButton okButton = new JButton("OK");
			okButton.setForeground(new Color(255, 255, 255));
			okButton.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
			okButton.setBackground(new Color(255, 153, 153));
			okButton.setBounds(83, 69, 102, 34);
			contentPanel.add(okButton);
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			okButton.setActionCommand("OK");
			getRootPane().setDefaultButton(okButton);
		}
		
		lblPlantAddedTo = new JLabel("Plant deleted from database!");
		lblPlantAddedTo.setFont(new Font("Baskerville Old Face", Font.PLAIN, 22));
		lblPlantAddedTo.setBounds(28, 10, 271, 58);
		contentPanel.add(lblPlantAddedTo);
	}
}
