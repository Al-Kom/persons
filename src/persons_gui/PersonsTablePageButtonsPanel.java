package persons_gui;

import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import persons_buttons_listeners.ChangePageListener;
import persons_buttons_listeners.ChangePersonNumberOnPageListener;
import persons_buttons_listeners.FirstPageListener;
import persons_buttons_listeners.LastPageListener;
import persons_buttons_listeners.NextPageListener;
import persons_buttons_listeners.PrevPageListener;
import persons_model.PersonsTableModel;

public class PersonsTablePageButtonsPanel {
	private JPanel pagePanel;
	
	public PersonsTablePageButtonsPanel(PersonsTableModel tableModel,
			JTextField infoTextField) {
		
		pagePanel= new JPanel();
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
	}
	
	public JPanel getPanel() {
		return pagePanel;
	}
	
}
