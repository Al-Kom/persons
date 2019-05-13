package persons_model;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class PersonsTableModel extends AbstractTableModel {
	private final String[] columnNames = {"ФИО", "Адрес", "Моб. тел.", "Дом. тел."};
	private ArrayList<Person> persons;
	private int pageNumber = 0;
	private int personsOnPage = 5;
	private boolean cellsIsEditable = true;
	
	public PersonsTableModel() {
		persons = new ArrayList<Person>();
	}
	
	public PersonsTableModel(Person[] persons) {
		this.persons = new ArrayList<Person>();
		if(persons.length != 0) {
			this.addPerson(persons);
		}
	}
	
	public int getRowCount() {
		return personsOnPage;
	}

	public void setRowCount(int personsOP) {
		personsOnPage = personsOP;
	}

	public int getColumnCount() {
		return 4;
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		int rowI = rowIndex + pageNumber*personsOnPage;
		if(rowI < persons.size()) {
			switch(columnIndex) {
			case 0: return persons.get(rowI).getFIO();
			case 1: return persons.get(rowI).getAddress();
			case 2: return persons.get(rowI).getMobilePhoneNumber();
			case 3: return persons.get(rowI).getHomePhoneNumber();
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

//	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
////System.out.println("row:" + rowIndex + ", size:" + persons.size());
//		if(rowIndex >= persons.size()) return;
////System.out.println("set in " + rowIndex + "." + columnIndex);
//		switch(columnIndex) {
//		case 0: {
//			persons.get(rowIndex).setFirstName((String)aValue);
//			break;
//		}
//		case 1: {
//			persons.get(rowIndex).setAddress((String)aValue);
//			break;
//		}
//		case 2: {
//			long mobilePHN = -1;
//			try {
//				mobilePHN = Long.parseLong((String)aValue);
//			} catch(NumberFormatException ex) {ex.printStackTrace();}
//			if(mobilePHN > 0) {
//				persons.get(rowIndex).setMobilePhoneNumber(mobilePHN);			
//			}
//			break;
//		}
//		case 3: {
//			long homePHN = -1;
//			try {
//				homePHN = Long.parseLong((String)aValue);
//			} catch(NumberFormatException ex) {ex.printStackTrace();}
//			if(homePHN > 0) {
//				persons.get(rowIndex).setHomePhoneNumber(homePHN);	
//			}
//		}
//		}
//	}

	public void makeCellsEditable(boolean b) {
		cellsIsEditable = b;
	}

	public void addPerson(Person p) {
	//if(p == null) System.out.println("person is null in addPerson");
		if((p != null) && (!this.persons.contains(p)) && (this.search(p).length == 0))
			persons.add(p);
		fireTableDataChanged();
	}
	
	public void addPerson(Person[] persons) {
	//if(p == null) System.out.println("person is null in addPerson");
		for(Person p:persons) {
			addPerson(p);
		}
		fireTableDataChanged();
	}
	
	public Person getPerson(int ind) {
		return persons.get(ind);
	}
	
	public int getPersonsSize() {
		return persons.size();
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		int pagesAmount = persons.size()/personsOnPage;
		pageNumber = Math.abs(pageNumber);
		if(pageNumber < pagesAmount)
			this.pageNumber = pageNumber;
		else
			this.pageNumber = pagesAmount;
		fireTableDataChanged();
	}

	public Person[] search(Person personQ) {
		ArrayList<Person> personAList = new ArrayList<Person>();
		
		for(Person base : persons) {
			if(base.getFirstName().equals(base.getSecondName()))
				System.out.println("ERR: " + base.toString());
			if((!personQ.getFirstName().equals("")) && 
					(!base.getFirstName().equals(personQ.getFirstName()))) {
//System.out.println("break in FirstName");
				continue;
			}
			if((!personQ.getSecondName().equals("")) && 
					(!base.getSecondName().equals(personQ.getSecondName()))) {
//System.out.println("break in SecondName");
				continue;
			}
			if((!personQ.getThirdName().equals("")) && 
					(!base.getThirdName().equals(personQ.getThirdName()))) {
//System.out.println("break in ThirdName");
				continue;
			}
			if((!personQ.getCity().equals("")) && 
					(!base.getCity().equals(personQ.getCity()))) {
//System.out.println("break in address");
				continue;
			}
			if((!personQ.getStreet().equals("")) && 
					(!base.getStreet().equals(personQ.getStreet()))) {
//System.out.println("break in address");
				continue;
			}
			if((personQ.getHouseNumber() != 0) && 
					(base.getHouseNumber() != personQ.getHouseNumber())) {
//System.out.println("break in mobilePHN");
				continue;
			}
			if((personQ.getMobilePhoneNumber() != 0) && 
					(base.getMobilePhoneNumber() != personQ.getMobilePhoneNumber())) {
//System.out.println("break in mobilePHN");
				continue;
			}
			if((personQ.getHomePhoneNumber() != 0) && 
					(base.getHomePhoneNumber() != personQ.getHomePhoneNumber())) {
//System.out.println("break in homePHN");
				continue;
			}
//System.out.println("adding " + base.toString());
			personAList.add( new Person(base));
		}
	
		Person[] personA = new Person[personAList.size()];
		int pAIterator = 0;
		for(Person p : personAList) {
			personA[pAIterator++] = p;
		}
		
//System.out.println("length of personA: " + personA.length);
	for(Person p:personA) System.out.println(p.toString());
	
		return personA;
	}
	
	public void cleanAll() {
		persons = new ArrayList<Person>();
		fireTableDataChanged();
	}
	
	public String getStatus() {
		
		int pagesAmount = persons.size()/personsOnPage;
		String res = "Страница " + pageNumber +
				" из " + pagesAmount;
		int perOnPage;
		if(pageNumber == pagesAmount || pagesAmount == 0)
			perOnPage = persons.size()%personsOnPage;
		else
			perOnPage = personsOnPage;
		res += ". Выводится " + perOnPage + " записей на странице из "
				+ persons.size() + " существующих";
		
		return res;
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

}
