package controllers;

import java.util.ArrayList;

import persons_gui.PersonVariableInputPanel;
import persons_gui.PersonsGUI;
import persons_gui.PersonsSearchDialog;
import persons_model.Person;
import persons_model.PersonList;
import persons_model.PersonsBookModel;

public class PersonsMainController {
	private PersonsBookController bookController;
	private PersonsGUI gui;
	private PersonsSearchDialog searchDialog;
	
	public PersonsMainController() {
		bookController = new PersonsBookController();
		gui = new PersonsGUI(this);
	}
	
	public PersonsBookController getBookController() {
		return bookController;
	}

	//delegate
	public void addEntry(Person person) {
		bookController.addEntry(person);
	}

	//delegate
	public int getEntryPerPage() {
		return bookController.getEntryPerPage();
	}

	//delegate
	public Person getPageEntry(int entryNumber) {
		return bookController.getPageEntry(entryNumber);
	}

	//delegate
	public String getBookStatus() {
		return bookController.getStatus();
	}

	public void showSearchDialog() {
		searchDialog = new PersonsSearchDialog(this);
	}

	public void search(Person person, ArrayList<Integer> inputSearchParams) {
		ArrayList<Integer> searchParams = new ArrayList<Integer>();
		if(inputSearchParams.contains(PersonVariableInputPanel.FIRST_NAME_SELECTED))
			searchParams.add(PersonList.SEARCH_BY_FIRST_NAME);
		if(inputSearchParams.contains(PersonVariableInputPanel.SECOND_NAME_SELECTED))
			searchParams.add(PersonList.SEARCH_BY_SECOND_NAME);
		if(inputSearchParams.contains(PersonVariableInputPanel.THIRD_NAME_SELECTED))
			searchParams.add(PersonList.SEARCH_BY_THIRD_NAME);
		if(inputSearchParams.contains(PersonVariableInputPanel.CITY_SELECTED))
			searchParams.add(PersonList.SEARCH_BY_CITY);
		if(inputSearchParams.contains(PersonVariableInputPanel.STREET_SELECTED))
			searchParams.add(PersonList.SEARCH_BY_STREET);
		if(inputSearchParams.contains(PersonVariableInputPanel.HOUSE_NUMBER_SELECTED))
			searchParams.add(PersonList.SEARCH_BY_HOUSE_NUMBER);
		if(inputSearchParams.contains(PersonVariableInputPanel.MOBILE_PHONE_NUMBER_SELECTED))
			searchParams.add(PersonList.SEARCH_BY_MOBILE_PHONE_NUMBER);
		if(inputSearchParams.contains(PersonVariableInputPanel.HOME_PHONE_NUMBER_SELECTED))
			searchParams.add(PersonList.SEARCH_BY_HOME_PHONE_NUMBER);
		ArrayList<Person> founded = bookController.search(person, searchParams);
		
		PersonsBookController dialogBookController = new PersonsBookController();
		dialogBookController.addEntry(founded);
		searchDialog.addFoundedBook(dialogBookController);
	}
	
}
