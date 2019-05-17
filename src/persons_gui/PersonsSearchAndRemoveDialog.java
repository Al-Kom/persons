package persons_gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;

import persons_model.Person;
import persons_model.PersonsTableModel;

public class PersonsSearchAndRemoveDialog {
	private PersonsTableModel tableModel;
	private JLabel infoTextField;
	private PersonInputPanel inputPanel;
	private JComboBox<String> searchList;
	private PersonsTableModel dialogAnswerTableModel;
	private boolean toRemoved = false;
	
	public PersonsSearchAndRemoveDialog(PersonsTableModel tableModel,
			JLabel infoTextField, boolean toRemoved) {
		
		this.tableModel = tableModel;
		this.infoTextField = infoTextField;
		this.toRemoved = toRemoved;
		
		String operation = (toRemoved)
							? "Удаление"
							: "Поиск";
		
		JDialog dialog = new JDialog(null,
				operation + " записи", 
				JDialog.DEFAULT_MODALITY_TYPE);
		dialog.setLayout(new BoxLayout(dialog.getContentPane(), BoxLayout.Y_AXIS));

		inputPanel = new PersonInputPanel();

		String[] searchL = {"-по номеру моб. телефона и фамилии",
				"-по номеру дом. телефона и адресу",
				"-по фамилии и цифрам в одном из номеров"};
		searchList = new JComboBox<String>(searchL);
		
		JButton searchButton = new JButton(operation);
			searchButton.addActionListener(new DialogActionListener());

		dialogAnswerTableModel = new PersonsTableModel();
			dialogAnswerTableModel.makeCellsEditable(false);
		JTable dialogAnswerTable = new JTable(dialogAnswerTableModel);
		JScrollPane scrollerA = new JScrollPane(dialogAnswerTable);
		scrollerA.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollerA.setToolTipText("Ответ");
		scrollerA.setPreferredSize( new Dimension(700, 150));
		
		PersonsTablePageButtonsPanel pageButonsPanel =
				new PersonsTablePageButtonsPanel(tableModel,null);
				
		dialog.setLayout(new BoxLayout(dialog.getContentPane(), BoxLayout.Y_AXIS));
		dialog.add(inputPanel);		
		dialog.add(searchList);
		dialog.add(searchButton);
		dialog.add(scrollerA);
		dialog.add(pageButonsPanel.getPanel());
		dialog.setSize(750, 300);
		dialog.setVisible(true);
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	}
	
	private class DialogActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			dialogAnswerTableModel.cleanAll();
			
			switch(searchList.getSelectedIndex()) {
			case 0: {
			//search person by his mobile phone and his second name
				//creating a given person
				Person personQ = new Person();
				personQ.setMobilePhoneNumber(inputPanel.getMobilePHN());
				personQ.setSecondName(inputPanel.getSecondName());
				//searching persons like [person] on parent table
				//and output them to dialog's table 
				dialogAnswerTableModel.addPerson(tableModel.search(personQ));
				break;
			}//case 0
			case 1: {
			//search person by his home phone and his address
				//creating a given person
				Person personQ = new Person();
				personQ.setHomePhoneNumber(inputPanel.getHomePHN());
				personQ.setCity(inputPanel.getCity());
				personQ.setStreet(inputPanel.getStreet());
				personQ.setHouseNumber(inputPanel.getHouseN());
				//searching persons like [person] on parent table
				//and output them to dialog's table 
				dialogAnswerTableModel.addPerson(tableModel.search(personQ));
				break;
			}//case 1
			case 2: {
			//search person by his (second name,mobile phone) [1st stage]
			//and (second name,home phone) [2st stage] and merge results
				//creating a given person (home phone)
				Person personQ = new Person();
				personQ.setHomePhoneNumber(inputPanel.getHomePHN());
				personQ.setSecondName(inputPanel.getSecondName());
				//searching persons like [person] on parent table
				//and output them to dialog's table
				dialogAnswerTableModel.addPerson(tableModel.search(personQ));

				//rewriting the person (mobile phone)
				personQ.setHomePhoneNumber(0);
				personQ.setMobilePhoneNumber(inputPanel.getMobilePHN());
				//searching persons like [person] on parent table
				//and output them to dialog's table
				dialogAnswerTableModel.addPerson(tableModel.search(personQ));
				//results are automatically merged
				break;
			}//case 2
			}//switch(searchList.getSelectedIndex())
			
			//update dialog table
			dialogAnswerTableModel.fireTableDataChanged();
			//deleting founded persons
			if(toRemoved)
				for(int i = 0; i < dialogAnswerTableModel.getPersonsSize(); i++) {
					tableModel.removePerson(
						dialogAnswerTableModel.getPerson(i));
				}
			//update page if out of borders
			tableModel.setPageNumber(0);
			//update information field
			if(infoTextField != null)
				infoTextField.setText(tableModel.getStatus());
		}
	}

}
