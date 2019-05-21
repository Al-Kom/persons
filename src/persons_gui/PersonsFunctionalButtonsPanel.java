package persons_gui;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import controllers.PersonsMainController;

import persons_buttons_listeners.AddButtonListener;
import persons_buttons_listeners.LoadButtonListener;
import persons_buttons_listeners.RemoveButtonListener;
import persons_buttons_listeners.SaveButtonListener;
import persons_buttons_listeners.SearchButtonListener;

public class PersonsFunctionalButtonsPanel {
	private JPanel funPanel;

	public PersonsFunctionalButtonsPanel(PersonsMainController controller) {

		funPanel = new JPanel();
			JButton addButton = new JButton("add");
			JButton removeButton = new JButton("remove");
			JButton searchButton = new JButton("search");
			JButton saveButton = new JButton("save");
			JButton loadButton = new JButton("load");
			addButton.addActionListener(
					new AddButtonListener(controller));
			removeButton.addActionListener( 
					new RemoveButtonListener(controller));
			searchButton.addActionListener(
					new SearchButtonListener(controller));
			saveButton.addActionListener(
					new SaveButtonListener(controller));
			loadButton.addActionListener(
					new LoadButtonListener(controller));

		funPanel.setLayout( new FlowLayout());
		funPanel.add(addButton);
		funPanel.add(removeButton);
		funPanel.add(searchButton);
		funPanel.add(saveButton);
		funPanel.add(loadButton);
	}

	public JPanel getPanel() {
		return funPanel;
	}
}
