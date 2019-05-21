package persons_buttons_listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import controllers.PersonsMainController;
import persons_gui.PersonInputPanel;

public class AddButtonListener implements ActionListener {
	private PersonsMainController controller;
	private PersonInputPanel inputPanel;
	
	public AddButtonListener(PersonsMainController controller) {
		this.controller = controller;
	}
	
	public void actionPerformed(ActionEvent e) {
		createDialog();	
	}
	
	private void createDialog() {
		JDialog dialog = new JDialog(null,
				"Добавление записи", 
				JDialog.DEFAULT_MODALITY_TYPE);
		
		inputPanel = new PersonInputPanel();
		
		JButton addButton = new JButton("Добавить запись");
			addButton.addActionListener(new DialogActionListener());
		
		dialog.setLayout(new BoxLayout(dialog.getContentPane(), BoxLayout.Y_AXIS));
		dialog.add(inputPanel.getPanel());
		dialog.add(addButton);
		
		dialog.setSize(500, 120);
		dialog.setVisible(true);
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	}
	
	private class DialogActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			controller.addEntry(inputPanel.getPerson());
		}
	}
}
