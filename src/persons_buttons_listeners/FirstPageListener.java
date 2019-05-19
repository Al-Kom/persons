package persons_buttons_listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

import persons_model.PersonsTableModel;

public class FirstPageListener implements ActionListener {
	private PersonsTableModel tableModel;
	private JLabel statusLabel;
	
	public FirstPageListener(PersonsTableModel tableModel,
			JLabel statusLabel) {
		this.tableModel = tableModel;
		this.statusLabel = statusLabel;
	}

	public void actionPerformed(ActionEvent e) {
		tableModel.setPageNumber(0);
		//update information field
		if(statusLabel != null)
			statusLabel.setText(tableModel.getStatus());
	}
}
