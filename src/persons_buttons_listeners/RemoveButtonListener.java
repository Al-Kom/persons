package persons_buttons_listeners;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import persons_gui.PersonInputPanel;
import persons_gui.PersonsSearchAndRemoveDialog;
import persons_model.Person;
import persons_model.PersonsTableModel;

public class RemoveButtonListener implements ActionListener {
	private PersonsTableModel tableModel;
	private JTextField infoTextField;

	public RemoveButtonListener(PersonsTableModel tableModel,
			JTextField infoTextField) {
		this.infoTextField = infoTextField;
		this.tableModel = tableModel;
	}
	
	public void actionPerformed(ActionEvent e) {
		//open dialog for searching and removing
		PersonsSearchAndRemoveDialog dialog =
				new PersonsSearchAndRemoveDialog(tableModel, infoTextField, true);
	}
	
}
