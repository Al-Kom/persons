package persons_buttons_listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import persons_model.PersonsTableModel;

public class ChangePersonNumberOnPageListener implements ActionListener {
	private PersonsTableModel tableModel;
	private JTextField infoTextField;
	
	public ChangePersonNumberOnPageListener(PersonsTableModel tableModel,
			JTextField infoTextField) {
		this.tableModel = tableModel;
		this.infoTextField = infoTextField;
	}
	
	public void actionPerformed(ActionEvent e) {
		try {
			//open a dialog window for page
			String sNumber = 
					JOptionPane.showInputDialog("Число записей на странице...");
			int number = Integer.parseInt(sNumber);
			tableModel.setRowCount(number);
			infoTextField.setText(tableModel.getStatus());
			tableModel.fireTableDataChanged();
		} catch (NumberFormatException ex) {
			System.out.println("Bad number for line ID");
		}
	}

}
