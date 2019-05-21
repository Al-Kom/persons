package persons_buttons_listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controllers.PersonsBookController;

public class PrevPageListener implements ActionListener {
	private PersonsBookController controller;

	public PrevPageListener(PersonsBookController controller) {
		this.controller = controller;
	}

	public void actionPerformed(ActionEvent e) {
		controller.decreasePageNumber();
	}
}
