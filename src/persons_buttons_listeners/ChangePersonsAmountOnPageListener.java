package persons_buttons_listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JLabel;

import persons_model.PersonsTableModel;

public class ChangePersonsAmountOnPageListener implements ActionListener {
	private PersonsTableModel tableModel;
	private JLabel statusLabel;
	
	public ChangePersonsAmountOnPageListener(PersonsTableModel tableModel,
			JLabel statusLabel) {
		this.tableModel = tableModel;
		this.statusLabel = statusLabel;
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
			if(statusLabel != null)
				statusLabel.setText(tableModel.getStatus());
		} catch (NumberFormatException ex) {
			System.out.println("Bad number for line ID");
		}
	}

}
