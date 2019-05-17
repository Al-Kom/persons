package persons_buttons_listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import persons_model.PersonsTableModel;

public class NextPageListener implements ActionListener {
	private PersonsTableModel tableModel;
	private JTextField infoTextField;
	
	public NextPageListener(PersonsTableModel tableModel,
			JTextField infoTextField) {
		this.tableModel = tableModel;
		this.infoTextField = infoTextField;
	}

	public void actionPerformed(ActionEvent e) {
		int page = tableModel.getPageNumber() + 1;
		if(page <= tableModel.getPersonsSize()/tableModel.getRowCount())
			tableModel.setPageNumber(page);
		//update information field
		if(infoTextField != null)
			infoTextField.setText(tableModel.getStatus());
	}

}
