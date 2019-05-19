package persons_gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import controllers.PersonsBookController;
import controllers.PersonsMainController;

import javax.swing.JLabel;

import persons_model.Person;
import persons_model.PersonsTableModel;

public class PersonsSearchDialog {
	private JDialog dialog;
	private PersonVariableInputPanel inputPanel;
	private PersonsMainController controller;
	
	public PersonsSearchDialog(PersonsMainController controller) {		
		this.controller = controller;
		
		dialog = new JDialog(null,
				"Поиск записи", 
				JDialog.DEFAULT_MODALITY_TYPE);

		inputPanel = new PersonVariableInputPanel();
//
//		JTable dialogAnswerTable = new JTable(dialogAnswerTableModel);
//		JScrollPane scrollerA = new JScrollPane(dialogAnswerTable);
//			scrollerA.setPreferredSize( new Dimension(700, 150));
//			
		JButton searchButton = new JButton("Поиск");
			searchButton.addActionListener(new DialogActionListener());
				
		dialog.setLayout(new BoxLayout(dialog.getContentPane(), BoxLayout.Y_AXIS));
		dialog.add(inputPanel.getPanel());		
		dialog.add(searchButton);
		
		dialog.setSize(750, 200);
		dialog.setVisible(true);
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	}

	private class DialogActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
//			dialogAnswerTableModel.cleanAll();
			
			controller.search(inputPanel.getPerson(), inputPanel.getVariableParametres());
			
//					//update dialog table
//			dialogAnswerTableModel.fireTableDataChanged();
//			//deleting founded persons
//			if(toRemoved)
//				for(int i = 0; i < dialogAnswerTableModel.getPersonsSize(); i++) {
//					tableModel.removePerson(
//						dialogAnswerTableModel.getPerson(i));
//				}
//			//update page if out of borders
//			tableModel.setPageNumber(0);
//			//update information labels
//			if(parentStatusLabel != null)
//				parentStatusLabel.setText(tableModel.getStatus());
//			statusLabel.setText(dialogAnswerTableModel.getStatus());
		}
	}

	public void addFoundedBook(PersonsBookController dialogBookController) {
		PersonsBookPanel book = new PersonsBookPanel(dialogBookController);
	}

}
