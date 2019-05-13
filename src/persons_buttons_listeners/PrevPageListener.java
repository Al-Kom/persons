package persons_buttons_listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import persons_model.PersonsTableModel;

public class PrevPageListener implements ActionListener {
	private PersonsTableModel tableModel;
	private JTextField infoTextField;
	
	public PrevPageListener(PersonsTableModel tableModel,
			JTextField infoTextField) {
		this.tableModel = tableModel;
		this.infoTextField = infoTextField;
	}

	public void actionPerformed(ActionEvent e) {
		int page = tableModel.getPageNumber() - 1;
		if(page >= 0)
			tableModel.setPageNumber(page);
		infoTextField.setText(tableModel.getStatus());
	}
}
