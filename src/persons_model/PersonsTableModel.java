package persons_model;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class PersonsTableModel extends AbstractTableModel {
	private final String[] columnNames = {"ФИО", "Адрес", "Моб. тел.", "Дом. тел."};
	private ArrayList<Person> persons;
	private int nodeNumberOnPage = 5;
	private boolean cellsIsEditable = false;
	
	public PersonsTableModel() {
		persons = new ArrayList<Person>();
	}
	
	public int getRowCount() {
		return nodeNumberOnPage;
	}

	public int getColumnCount() {
		return 4;
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		if(rowIndex < persons.size()) {
			switch(columnIndex) {
			case 0: return persons.get(rowIndex).getFIO();
			case 1: return persons.get(rowIndex).getAddress();
			case 2: return persons.get(rowIndex).getMobilePhoneNumber();
			case 3: return persons.get(rowIndex).getHomePhoneNumber();
			}
		}
		return null;
	}
	
	public String getColumnName(int columnIndex) {
		return columnNames[columnIndex];
	}

	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return cellsIsEditable;
	}

	public int getNodeNumberOnPage() {
		return nodeNumberOnPage;
	}

	public void setNodeNumberOnPage(int nodeNOP) {
		nodeNumberOnPage = nodeNOP;
	}

	public void makeCellsEditable(boolean b) {
		cellsIsEditable = b;
	}
	
	public void addPerson(Person p) {
	//if(p == null) System.out.println("person is null in addPerson");
		persons.add(p);
		this.fireTableDataChanged();
	}
	
	public Person getPerson(int ind) {
		return persons.get(ind);
	}
	
	/*public Class<?> getColumnClass(int columnIndex) {
		switch(columnIndex) {
		case 0: return String.class;
		case 1: return String.class;
		case 2: return long.class;
		case 3: return long.class;
		}
		return null;
	}*/


	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
	//System.out.println("row:" + rowIndex + ", size:" + persons.size());
		if(rowIndex >= persons.size()) return;
	//System.out.println("set in " + rowIndex + "." + columnIndex);
		Person p = null;
		switch(columnIndex) {
		case 0: {
			persons.get(rowIndex).setFIO((String)aValue);
			break;
		}
		case 1: {
			persons.get(rowIndex).setAddress((String)aValue);
			break;
		}
		case 2: {
			long mobilePHN = -1;
			try {
				mobilePHN = Long.parseLong((String)aValue);
			} catch(Exception ex) {ex.printStackTrace();}
			if(mobilePHN > 0) {
				persons.get(rowIndex).setMobilePhoneNumber(mobilePHN);			
			}
			break;
		}
		case 3: {
			long homePHN = -1;
			try {
				homePHN = Long.parseLong((String)aValue);
			} catch(Exception ex) {ex.printStackTrace();}
			if(homePHN > 0) {
				persons.get(rowIndex).setHomePhoneNumber(homePHN);	
			}
		}
		}
	}

}
