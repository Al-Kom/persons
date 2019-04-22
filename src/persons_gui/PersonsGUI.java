package persons_gui;

import java.awt.FlowLayout;

import javax.swing.*;

import persons_buttons_listeners.*;
import persons_model.PersonsTableModel;

public class PersonsGUI {
	JFrame frame;
	private PersonsTableModel tableModel;
	
	public PersonsGUI() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout( new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		
		tableModel = new PersonsTableModel();
		tableModel.makeCellsEditable(false);
		JTable table = new JTable(tableModel);
		JScrollPane scroller = new JScrollPane(table);
		scroller.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		frame.getContentPane().add(getFunctionalButtonsPanel());
		frame.getContentPane().add(scroller);
		frame.getContentPane().add(getPageButtonsPanel());

		frame.setSize(700, 300);
		frame.setVisible(true);
	}
	
	private JPanel getFunctionalButtonsPanel() {
		JPanel funButtonsPanel = new JPanel();
		funButtonsPanel.setLayout( new FlowLayout());
			JButton addButton = new JButton("add");
			JButton removeButton = new JButton("remove");
			JButton searchButton = new JButton("search");
			JButton saveButton = new JButton("save");
			JButton loadButton = new JButton("load");
			addButton.addActionListener( new AddButtonListener(frame,tableModel));
			searchButton.addActionListener( new SearchButtonListener(frame, tableModel));
			saveButton.addActionListener( new SaveButtonListener(frame, tableModel));
			loadButton.addActionListener( new LoadButtonListener(frame, tableModel));
			funButtonsPanel.add(addButton);
			funButtonsPanel.add(removeButton);
			funButtonsPanel.add(searchButton);
			funButtonsPanel.add(saveButton);
			funButtonsPanel.add(loadButton);
		return funButtonsPanel;
	}
	
	private JPanel getPageButtonsPanel() {
		JPanel panel = new JPanel();
		panel.setLayout( new FlowLayout());
			JButton firstPageButton = new JButton("<start icon>");
			JButton previosPageButton = new JButton("<prev icon>");
			JTextField pageTextField = new JTextField("-1");
			pageTextField.setEditable(false);
			JButton nextPageButton = new JButton("<next icon>");
			JButton lastPageButton = new JButton("<last icon>");
			panel.add(firstPageButton);
			panel.add(previosPageButton);
			panel.add(pageTextField);
			panel.add(nextPageButton);
			panel.add(lastPageButton);
		return panel;
	}
}
