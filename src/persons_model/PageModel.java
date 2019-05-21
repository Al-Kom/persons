package persons_model;

public class PageModel {
	private PersonList persons;

	public PageModel() {
		persons = new PersonList();
	}
	
	public PageModel(PersonList persons) {
		this.persons = persons;
	}

	public PersonModel getEntry(int rowIndex) {
		return persons.get(rowIndex);
	}

	public int getEntryAmount() {
		return persons.size();
	}
	
}
