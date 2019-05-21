package persons_buttons_listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controllers.PersonsBookController;

public class NextPageListener implements ActionListener {
	private PersonsBookController controller;

	public NextPageListener(PersonsBookController controller) {
		this.controller = controller;
	}

	public void actionPerformed(ActionEvent e) {
		controller.increasePageNumber();
	}

}
