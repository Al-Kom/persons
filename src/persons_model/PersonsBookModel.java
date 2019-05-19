package persons_model;

import java.util.ArrayList;

public class PersonsBookModel {
	private PersonList persons;
	private int pageNumber;
	private int entryPerPage;
	
	public PersonsBookModel() {
		persons = new PersonList();
		setPageNumber(0);
		setEntryPerPage(5);
	}
	
	public void addEntry(Person person) {
		persons.add(person);
	}

	public void addEntry(ArrayList<Person> pArr) {
		persons.add(pArr);
	}
	
	public String getStatus() {
		String res = "<html><h3>Страница " + (pageNumber + 1) +
				" из " + (getPagesAmount() + 1);
		
		int perOnPage;
		if(getPagesAmount() == 0 || pageNumber == getPagesAmount())
			perOnPage = persons.size() % entryPerPage;
		else
			perOnPage = entryPerPage;
		
		res += "<br> Выводится " + perOnPage + " записей на странице из "
				+ entryPerPage + "<br> Всего " + persons.size()
				+ " записей</h3></html>";
	
		return res;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		if(pageNumber < 0)
			return;
		else if(pageNumber < getPagesAmount())
			this.pageNumber = pageNumber;
		else
			this.pageNumber = getPagesAmount();
		/*	update	*/
	}

	public int getEntryPerPage() {
		return entryPerPage;
	}

	public void setEntryPerPage(int entryPerPage) {
		this.entryPerPage = entryPerPage;
	}

	private int getPagesAmount() {
		return (persons.size()/getEntryPerPage());
	}

	public Person getPageEntry(int entryNumber) {
		int index = entryNumber + getPageNumber()*getEntryPerPage();
		return persons.get(index);
	}

	public ArrayList<Person> search(Person person, ArrayList<Integer> searchParams) {
		return persons.search(person, searchParams);
	}
}
