package persons_buttons_listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import persons_model.Person;
import persons_model.PersonsTableModel;

public class AddButtonListener implements ActionListener {
	private JFrame frame;
	private PersonsTableModel tableModel;
	private JDialog dialog;
	private PersonsTableModel dialogTableModel;
	
	public AddButtonListener(JFrame f, PersonsTableModel tableModel) {
		frame = f;
	//if(tableModel == null) System.out.println("tableModel in AddNodeButtonListener() is null");
		this.tableModel = tableModel;
	}
	
	public void actionPerformed(ActionEvent e) {
		createDialog();
	}
	
	private void createDialog() {
		dialog = new JDialog(frame, "Добавление записи", 
				JDialog.DEFAULT_MODALITY_TYPE);
		dialog.setLayout(new BoxLayout(dialog.getContentPane(), BoxLayout.Y_AXIS));
		
		dialogTableModel = new PersonsTableModel();
			dialogTableModel.setRowCount(1);
			dialogTableModel.addPerson( new Person());
		JTable dialogTable = new JTable(dialogTableModel);
		
		JScrollPane scroller = new JScrollPane(dialogTable);
		scroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		scroller.setSize(700, 50);
		
		JButton addButton = new JButton("Добавить");
			addButton.addActionListener(new DialogActionListener());
			
		dialog.add(scroller);
		dialog.add(addButton);
		dialog.setSize(700, 100);
		dialog.setVisible(true);
	}
	
	private class DialogActionListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			Person person = new Person(dialogTableModel.getPerson(0));
		//if(tableModel == null) System.out.println("why tableModel is null on DialogActionListener?");
			tableModel.addPerson(person);
			dialog.dispose();
		}
		
	}


}
