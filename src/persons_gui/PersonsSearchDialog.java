package persons_gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;

import controllers.PersonsBookController;
import controllers.PersonsMainController;

public class PersonsSearchDialog {
	private JDialog dialog;
	private PersonVariableInputPanel inputPanel;
	private PersonsMainController controller;
	private PersonsBookPanel bookPanel;
	
	public PersonsSearchDialog(PersonsMainController controller) {		
		this.controller = controller;
		
		dialog = new JDialog(null,
				"Поиск записи", 
				JDialog.DEFAULT_MODALITY_TYPE);

		inputPanel = new PersonVariableInputPanel();
		
		JButton searchButton = new JButton("Поиск");
			searchButton.addActionListener(new DialogSearchButtonListener());
				
		dialog.setLayout(new BoxLayout(dialog.getContentPane(), BoxLayout.Y_AXIS));
		dialog.add(inputPanel.getPanel());		
		dialog.add(searchButton);
		
	}
	
	public void showDialog() {
		dialog.setSize(750, 120);
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.setVisible(true);
	}

	private class DialogSearchButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			controller.searchEntry(inputPanel.getPerson(),
					inputPanel.getVariableParametres());
		}
	}

	public void addBookController(PersonsBookController bookController) {
		if(bookPanel != null)
			dialog.remove(bookPanel.getPanel());
		bookPanel = new PersonsBookPanel(bookController);
		dialog.add(bookPanel.getPanel());
		dialog.setSize(750, 300);
		dialog.paint(dialog.getGraphics());
	}
	
	public PersonsBookPanel getBookPanel() {
		return bookPanel;
	}

}
