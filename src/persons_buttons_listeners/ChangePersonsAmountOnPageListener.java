package persons_buttons_listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JLabel;

import persons_model.PersonsTableModel;

public class ChangePersonsAmountOnPageListener implements ActionListener {
	private PersonsTableModel tableModel;
	private JLabel infoTextField;
	
	public ChangePersonsAmountOnPageListener(PersonsTableModel tableModel,
			JLabel infoTextField) {
		this.tableModel = tableModel;
		this.infoTextField = infoTextField;
	}
	
	public void actionPerformed(ActionEvent e) {
		try {
			//open a dialog window for page
			String sNumber = JOptionPane.showInputDialog(null,
					"Поменять на:",
					"Число записей на странице",
					JOptionPane.QUESTION_MESSAGE);
			int number = Integer.parseInt(sNumber);
			//set number of persons on a page
			tableModel.setRowCount(number);
			//updating table
			tableModel.fireTableDataChanged();
			//update page if out of borders
			tableModel.setPageNumber(0);
			//update information field
			if(infoTextField != null)
				infoTextField.setText(tableModel.getStatus());
		} catch (NumberFormatException ex) {
			System.out.println("Bad number for line ID");
		}
	}

}
