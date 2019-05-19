package persons_buttons_listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import persons_gui.PersonsSearchDialog;
import persons_model.PersonsTableModel;

public class SearchButtonListener implements ActionListener {
	private PersonsTableModel tableModel;

	public SearchButtonListener(PersonsTableModel tableModel) {
		this.tableModel = tableModel;
	}
	
	public void actionPerformed(ActionEvent e) {
		//open dialog for searching
		new PersonsSearchDialog(tableModel,null,false);
	}

}
