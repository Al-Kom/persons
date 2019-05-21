package persons_gui;
import java.awt.Color;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import controllers.PersonsBookController;
import persons_buttons_listeners.DecreaseEntryPerPageButtonListener;
import persons_buttons_listeners.IncreaseEntryPerPageButtonListener;
import persons_buttons_listeners.FirstPageListener;
import persons_buttons_listeners.LastPageListener;
import persons_buttons_listeners.NextPageListener;
import persons_buttons_listeners.PrevPageListener;
import persons_model.PageModel;
import persons_model.PersonsTableModel;

public class PersonsBookPanel {
	private final int LABEL_WIDTH_COEFFICIENT = 8;
	private JPanel bookPanel;
	private JLabel pageLabel;
	private JLabel entryLabel;
	private PersonsTableModel tableModel;
	
	public PersonsBookPanel(PersonsBookController bookController) {
		//the panel
		bookPanel= new JPanel();
		//table
		tableModel = new PersonsTableModel();
		JTable table = new JTable(tableModel);
		JScrollPane scroller = new JScrollPane(table);
		scroller.setVerticalScrollBarPolicy(
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

		//page buttons		
		JPanel pagePanel = new JPanel();
			JButton firstPageButton = new JButton(
					new ImageIcon("sources/first.png"));
			firstPageButton.addActionListener(
					new FirstPageListener(bookController));
			JButton previosPageButton = new JButton(
					new ImageIcon("sources/prev.png"));
			previosPageButton.addActionListener(
					new PrevPageListener(bookController));
			JButton nextPageButton = new JButton(
					new ImageIcon("sources/next.png"));
			nextPageButton.addActionListener(
					new NextPageListener(bookController));
			JButton lastPageButton = new JButton(
					new ImageIcon("sources/last.png"));
			lastPageButton.addActionListener(
					new LastPageListener(bookController));
			//entry switch panel
			JPanel entrySwitchPanel = new JPanel();
				JButton increaseEntryPerPageButton = new JButton(
						new ImageIcon("sources/inc.png"));
				increaseEntryPerPageButton.addActionListener( 
						new IncreaseEntryPerPageButtonListener(bookController));
				JButton decreaseEntryPerPageButton = new JButton(
						new ImageIcon("sources/dec.png"));
				decreaseEntryPerPageButton.addActionListener( 
						new DecreaseEntryPerPageButtonListener(bookController));
			JPanel vertLinePanel = new VerticalLinePanel();
			pageLabel = new JLabel("PAGE");
			entryLabel = new JLabel("ENTRY");
			
		bookPanel.setLayout( new BoxLayout(bookPanel, BoxLayout.Y_AXIS));
		bookPanel.add(scroller);
		bookPanel.add(pagePanel);
			pagePanel.setLayout( new FlowLayout());
			pagePanel.add(firstPageButton);
			pagePanel.add(previosPageButton);
			pagePanel.add(pageLabel);
			pagePanel.add(nextPageButton);
			pagePanel.add(lastPageButton);
			pagePanel.add(vertLinePanel);
			pagePanel.add(entryLabel);
			pagePanel.add(entrySwitchPanel);
				entrySwitchPanel.setLayout( new BoxLayout(entrySwitchPanel, BoxLayout.Y_AXIS));
				entrySwitchPanel.add(increaseEntryPerPageButton);
				entrySwitchPanel.add(decreaseEntryPerPageButton);

		Dimension borderButtonsDim = new Dimension(
				firstPageButton.getIcon().getIconWidth(),
				firstPageButton.getIcon().getIconHeight()
				);
		Dimension switchPageButtonsDim = new Dimension(
				previosPageButton.getIcon().getIconWidth(),
				previosPageButton.getIcon().getIconHeight()
				);
		Dimension entrySwitchButtonsDim = new Dimension(
				increaseEntryPerPageButton.getIcon().getIconWidth(),
				increaseEntryPerPageButton.getIcon().getIconHeight()
				);
		firstPageButton.setPreferredSize(borderButtonsDim);
		previosPageButton.setPreferredSize(switchPageButtonsDim);
		nextPageButton.setPreferredSize(switchPageButtonsDim);
		lastPageButton.setPreferredSize(borderButtonsDim);
		vertLinePanel.setPreferredSize( new Dimension(1,40));
		vertLinePanel.repaint();
		increaseEntryPerPageButton.setPreferredSize(entrySwitchButtonsDim);
		decreaseEntryPerPageButton.setPreferredSize(entrySwitchButtonsDim);
		pagePanel.setPreferredSize( new Dimension(
				500,
				40));
		
	}
	
	public JPanel getPanel() {
		return bookPanel;
	}
	
	public void updatePageNumber(int pageNumber,int pageAmount) {
		String text = "Стр. " + (pageNumber + 1) + "/" + (pageAmount + 1);
		pageLabel.setText(text);
		int labelWidth = text.length()*LABEL_WIDTH_COEFFICIENT;
		pageLabel.setPreferredSize( 
				new Dimension(labelWidth, 40));
	}

	public void updateEntryAmount(int entryPerPage, int entryPerCurrentPage,
			int entryAmount) {
		String text = "<html>" + entryPerCurrentPage + "/" +
				entryPerPage + " записей<br>" +
				"(Всего " + entryAmount + " )<html/>";
		entryLabel.setText(text);
		entryLabel.paint(entryLabel.getGraphics());
		int labelWidth =text.length()*LABEL_WIDTH_COEFFICIENT/2;
		entryLabel.setPreferredSize( 
				new Dimension(labelWidth, 40));
	}
	
	public void setPage(PageModel pageModel) {
		tableModel.setPage(pageModel);
		tableModel.fireTableDataChanged();
	}
	
	private class VerticalLinePanel extends JPanel {
		@Override
		public void paintComponent(Graphics g) {
			g.setColor(Color.BLACK);
			g.setPaintMode();
			g.drawLine(getWidth()/2, 0, getWidth()/2, getHeight());
		}
	}
	
}
