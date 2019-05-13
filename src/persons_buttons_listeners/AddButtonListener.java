package persons_buttons_listeners;
import java.awt.GridLayout;
/**
 * TODO:
 * normalize data (make another GUI without table, see registration forms):
 * 		-name
 * 		-Surname
 * 		-father's name
 * 		-mobile phone number
 * 		-home phone number
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import persons_gui.PersonInputPanel;
import persons_model.Person;
import persons_model.PersonsTableModel;

public class AddButtonListener implements ActionListener {
	private JFrame frame;
	private JTextField infoTextField;
	private PersonsTableModel tableModel;
	private JDialog dialog;
	private PersonInputPanel inputPanel;
	
	public AddButtonListener(JFrame f, PersonsTableModel tableModel,
			JTextField infoTextField) {
		frame = f;
	//if(tableModel == null) System.out.println("tableModel in AddNodeButtonListener() is null");
		this.tableModel = tableModel;
		this.infoTextField = infoTextField;
	}
	
	public void actionPerformed(ActionEvent e) {
		createDialog();
		infoTextField.setText(tableModel.getStatus());		
	}
	
	private void createDialog() {
		dialog = new JDialog(frame, "Добавление записи", 
				JDialog.DEFAULT_MODALITY_TYPE);
		
		inputPanel = new PersonInputPanel();
		
		JButton addButton = new JButton("Добавить");
			addButton.addActionListener(new DialogActionListener());
		
		dialog.setLayout(new BoxLayout(dialog.getContentPane(), BoxLayout.Y_AXIS));
		dialog.add(inputPanel);
		dialog.add(addButton);
		dialog.setSize(700, 100);
		dialog.setVisible(true);
	}
	
	private class DialogActionListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			Person person = new Person();
			person.setFirstName(inputPanel.getFirstName());
			person.setSecondName(inputPanel.getSecondName());
			person.setThirdName(inputPanel.getThirdName());
			person.setCity(inputPanel.getCity());			
			person.setStreet(inputPanel.getStreet());
			person.setHouseNumber(inputPanel.getHouseN());
			person.setMobilePhoneNumber(inputPanel.getMobilePHN());
			person.setHomePhoneNumber(inputPanel.getHomePHN());
		//if(tableModel == null) System.out.println("why tableModel is null on DialogActionListener?");
			tableModel.addPerson(person);
			dialog.dispose();
		}
		
	}


}
