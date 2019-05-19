package persons_gui;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import controllers.PersonsMainController;
import persons_model.PersonsTableModel;

public class PersonsGUI {
	
	public PersonsGUI(PersonsMainController controller) {
		JFrame frame = new JFrame();
		
		PersonsFunctionalButtonsPanel funButtonsPanel =
				new PersonsFunctionalButtonsPanel(controller);
		
		PersonsBookPanel book =	new PersonsBookPanel(controller);
			
		frame.setLayout( new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		frame.getContentPane().add(funButtonsPanel.getPanel());
		frame.getContentPane().add(book.getPanel());
		frame.getContentPane().add(statusLabel);

		frame.setSize(750, 300);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}
