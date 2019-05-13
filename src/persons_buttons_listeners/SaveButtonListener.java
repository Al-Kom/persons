package persons_buttons_listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;

import persons_model.PersonsTableModel;

public class SaveButtonListener implements ActionListener {
	private JFrame frame;
	private PersonsTableModel tableModel;
	
	public SaveButtonListener(JFrame frame, PersonsTableModel tableModel) {
		this.frame = frame;
		this.tableModel = tableModel;
	}
	
	public void actionPerformed(ActionEvent e) {
		JFileChooser fileSaveDialog = new JFileChooser();
		fileSaveDialog.showSaveDialog(frame);
		saveToFile(fileSaveDialog.getSelectedFile());
	}
	
	private void saveToFile(File file) {
		PersonsSaver saver = new PersonsSaver();
		saver.saveTableToFile(tableModel, file);
	}
}
