package controllers;

import java.util.ArrayList;

import persons_gui.PersonsBookPanel;
import persons_model.PersonModel;
import persons_model.PersonsBookModel;

public class PersonsBookController {
	private PersonsBookModel book;
	private PersonsBookPanel bookPanel;

	public PersonsBookController(PersonsBookPanel bookPanel) {
		this.bookPanel = bookPanel;
		book = new PersonsBookModel();
		updateBookPanel();
	}
	
	public PersonsBookController() {
		book = new PersonsBookModel();
	}
	
	public void setBookPanel(PersonsBookPanel bookPanel) {
		this.bookPanel = bookPanel;
		updateBookPanel();
	}

	public void addEntry(PersonModel personModel) {
		book.addEntry(personModel);
		updateBookPanel();
	}

	public void addEntry(ArrayList<PersonModel> entryList) {
		book.addEntry(entryList);
		updateBookPanel();
	}

	public int removeEntry(ArrayList<PersonModel> entryList) {
		int removedAmount = book.removeEntry(entryList);
		updateBookPanel();
		return removedAmount;
	}

	public void clearBook() {
		book = new PersonsBookModel();
		updateBookPanel();
	}

	public PersonModel getPageEntry(int entryNumber) {
		return book.getPageEntry(entryNumber);
	}

	public int getEntryPerPage() {
		return book.getEntryPerPage();
	}

	public void setEntryPerPage(int entryNumber) {
		book.setEntryPerPage(entryNumber);
		updateBookPanel();
	}

	public int getEntryPerCurrentPage() {
		return book.getEntryPerCurrentPage();
	}

	public ArrayList<PersonModel> search(PersonModel personModel, ArrayList<Integer> searchParams) {
		return book.search(personModel, searchParams);
	}

	public int getPageNumber() {
		return book.getPageNumber();
	}
	
	public int getPagesAmount() {
		return book.getPagesAmount();
	}

	public void increasePageNumber() {
		book.setPageNumber(book.getPageNumber() + 1);
		updateBookPanel();
	}

	public void decreasePageNumber() {
		book.setPageNumber(book.getPageNumber() - 1);
		updateBookPanel();
	}

	public void setPageFirstNumber() {
		book.setPageNumber(0);
		updateBookPanel();
	}

	public void setPageLastNumber() {
		book.setPageNumber(book.getPagesAmount());
		updateBookPanel();
	}

	public void increaseEntryPerPage() {
		book.setEntryPerPage(book.getEntryPerPage() + 1);
		updateBookPanel();
	}

	public void decreaseEntryPerPage() {
		book.setEntryPerPage(book.getEntryPerPage() - 1);
		updateBookPanel();
	}

	public void updateBookPanel() {
		bookPanel.updateEntryAmount(getEntryPerPage(),
				getEntryPerCurrentPage(),
				book.getEntryAmount()
				);
		bookPanel.updatePageNumber(getPageNumber(), getPagesAmount());
		bookPanel.setPage(book.getCurrentPage());
	}
}
