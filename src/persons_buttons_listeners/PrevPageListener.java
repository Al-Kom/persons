package persons_buttons_listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

import persons_model.PersonsTableModel;

public class PrevPageListener implements ActionListener {
	private PersonsTableModel tableModel;
	private JLabel infoTextField;
	
	public PrevPageListener(PersonsTableModel tableModel,
			JLabel infoTextField) {
		this.tableModel = tableModel;
		this.infoTextField = infoTextField;
	}

	public void actionPerformed(ActionEvent e) {
		int page = tableModel.getPageNumber() - 1;
		if(page >= 0)
			tableModel.setPageNumber(page);
		//update information field
		if(infoTextField != null)
			infoTextField.setText(tableModel.getStatus());
	}
}
