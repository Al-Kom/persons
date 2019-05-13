package persons_gui;

import java.awt.FlowLayout;

import javax.swing.*;

import persons_buttons_listeners.*;
import persons_model.PersonsTableModel;

public class PersonsGUI {
	private JFrame frame;
	private PersonsTableModel tableModel;
	private JTextField infoTextField;
	
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
		
		infoTextField = new JTextField();
		infoTextField.setText(tableModel.getStatus());
		
		frame.getContentPane().add(getFunctionalButtonsPanel());
		frame.getContentPane().add(scroller);
		frame.getContentPane().add(getPageButtonsPanel());
		frame.getContentPane().add(infoTextField);

		frame.setSize(700, 250);
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
			addButton.addActionListener(
					new AddButtonListener(frame,tableModel, infoTextField));
			searchButton.addActionListener( new SearchButtonListener(frame, tableModel));
			saveButton.addActionListener( new SaveButtonListener(frame, tableModel));
			loadButton.addActionListener(
					new LoadButtonListener(frame, tableModel, infoTextField));
			funButtonsPanel.add(addButton);
			funButtonsPanel.add(removeButton);
			funButtonsPanel.add(searchButton);
			funButtonsPanel.add(saveButton);
			funButtonsPanel.add(loadButton);
		return funButtonsPanel;
	}
	
	private JPanel getPageButtonsPanel() {
		JPanel pagePanel = new JPanel();
			JPanel quickChangePagePanel = new JPanel();
				JButton firstPageButton = new JButton("<start icon>");
				firstPageButton.addActionListener(
						new FirstPageListener(tableModel, infoTextField));
				JButton previosPageButton = new JButton("<prev icon>");
				previosPageButton.addActionListener(
						new PrevPageListener(tableModel, infoTextField));
				JButton nextPageButton = new JButton("<next icon>");
				nextPageButton.addActionListener(
						new NextPageListener(tableModel, infoTextField));
				JButton lastPageButton = new JButton("<last icon>");
				lastPageButton.addActionListener(
						new LastPageListener(tableModel, infoTextField));
			JPanel changeSeveralPagePanel = new JPanel();
				JButton changePageButton = new JButton("Перейти на страницу...");
				changePageButton.addActionListener( 
						new ChangePageListener(tableModel, infoTextField));
				JButton changePersonNumberOnPageButton =
						new JButton("Изменить количество записей на странице");
				changePersonNumberOnPageButton.addActionListener( 
						new ChangePersonNumberOnPageListener(tableModel, 
														infoTextField));
				
		pagePanel.setLayout( new BoxLayout(pagePanel, BoxLayout.Y_AXIS));
		pagePanel.add(quickChangePagePanel);
			quickChangePagePanel.setLayout( new FlowLayout());
			quickChangePagePanel.add(firstPageButton);
			quickChangePagePanel.add(previosPageButton);
			quickChangePagePanel.add(nextPageButton);
			quickChangePagePanel.add(lastPageButton);
		pagePanel.add(changeSeveralPagePanel);
			changeSeveralPagePanel.setLayout( new FlowLayout());
			changeSeveralPagePanel.add(changePageButton);
			changeSeveralPagePanel.add(changePersonNumberOnPageButton);
			
		return pagePanel;
	}
	
}
