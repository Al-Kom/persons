package persons_buttons_listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import persons_model.PersonsTableModel;

public class LastPageListener implements ActionListener {
	private PersonsTableModel tableModel;
	private JTextField infoTextField;
	
	public LastPageListener(PersonsTableModel tableModel,
			JTextField infoTextField) {
		this.tableModel = tableModel;
		this.infoTextField = infoTextField;
	}

	public void actionPerformed(ActionEvent e) {
		int page = tableModel.getPersonsSize()/tableModel.getRowCount();
		tableModel.setPageNumber(page);
		infoTextField.setText(tableModel.getStatus());
	}
}
