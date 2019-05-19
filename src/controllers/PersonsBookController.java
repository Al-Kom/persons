package controllers;

import java.util.ArrayList;

import persons_model.Person;
import persons_model.PersonsBookModel;

public class PersonsBookController {
	private PersonsBookModel book;

	public PersonsBookController() {
		book = new PersonsBookModel();
	}

	public void addEntry(Person person) {
		book.addEntry(person);
	}

	public void addEntry(ArrayList<Person> pArr) {
		book.addEntry(pArr);
	}

	public int getEntryPerPage() {
		return book.getEntryPerPage();
	}

	public Person getPageEntry(int entryNumber) {
		return book.getPageEntry(entryNumber);
	}

	public String getStatus() {
		return book.getStatus();
	}

	public ArrayList<Person> search(Person person, ArrayList<Integer> searchParams) {
		return book.search(person, searchParams);
	}
}
