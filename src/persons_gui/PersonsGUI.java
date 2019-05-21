package persons_gui;

import javax.swing.BoxLayout;
import javax.swing.JFrame;

import controllers.PersonsBookController;
import controllers.PersonsMainController;

public class PersonsGUI {
	private PersonsBookPanel bookPanel;
	
	public PersonsGUI(PersonsMainController controller,
			PersonsBookController bookController) {
		JFrame frame = new JFrame();
		
		PersonsFunctionalButtonsPanel funButtonsPanel =
				new PersonsFunctionalButtonsPanel(controller);
		
		bookPanel = new PersonsBookPanel(bookController);
			
		frame.setLayout( new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		frame.getContentPane().add(funButtonsPanel.getPanel());
		frame.getContentPane().add(bookPanel.getPanel());

		frame.setSize(750, 300);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public PersonsBookPanel getBookPanel() {
		return bookPanel;
	}
}
