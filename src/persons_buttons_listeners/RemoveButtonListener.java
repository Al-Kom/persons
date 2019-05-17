package persons_buttons_listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

import persons_gui.PersonsSearchAndRemoveDialog;
import persons_model.PersonsTableModel;

public class RemoveButtonListener implements ActionListener {
	private PersonsTableModel tableModel;
	private JLabel infoTextField;

	public RemoveButtonListener(PersonsTableModel tableModel,
			JLabel infoTextField) {
		this.infoTextField = infoTextField;
		this.tableModel = tableModel;
	}
	
	public void actionPerformed(ActionEvent e) {
		//open dialog for searching and removing
		new PersonsSearchAndRemoveDialog(tableModel, infoTextField, true);
	}
	
}
