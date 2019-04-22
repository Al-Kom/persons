package persons_buttons_listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;

import persons_model.Person;
import persons_model.PersonsTableModel;

public class LoadButtonListener implements ActionListener {
	private JFrame frame;
	private PersonsTableModel tableModel;
	
	public LoadButtonListener(JFrame frame, PersonsTableModel tableModel) {
		this.frame = frame;
		this.tableModel = tableModel;
	}
	

	public void actionPerformed(ActionEvent e) {
		JFileChooser fileOpenDialog = new JFileChooser();
		fileOpenDialog.showOpenDialog(frame);
		openFromFile(fileOpenDialog.getSelectedFile());
	}
	private void openFromFile(File file) {
		tableModel.cleanAll();
		try {
			BufferedReader reader = new BufferedReader( new FileReader(file));
			String line=null;
			while((line = reader.readLine()) != null) {
				String[] lineComponents = line.split(",");
		for(String s:lineComponents) System.out.println(">>" + s);
				Person person = new Person(
						lineComponents[0],
						lineComponents[1],
						Long.parseLong(lineComponents[2]),
						Long.parseLong(lineComponents[3]));
				
				tableModel.addPerson(person);
			}
			reader.close();
			//repaint
		} catch (IOException ex) {
			System.out.println("can't load from file: " + file.getPath());
			ex.printStackTrace();			
		} catch (NumberFormatException ex) {
			System.out.println("Error when parsing phones. " + ex.getLocalizedMessage());
			return;
		} catch (Exception ex) {
			System.out.println(ex.getLocalizedMessage());
		}
	}
	

}
