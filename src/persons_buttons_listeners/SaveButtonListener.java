package persons_buttons_listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JTextField;

import controllers.PersonsLoader;
import controllers.PersonsSaver;
import persons_model.PersonsTableModel;

public class SaveButtonListener implements ActionListener {
	private PersonsTableModel tableModel;
	
	public SaveButtonListener(PersonsTableModel tableModel) {
		this.tableModel = tableModel;
	}
	
	public void actionPerformed(ActionEvent e) {
		JFileChooser fileOpenDialog = new JFileChooser();
		fileOpenDialog.showOpenDialog(null);
		File file = fileOpenDialog.getSelectedFile();
		if(file != null)
			saveToFile(file);
	}
	
	private void saveToFile(File file) {
		//clean table before saving
		tableModel.cleanAll();
		PersonsSaver saver = new PersonsSaver();
		//filling table all the persons from file
		saver.saveTableToFile(tableModel, file);
	}
}
