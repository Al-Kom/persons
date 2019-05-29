package controllers;

import java.io.File;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import persons_gui.PersonVariableInputPanel;
import persons_gui.PersonsGUI;
import persons_gui.PersonsRemoveDialog;
import persons_gui.PersonsSearchDialog;
import persons_model.PersonModel;
import persons_model.PersonList;

public class PersonsMainController {
	private PersonsBookController bookController;
	private PersonsGUI gui;
	private PersonsSearchDialog searchDialog;
	
	public PersonsMainController() {
		bookController = new PersonsBookController();
		gui = new PersonsGUI(this, bookController);
		bookController.setBookPanel(gui.getBookPanel());
	}

	//delegate
	public void addEntry(PersonModel personModel) {
		bookController.addEntry(personModel);
	}

	public void showSearchDialog() {
		searchDialog = new PersonsSearchDialog(this);
		searchDialog.showDialog();
	}

	public void showRemoveDialog() {
		new PersonsRemoveDialog(this);
	}

	public void searchEntry(PersonModel personModel,
			ArrayList<Integer> variableParametres) {
		ArrayList<PersonModel> founded = search(personModel, variableParametres);
		PersonsBookController searchDialogBookController =
				new PersonsBookController();
		//give book controller to search dialog for it's book's buttons
		searchDialog.addBookController(searchDialogBookController);
		//for book updating
		searchDialogBookController.setBookPanel(searchDialog.getBookPanel());
		//fill the book
		searchDialogBookController.addEntry(founded);
	}

	public void removeEntry(PersonModel personModel, ArrayList<Integer> variableParametres) {
		ArrayList<PersonModel> founded = search(personModel, variableParametres);
		String removeInfo;
		int foundedEntryAmount = founded.size();
		if(foundedEntryAmount == 0) {
			removeInfo = "Ничего не найдено";
		} else {
			int removedAmount = bookController.removeEntry(founded);
			removeInfo = "Найдено " + foundedEntryAmount + " записей\n" +
					"Удалено " + removedAmount + " записей";
		}
		JOptionPane.showMessageDialog(null,
				removeInfo,
				"Отчет об удалении",
				JOptionPane.PLAIN_MESSAGE);
	}

	public ArrayList<PersonModel> search(PersonModel personModel, ArrayList<Integer> inputSearchParams) {
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
		
		return bookController.search(personModel, searchParams);
	}

	public void saveBook() {
		JFileChooser fileSaveDialog = new JFileChooser();
		fileSaveDialog.showOpenDialog(null);
		File file = fileSaveDialog.getSelectedFile();
		if(file != null) {
			new PersonsSaver(bookController, file);
		}
	}

	public void loadBook() {
		JFileChooser fileLoadDialog = new JFileChooser();
		fileLoadDialog.showOpenDialog(null);
		File file = fileLoadDialog.getSelectedFile();
		if(file != null) {
			bookController.clearBook();
			new PersonsLoader(bookController ,file);			
		}
	}
	
}
