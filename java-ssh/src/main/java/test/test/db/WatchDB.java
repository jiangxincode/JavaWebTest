package test.test.db;

import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class WatchDB {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		JFrame frame = new WatchDBFrame();
		frame.show();
	}
}

class WatchDBFrame extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JButton nextButton;

	private JPanel dataPanel;

	private JComboBox<Object> tableNames;

	private ArrayList<Object> fields;

	private Connection con;

	private Statement stmt;

	private DatabaseMetaData md;

	private ResultSet rs;

	public static Connection getConnectin() throws IOException, ClassNotFoundException, SQLException {

		Properties props = new Properties();
		String fileName = "C:\\CreateDB.properties";
		FileInputStream in = new FileInputStream(fileName);
		props.load(in);

		String drivers = props.getProperty("jdbc.drivers");
		if (null != drivers) {
			Class.forName(drivers);
		}
		String url = props.getProperty("jdbc.url");

		return DriverManager.getConnection(url);
	}

	private void add(Container p, Component c, GridBagConstraints gbc, int x, int y, int w, int h) {
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridwidth = w;
		gbc.gridheight = h;
		p.add(c, gbc);
	}

	public void showNextRow() {
		if (null == rs) {
			return;
		}
		try {
			if (rs.next()) {
				for (int i = 1; i <= fields.size(); i++) {
					String field = rs.getString(i);
					JTextField tb = (JTextField) fields.get(i - 1);
					tb.setText(field);
				}
			} else {
				rs.close();
				rs = null;
			}
		} catch (Exception ex) {
			System.out.println("Error:" + ex);
		}
	}

	public void actionPerformed(ActionEvent evt) {
		if (evt.getSource() == nextButton) {
			showNextRow();
		} else if (evt.getSource() == tableNames) {
			this.remove(dataPanel);
			dataPanel = new JPanel();
			fields.clear();
			dataPanel.setLayout(new GridBagLayout());
			GridBagConstraints gbc = new GridBagConstraints();
			gbc.weighty = 100;

			try {
				String tableName = (String) tableNames.getSelectedItem();
				if (null != rs) {
					rs.close();
				}
				rs = stmt.executeQuery("select * from " + tableName);
				ResultSetMetaData rsmd = rs.getMetaData();
				for (int i = 1; i <= rsmd.getColumnCount(); i++) {
					String columnName = rsmd.getColumnLabel(i);
					int columnWidth = rsmd.getColumnDisplaySize(i);
					JTextField tb = new JTextField(columnWidth);
					fields.add(tb);
					gbc.weightx = 0;
					gbc.anchor = GridBagConstraints.EAST;
					gbc.fill = GridBagConstraints.NONE;
					this.add(dataPanel, new JLabel(columnName), gbc, 0, i - 1, 1, 1);

					gbc.weightx = 100;
					gbc.anchor = GridBagConstraints.WEST;
					gbc.fill = GridBagConstraints.HORIZONTAL;
					this.add(dataPanel, tb, gbc, 1, i - 1, 1, 1);

				}
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(this, ex);
			}
			this.getContentPane().add(dataPanel, "Center");
			this.doLayout();
			this.pack();

			showNextRow();
		}
	}

	public WatchDBFrame() {
		this.setTitle("Êý¾Ý¿â±à³Ì");
		this.setSize(300, 200);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		Container contentPane = this.getContentPane();

		tableNames = new JComboBox<Object>();
		tableNames.addActionListener(this);

		dataPanel = new JPanel();
		contentPane.add(dataPanel, "Center");

		nextButton = new JButton("Next");
		nextButton.addActionListener(this);

		JPanel p = new JPanel();
		p.add(nextButton);
		contentPane.add(p, "South");

		fields = new ArrayList<Object>();

		try {
			con = getConnectin();
			stmt = con.createStatement();
			md = con.getMetaData();

			ResultSet rs = md.getTables(null, null, null, null);
			while (rs.next()) {
				String tableName = rs.getString(3);
				if ("User".equals(tableName) || "Customer".equals(tableName)) {
					tableNames.addItem(tableName);
				}
			}

			rs.close();

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(this, ex);
		}

		contentPane.add(tableNames, "North");

	}

}