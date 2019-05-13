package persons_buttons_listeners;
/**
 * TODO:
 * normalize data (make another GUI without table, see registration forms):
 * 		-name
 * 		-Surname
 * 		-father's name
 * 		-mobile phone number
 * 		-home phone number
 */

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import persons_gui.PersonInputPanel;
import persons_model.Person;
import persons_model.PersonsTableModel;

public class SearchButtonListener implements ActionListener {
	private JFrame frame;
	private PersonsTableModel tableModel;
	private JDialog dialog;
	private PersonInputPanel inputPanel;
	private JComboBox<String> searchList;
	private PersonsTableModel dialogAnswerTableModel;

	public SearchButtonListener(JFrame frame, PersonsTableModel tableModel) {
		this.frame = frame;
		this.tableModel = tableModel;
	}
	public void actionPerformed(ActionEvent e) {
		createDialog();
		
	}
	
	private void createDialog() {
		dialog = new JDialog(frame, "Поиск записи", 
				JDialog.DEFAULT_MODALITY_TYPE);
		dialog.setLayout(new BoxLayout(dialog.getContentPane(), BoxLayout.Y_AXIS));

		inputPanel = new PersonInputPanel();

		String[] searchL = {"-по номеру моб. телефона и фамилии",
				"-по номеру дом. телефона и адресу",
				"-по фамилии и цифрам в одном из номеров"};
		searchList = new JComboBox<String>(searchL);
		
		JButton searchButton = new JButton("Поиск");
			searchButton.addActionListener(new DialogActionListener());

		dialogAnswerTableModel = new PersonsTableModel();
			dialogAnswerTableModel.makeCellsEditable(false);
		JTable dialogAnswerTable = new JTable(dialogAnswerTableModel);
		JScrollPane scrollerA = new JScrollPane(dialogAnswerTable);
		scrollerA.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollerA.setToolTipText("Ответ");
		scrollerA.setPreferredSize( new Dimension(700, 110));
		
		dialog.setLayout(new BoxLayout(dialog.getContentPane(), BoxLayout.Y_AXIS));
		dialog.add(inputPanel);		
		dialog.add(searchList);
		dialog.add(searchButton);
		dialog.add(scrollerA);
		dialog.setSize(700, 200);
		dialog.setVisible(true);
	}
	
	private class DialogActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			dialogAnswerTableModel.cleanAll();
			
			switch(searchList.getSelectedIndex()) {
			case 0: {
			//search person by his mobile phone and his second name
				Person personQ = new Person();
				personQ.setMobilePhoneNumber(inputPanel.getMobilePHN());
				personQ.setSecondName(inputPanel.getSecondName());
//System.out.println("we'll search " + personQ.toString() + " (Q1)");

				dialogAnswerTableModel.addPerson(tableModel.search(personQ));
				break;
			}//case 0
			case 1: {
			//search person by his home phone and his address
				Person personQ = new Person();
				personQ.setHomePhoneNumber(inputPanel.getHomePHN());
				personQ.setCity(inputPanel.getCity());
				personQ.setStreet(inputPanel.getStreet());
				personQ.setHouseNumber(inputPanel.getHouseN());
//System.out.println("we'll search " + personQ.toString() + " (Q2)");

				dialogAnswerTableModel.addPerson(tableModel.search(personQ));
				break;
			}//case 1
			case 2: {
			//search person by his second name and by any of his phone
				Person personQ = new Person();
				personQ.setHomePhoneNumber(inputPanel.getHomePHN());
				personQ.setSecondName(inputPanel.getSecondName());
//System.out.println("we'll search " + personQ.toString() + " (Q3.1)");

				dialogAnswerTableModel.addPerson(tableModel.search(personQ));
				personQ.setHomePhoneNumber(0);
				personQ.setMobilePhoneNumber(inputPanel.getMobilePHN());
//System.out.println("and " + personQ.toString() + " (Q3.2)");

				dialogAnswerTableModel.addPerson(tableModel.search(personQ));
				break;
			}//case 2
			}//switch(searchList.getSelectedIndex())
			
			dialogAnswerTableModel.fireTableDataChanged();
		}
		
	}
}
