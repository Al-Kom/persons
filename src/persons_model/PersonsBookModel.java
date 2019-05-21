package persons_model;

import java.util.ArrayList;

public class PersonsBookModel {
	private PersonList persons;
	private int pageNumber;
	private int entryPerPage;
	
	public PersonsBookModel() {
		persons = new PersonList();
		setEntryPerPage(1);
		setPageNumber(0);
	}
	
	public void addEntry(PersonModel personModel) {
		persons.add(personModel);
	}

	public void addEntry(ArrayList<PersonModel> pArr) {
		persons.add(pArr);
	}

	public int removeEntry(ArrayList<PersonModel> entryArr) {
		int personsBeforeRemoving = persons.size();
		for(PersonModel p:entryArr) {
			persons.remove(p);
		}
		//update page
		setEntryPerPage(getEntryPerPage());
		setPageNumber(getPageNumber());
		return (personsBeforeRemoving - persons.size());
	}

	public PersonModel getPageEntry(int entryNumber) {
		int index = entryNumber + getPageNumber()*getEntryPerPage();
		return persons.get(index);
	}

	public ArrayList<PersonModel> search(PersonModel personModel, ArrayList<Integer> searchParams) {
		return persons.search(personModel, searchParams);
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		if(pageNumber < 0 || getPagesAmount() < 0)
			return;
		else if(pageNumber < getPagesAmount())
			this.pageNumber = pageNumber;
		else
			this.pageNumber = getPagesAmount();
	}

	public int getEntryPerPage() {
		return entryPerPage;
	}

	public void setEntryPerPage(int entryPerPage) {
		if(entryPerPage < 1 || persons.size() < 1)
			this.entryPerPage = 1;
		else if(entryPerPage > persons.size())
			this.entryPerPage = persons.size();
		else
			this.entryPerPage = entryPerPage;
		//update page
		setPageNumber(getPageNumber());
	}

	public int getEntryPerCurrentPage() {
		if(getPagesAmount() == 0 || getPageNumber() == getPagesAmount())
			return (persons.size() % getEntryPerPage());
		else
			return getEntryPerPage();
	}

	public int getPagesAmount() {
		return (persons.size()/getEntryPerPage());
	}

	public PageModel getCurrentPage() {
		PersonList pageEntries =  new PersonList();
		int firstIndex = getPageNumber()*getEntryPerPage();
		int lastIndex = getEntryPerCurrentPage() + firstIndex;
		for(int i = firstIndex; i < lastIndex; i++) {
			pageEntries.add(persons.get(i));
		}
		return new PageModel(pageEntries);
	}

	public int getEntryAmount() {
		return persons.size();
	}

}
