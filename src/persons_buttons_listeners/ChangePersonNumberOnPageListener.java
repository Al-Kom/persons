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
			String sNumber = JOptionPane.showInputDialog(null,
					"Поменять на:",
					"Число записей на странице",
					JOptionPane.QUESTION_MESSAGE);
			int number = Integer.parseInt(sNumber);
			//set number of persons on a page
			tableModel.setRowCount(number);
			//updating table
			tableModel.fireTableDataChanged();
			//update information field
			if(infoTextField != null)
				infoTextField.setText(tableModel.getStatus());
		} catch (NumberFormatException ex) {
			System.out.println("Bad number for line ID");
		}
	}

}
