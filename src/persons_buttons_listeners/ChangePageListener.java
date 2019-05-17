package persons_buttons_listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import persons_model.PersonsTableModel;

public class ChangePageListener implements ActionListener {
	private PersonsTableModel tableModel;
	private JTextField infoTextField;
	
	public ChangePageListener(PersonsTableModel tableModel,
			JTextField infoTextField) {
		this.tableModel = tableModel;
		this.infoTextField = infoTextField;
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
			if(infoTextField != null)
				infoTextField.setText(tableModel.getStatus());
		} catch (NumberFormatException ex) {
			System.out.println("Bad number for line ID");
		}
	}
}
