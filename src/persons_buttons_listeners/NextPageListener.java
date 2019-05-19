package persons_buttons_listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

import persons_model.PersonsTableModel;

public class NextPageListener implements ActionListener {
	private PersonsTableModel tableModel;
	private JLabel statusLabel;
	
	public NextPageListener(PersonsTableModel tableModel,
			JLabel statusLabel) {
		this.tableModel = tableModel;
		this.statusLabel = statusLabel;
	}

	public void actionPerformed(ActionEvent e) {
		int page = tableModel.getPageNumber() + 1;
		if(page <= tableModel.getPersonsSize()/tableModel.getRowCount())
			tableModel.setPageNumber(page);
		//update information field
		if(statusLabel != null)
			statusLabel.setText(tableModel.getStatus());
	}

}
