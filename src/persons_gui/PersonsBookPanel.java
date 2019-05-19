package persons_gui;

import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import controllers.PersonsMainController;
import persons_buttons_listeners.ChangePageListener;
import persons_buttons_listeners.ChangePersonsAmountOnPageListener;
import persons_buttons_listeners.FirstPageListener;
import persons_buttons_listeners.LastPageListener;
import persons_buttons_listeners.NextPageListener;
import persons_buttons_listeners.PrevPageListener;
import persons_model.PersonsTableModel;

public class PersonsBookPanel {
	private JPanel bookPanel;
	private JLabel statusLabel;
	
	public PersonsBookPanel(PersonsBookController controller) {
		//the panel
		bookPanel= new JPanel();
		//table
		PersonsTableModel tableModel = new PersonsTableModel(controller);
		JTable table = new JTable(tableModel);
		JScrollPane scroller = new JScrollPane(table);
		scroller.setVerticalScrollBarPolicy(
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

		//page buttons		
		JPanel quickChangePagePanel = new JPanel();
			JButton firstPageButton = new JButton(
					new ImageIcon("sources/first.png"));
			firstPageButton.addActionListener(
					new FirstPageListener(controller));
			JButton previosPageButton = new JButton(
					new ImageIcon("sources/prev.png"));
			previosPageButton.addActionListener(
					new PrevPageListener(controller));
			JButton nextPageButton = new JButton(
					new ImageIcon("sources/next.png"));
			nextPageButton.addActionListener(
					new NextPageListener(controller));
			JButton lastPageButton = new JButton(
					new ImageIcon("sources/last.png"));
			lastPageButton.addActionListener(
					new LastPageListener(controller));
		JPanel changeSeveralPagesPanel = new JPanel();
//			JButton changePageButton = new JButton("Перейти на страницу...");
//			changePageButton.addActionListener( 
//					new ChangePageListener(controller));
			JButton changePersonNumberOnPageButton =
					new JButton("Изменить количество записей на странице");
			changePersonNumberOnPageButton.addActionListener( 
					new ChangePersonsAmountOnPageListener(controller));
		//info label
		statusLabel = new JLabel();
			statusLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
			statusLabel.setText(controller.getBookStatus());
			
		bookPanel.setLayout( new BoxLayout(bookPanel, BoxLayout.Y_AXIS));
		bookPanel.add(scroller);
		bookPanel.add(quickChangePagePanel);
			quickChangePagePanel.setLayout( new FlowLayout());
			quickChangePagePanel.add(firstPageButton);
			quickChangePagePanel.add(previosPageButton);
			quickChangePagePanel.add(nextPageButton);
			quickChangePagePanel.add(lastPageButton);
		bookPanel.add(changeSeveralPagesPanel);
			changeSeveralPagesPanel.setLayout( new FlowLayout());
			changeSeveralPagesPanel.add(changePageButton);
			changeSeveralPagesPanel.add(changePersonNumberOnPageButton);
		bookPanel.add(statusLabel);
	}
	
	public JPanel getPanel() {
		return bookPanel;
	}
	
	public JLabel getStatusLabel() {
		return statusLabel;
	}
	
}
