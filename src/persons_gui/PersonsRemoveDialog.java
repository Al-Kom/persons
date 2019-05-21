package persons_gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;

import controllers.PersonsMainController;

public class PersonsRemoveDialog {
	private JDialog dialog;
	private PersonVariableInputPanel inputPanel;
	private PersonsMainController controller;
	
	public PersonsRemoveDialog(PersonsMainController controller) {		
		this.controller = controller;

		dialog = new JDialog(null,
				"Удаление записи", 
				JDialog.DEFAULT_MODALITY_TYPE);

		inputPanel = new PersonVariableInputPanel();
		
		JButton removeButton = new JButton("Найти и удалить");
			removeButton.addActionListener(new DialogRemoveButtonListener());
				
		dialog.setLayout(new BoxLayout(dialog.getContentPane(), BoxLayout.Y_AXIS));
		dialog.add(inputPanel.getPanel());		
		dialog.add(removeButton);
		
		dialog.setSize(500, 120);
		dialog.setVisible(true);
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	}
	
	private class DialogRemoveButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			controller.removeEntry(inputPanel.getPerson(),
					inputPanel.getVariableParametres());
		}
	}

}
