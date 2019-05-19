package persons_model;

import javax.swing.table.AbstractTableModel;

import controllers.PersonsMainController;

public class PersonsTableModel extends AbstractTableModel {
	private final String[] columnNames = {"ФИО", 
			"Адрес",
			"Моб. тел.", 
			"Дом. тел."};
	private final int columnNumber = columnNames.length; 
	private PersonsMainController controller;
//	private PersonList persons;
	
	public PersonsTableModel(PersonsMainController controller) {
		this.controller = controller;
	}
	
	public int getRowCount() {
		return controller.getEntryPerPage();
	}

	public int getColumnCount() {
		return columnNumber;
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		if(rowIndex < getRowCount()) {
			switch(columnIndex) {
			case 0: return controller.getPageEntry(rowIndex).getFIO();
			case 1: return controller.getPageEntry(rowIndex).getAddress();
			case 2: return controller.getPageEntry(rowIndex).getMobilePhoneNumber();
			case 3: return controller.getPageEntry(rowIndex).getHomePhoneNumber();
			}
		}
		return null;
	}
	
	@Override
	public String getColumnName(int columnIndex) {
		return columnNames[columnIndex];
	}

//	public void setPageNumber(int pageNumber) {
//		int pagesAmount = getPagesAmount();
//		if(pageNumber < 0)
//			return;
//		else if(pageNumber < pagesAmount)
//			this.pageNumber = pageNumber;
//		else
//			this.pageNumber = pagesAmount;
//		fireTableDataChanged();
//	}


}
