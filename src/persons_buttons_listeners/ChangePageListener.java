package persons_buttons_listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JLabel;

import persons_model.PersonsTableModel;

public class ChangePageListener implements ActionListener {
	private PersonsTableModel tableModel;
	private JLabel statusLabel;
	
	public ChangePageListener(PersonsTableModel tableModel,
			JLabel statusLabel) {
		this.tableModel = tableModel;
		this.statusLabel = statusLabel;
	}
	
	public void actionPerformed(ActionEvent e) {
		try {
			//open a dialog window for page
			String sPage = JOptionPane.showInputDialog(null,
					"Номер:",
					"Перейти на страницу",
					JOptionPane.QUESTION_MESSAGE);
			int page = Integer.parseInt(sPage);
			tableModel.setPageNumber(page);
			//update information field
			if(statusLabel != null)
				statusLabel.setText(tableModel.getStatus());
		} catch (NumberFormatException ex) {
			System.out.println("Bad number for line ID");
		}
	}
}
