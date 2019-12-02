
import java.awt.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.table.*;

public class showDatabase extends JPanel {
	   public static void main(String[] args) {

	        javax.swing.SwingUtilities.invokeLater(new Runnable() {
	            public void run() {
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

	    }

    private Connection conexao = null;

    public showDatabase() {
        Vector columnNames = new Vector();
        Vector data = new Vector();

        try {
            //  Connect to an Access Database
        	String URL = "jdbc:mysql://sql7.freemysqlhosting.net:3306/sql7313552";
			String dbname = "com.mysql.jdbc.Driver";
			String USER = "sql7313552";
			String PASS = "jFhcUwPW4c";


			Connection con = DriverManager.getConnection(URL, USER, PASS);

            //  Read data from a table
            String sql = "select * from Plants";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            ResultSetMetaData md = rs.getMetaData();
            int columns = md.getColumnCount();

            //  Get column names
            for (int i = 1; i <= columns; i++) {
                columnNames.addElement(md.getColumnName(i));
            }

            //  Get row data
            while (rs.next()) {
                Vector row = new Vector(columns);

                for (int i = 1; i <= columns; i++) {
                    row.addElement(rs.getObject(i));
                }

                data.addElement(row);
            }

            rs.close();
            stmt.close();
            conexao.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        //  Create table with database data
        JTable table = new JTable(data, columnNames) {
            public Class getColumnClass(int column) {
                for (int row = 0; row < getRowCount(); row++) {
                    Object o = getValueAt(row, column);

                    if (o != null) {
                        return o.getClass();
                    }
                }

                return Object.class;
            }
        };

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);

        JPanel buttonPanel = new JPanel();
        add(buttonPanel, BorderLayout.SOUTH);
    }

 
}