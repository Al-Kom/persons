package persons_buttons_listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import persons_model.Person;
import persons_model.PersonsTableModel;

public class AddNodeButtonListener implements ActionListener {
	private JFrame frame;
	private PersonsTableModel tableModel;
	private JDialog dialog;
	private PersonsTableModel dialogTableModel;
	
	public AddNodeButtonListener(JFrame f, PersonsTableModel tableModel) {
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
			dialogTableModel.setNodeNumberOnPage(1);
			dialogTableModel.addPerson( new Person());
			dialogTableModel.makeCellsEditable(true);
		JTable dialogTable = new JTable(dialogTableModel);
		
		JScrollPane scroller = new JScrollPane(dialogTable);
		scroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		dialog.add(scroller);
		
		JButton addButton = new JButton("Add");
			addButton.addActionListener(new DialogActionListener());
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
