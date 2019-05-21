package persons_model;

import javax.swing.table.AbstractTableModel;

public class PersonsTableModel extends AbstractTableModel {
	private final String[] columnNames = {"ФИО", 
			"Адрес",
			"Моб. тел.", 
			"Дом. тел."};
	private PageModel page;
	
	public PersonsTableModel() {
		page = new PageModel();
	}
	
	public int getRowCount() {
		return page.getEntryAmount();
	}

	public int getColumnCount() {
		return columnNames.length;
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		if(rowIndex < getRowCount()) {
			switch(columnIndex) {
			case 0: return page.getEntry(rowIndex).getFIO();
			case 1: return page.getEntry(rowIndex).getAddress();
			case 2: return page.getEntry(rowIndex).getMobilePhoneNumber();
			case 3: return page.getEntry(rowIndex).getHomePhoneNumber();
			}
		}
		return null;
	}
	
	@Override
	public String getColumnName(int columnIndex) {
		return columnNames[columnIndex];
	}

	public void setPage(PageModel page) {
		this.page = page;
	}


}
