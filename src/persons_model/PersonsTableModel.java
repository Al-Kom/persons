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
		if(personsOP != 0)
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

	public void makeCellsEditable(boolean b) {
		cellsIsEditable = b;
	}

	public void addPerson(Person p) {
		if((p != null) && (!this.persons.contains(p)))
			persons.add(p);
		fireTableDataChanged();
	}
	
	public void addPerson(Person[] persons) {
		for(Person p:persons) {
			addPerson(p);
		}
		fireTableDataChanged();
	}
	
	public void removePerson(Person p) {	
		if(p != null) {
			if(persons.remove(p))
				System.out.print(p.getFIO() + " removed");
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
		if(pageNumber < 0)
			return;
		else if(pageNumber < pagesAmount)
			this.pageNumber = pageNumber;
		else
			this.pageNumber = pagesAmount;
		fireTableDataChanged();
	}

	public Person[] search(Person personQ) {
		ArrayList<Person> personAList = new ArrayList<Person>();
		
		for(Person base : persons) {
			if((!personQ.getFirstName().equals("")) && 
					(!base.getFirstName().equals(personQ.getFirstName()))) {
				continue;
			}
			if((!personQ.getSecondName().equals("")) && 
					(!base.getSecondName().equals(personQ.getSecondName()))) {
				continue;
			}
			if((!personQ.getThirdName().equals("")) && 
					(!base.getThirdName().equals(personQ.getThirdName()))) {
				continue;
			}
			if((!personQ.getCity().equals("")) && 
					(!base.getCity().equals(personQ.getCity()))) {
				continue;
			}
			if((!personQ.getStreet().equals("")) && 
					(!base.getStreet().equals(personQ.getStreet()))) {
				continue;
			}
			if((personQ.getHouseNumber() != 0) && 
					(base.getHouseNumber() != personQ.getHouseNumber())) {
				continue;
			}
			if((personQ.getMobilePhoneNumber() != 0) && 
					(base.getMobilePhoneNumber() != personQ.getMobilePhoneNumber())) {
				continue;
			}
			if((personQ.getHomePhoneNumber() != 0) && 
					(base.getHomePhoneNumber() != personQ.getHomePhoneNumber())) {
				continue;
			}
			personAList.add(base);
		}
	
		Person[] personA = new Person[personAList.size()];
		int pAIterator = 0;
		for(Person p : personAList) {
			personA[pAIterator++] = p;
		}
			
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

}
