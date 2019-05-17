package persons_buttons_listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

import persons_model.PersonsTableModel;

public class FirstPageListener implements ActionListener {
	private PersonsTableModel tableModel;
	private JLabel infoTextField;
	
	public FirstPageListener(PersonsTableModel tableModel,
			JLabel infoTextField) {
		this.tableModel = tableModel;
		this.infoTextField = infoTextField;
	}

	public void actionPerformed(ActionEvent e) {
		tableModel.setPageNumber(0);
		//update information field
		if(infoTextField != null)
			infoTextField.setText(tableModel.getStatus());
	}
}
