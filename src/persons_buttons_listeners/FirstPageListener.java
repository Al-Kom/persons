package persons_buttons_listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import persons_model.PersonsTableModel;

public class FirstPageListener implements ActionListener {
	private PersonsTableModel tableModel;
	private JTextField infoTextField;
	
	public FirstPageListener(PersonsTableModel tableModel,
			JTextField infoTextField) {
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
