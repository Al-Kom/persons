package persons_buttons_listeners;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import persons_model.Person;
import persons_model.PersonsTableModel;

public class SearchButtonListener implements ActionListener {
	private JFrame frame;
	private PersonsTableModel tableModel;
	private JDialog dialog;
	private PersonsTableModel dialogQuestionTableModel;
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
		
		dialogQuestionTableModel = new PersonsTableModel();
			dialogQuestionTableModel.setRowCount(1);
			dialogQuestionTableModel.addPerson( new Person());
		JTable dialogQuestionTable = new JTable(dialogQuestionTableModel);
		JScrollPane scrollerQ = new JScrollPane(dialogQuestionTable);
		scrollerQ.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		scrollerQ.setToolTipText("Запрос");
		scrollerQ.setPreferredSize( new Dimension(700, 50));
		String[] searchL = {"-по номеру моб. телефона и фамилии",
				"-по номеру дом. телефона и адресу",
				"-по фамилии и цифрам в одном из номеров"};
		searchList = new JComboBox<String>(searchL);
		
		JButton addButton = new JButton("Поиск");
			addButton.addActionListener(new DialogActionListener());

		dialogAnswerTableModel = new PersonsTableModel();
			dialogAnswerTableModel.makeCellsEditable(false);
		JTable dialogAnswerTable = new JTable(dialogAnswerTableModel);
		JScrollPane scrollerA = new JScrollPane(dialogAnswerTable);
		scrollerA.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollerA.setToolTipText("Ответ");
		scrollerA.setPreferredSize( new Dimension(700, 110));
		
		dialog.add(scrollerQ);
		dialog.add(searchList);
		dialog.add(addButton);
		dialog.add(scrollerA);
		dialog.setSize(700, 200);
		dialog.setVisible(true);
	}
	
	private class DialogActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			switch(searchList.getSelectedIndex()) {
			case 0: {
				//search person by his mobile phone and his first word in FIO
				Person personQ = new Person();
				personQ.setMobilePhoneNumber(
						dialogQuestionTableModel.getPerson(0).getMobilePhoneNumber());
				personQ.setFIO(
						dialogQuestionTableModel.getPerson(0).getFIO());
System.out.println("we'll search " + personQ.toString() + " (Q1)");
				dialogAnswerTableModel = new PersonsTableModel(
						tableModel.search(personQ));
				break;
			}
			case 1: {
				//search person by his home phone and his address
				Person personQ = new Person();
				personQ.setHomePhoneNumber(
						dialogQuestionTableModel.getPerson(0).getHomePhoneNumber());
				personQ.setAddress(
						dialogQuestionTableModel.getPerson(0).getAddress());
System.out.println("we'll search " + personQ.toString() + " (Q2)");
				dialogAnswerTableModel = new PersonsTableModel(
						tableModel.search(personQ));
				break;
			}
			case 2: {
				//search person by his first word in FIO and by any of his phone
				Person personQ = new Person();
				personQ.setHomePhoneNumber(
						dialogQuestionTableModel.getPerson(0).getHomePhoneNumber());
				personQ.setFIO(
						dialogQuestionTableModel.getPerson(0).getFIO());
System.out.println("we'll search " + personQ.toString() + " (Q3.1)");
				dialogAnswerTableModel = new PersonsTableModel(
						tableModel.search(personQ));
				personQ.setHomePhoneNumber(-1);
				personQ.setMobilePhoneNumber(
						dialogQuestionTableModel.getPerson(0).getMobilePhoneNumber());
System.out.println("and " + personQ.toString() + " (Q3.2)");
				dialogAnswerTableModel.addPerson(tableModel.search(personQ));
				break;
			}
				
			}
			
			dialogAnswerTableModel.setRowCount(dialogAnswerTableModel.getPersonsSize());
			dialogAnswerTableModel.fireTableStructureChanged();
System.out.println("dialogAnswerTableRowCount size: " + dialogAnswerTableModel.getRowCount());
			
			dialogAnswerTableModel.fireTableDataChanged();
			dialogAnswerTableModel.fireTableCellUpdated(0, 0);
			dialogAnswerTableModel.fireTableRowsInserted(0, dialogAnswerTableModel.getRowCount());
			dialogAnswerTableModel.fireTableRowsUpdated(0, dialogAnswerTableModel.getRowCount());
			dialogAnswerTableModel.fireTableStructureChanged();
			/**
			 * TODO:
			 * how to update dialogAnswerTableModel?
			 */
			dialogAnswerTableModel.makeCellsEditable(false);

		}
		
	}
}
