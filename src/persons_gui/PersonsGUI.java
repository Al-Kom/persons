package persons_gui;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import persons_model.PersonsTableModel;

public class PersonsGUI {
	private JFrame frame;
	
	public PersonsGUI() {
		frame = new JFrame();
		
		PersonsTableModel tableModel = new PersonsTableModel();
		tableModel.makeCellsEditable(false);
		JTable table = new JTable(tableModel);
		JScrollPane scroller = new JScrollPane(table);
		
		JTextField infoTextField = new JTextField();
		infoTextField.setText(tableModel.getStatus());
		
		PersonsFunctionalButtonsPanel funButtonsPanel =
				new PersonsFunctionalButtonsPanel(tableModel,infoTextField);
		
		PersonsTablePageButtonsPanel pageButonsPanel =
				new PersonsTablePageButtonsPanel(tableModel,infoTextField);
		
		frame.setLayout( new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		frame.getContentPane().add(funButtonsPanel.getPanel());
		frame.getContentPane().add(scroller);
		frame.getContentPane().add(pageButonsPanel.getPanel());
		frame.getContentPane().add(infoTextField);

		frame.setSize(700, 250);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}
