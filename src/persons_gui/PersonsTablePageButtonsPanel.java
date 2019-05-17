package persons_gui;

import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import persons_buttons_listeners.ChangePageListener;
import persons_buttons_listeners.ChangePersonsAmountOnPageListener;
import persons_buttons_listeners.FirstPageListener;
import persons_buttons_listeners.LastPageListener;
import persons_buttons_listeners.NextPageListener;
import persons_buttons_listeners.PrevPageListener;
import persons_model.PersonsTableModel;

public class PersonsTablePageButtonsPanel {
	private JPanel pagePanel;
	
	public PersonsTablePageButtonsPanel(PersonsTableModel tableModel,
			JLabel infoTextField) {
		
		pagePanel= new JPanel();
		JPanel quickChangePagePanel = new JPanel();
			JButton firstPageButton = new JButton(
					new ImageIcon("sources/first.png"));
			firstPageButton.addActionListener(
					new FirstPageListener(tableModel, infoTextField));
			JButton previosPageButton = new JButton(
					new ImageIcon("sources/prev.png"));
			previosPageButton.addActionListener(
					new PrevPageListener(tableModel, infoTextField));
			JButton nextPageButton = new JButton(
					new ImageIcon("sources/next.png"));
			nextPageButton.addActionListener(
					new NextPageListener(tableModel, infoTextField));
			JButton lastPageButton = new JButton(
					new ImageIcon("sources/last.png"));
			lastPageButton.addActionListener(
					new LastPageListener(tableModel, infoTextField));
		JPanel changeSeveralPagePanel = new JPanel();
			JButton changePageButton = new JButton("Перейти на страницу...");
			changePageButton.addActionListener( 
					new ChangePageListener(tableModel, infoTextField));
			JButton changePersonNumberOnPageButton =
					new JButton("Изменить количество записей на странице");
			changePersonNumberOnPageButton.addActionListener( 
					new ChangePersonsAmountOnPageListener(tableModel, 
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
