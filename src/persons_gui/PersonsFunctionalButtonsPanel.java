package persons_gui;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import persons_buttons_listeners.AddButtonListener;
import persons_buttons_listeners.LoadButtonListener;
import persons_buttons_listeners.RemoveButtonListener;
import persons_buttons_listeners.SaveButtonListener;
import persons_buttons_listeners.SearchButtonListener;
import persons_model.PersonsTableModel;

public class PersonsFunctionalButtonsPanel {
	private JPanel funPanel;

	public PersonsFunctionalButtonsPanel(PersonsTableModel tableModel,
			JTextField infoTextField) {
		funPanel = new JPanel();
			JButton addButton = new JButton("add");
			JButton removeButton = new JButton("remove");
			JButton searchButton = new JButton("search");
			JButton saveButton = new JButton("save");
			JButton loadButton = new JButton("load");
			addButton.addActionListener(
					new AddButtonListener(tableModel, infoTextField));
			removeButton.addActionListener( 
					new RemoveButtonListener(tableModel, infoTextField));
			searchButton.addActionListener(
					new SearchButtonListener(tableModel));
			saveButton.addActionListener(
					new SaveButtonListener(tableModel));
			loadButton.addActionListener(
					new LoadButtonListener(tableModel, infoTextField));

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
