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
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(file + ".txt"));
			for(int i = 0 ; i < tableModel.getPersonsSize(); i++) {
				writer.write(tableModel.getPerson(i).toString() + "\n");
			}
			
			writer.close();
		} catch (IOException ex) {
	System.out.println("can't save to file: " + file.getPath());
			ex.printStackTrace();
		}
	}
}
