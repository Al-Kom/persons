package persons_model;

import java.util.ArrayList;
import java.util.List;

public class PersonList {
	
	public static final int SEARCH_BY_FIRST_NAME = 0;
	public static final int SEARCH_BY_SECOND_NAME = 1;
	public static final int SEARCH_BY_THIRD_NAME = 2;
	public static final int SEARCH_BY_CITY = 3;
	public static final int SEARCH_BY_STREET = 4;
	public static final int SEARCH_BY_HOUSE_NUMBER = 5;
	public static final int SEARCH_BY_MOBILE_PHONE_NUMBER = 6;
	public static final int SEARCH_BY_HOME_PHONE_NUMBER = 7;
	
	
	
	
	
	private ArrayList<PersonModel> persons;
	
	public PersonList() {
		persons = new ArrayList<PersonModel>();
	}
	
	public void add(PersonModel p) {		
		if(p != null) {
			//checking if persons contains p
			ArrayList<Integer> allParams = new ArrayList<Integer>();
			allParams.add(SEARCH_BY_FIRST_NAME);
			allParams.add(SEARCH_BY_THIRD_NAME);
			allParams.add(SEARCH_BY_CITY);
			allParams.add(SEARCH_BY_STREET);
			allParams.add(SEARCH_BY_HOUSE_NUMBER);
			allParams.add(SEARCH_BY_MOBILE_PHONE_NUMBER);
			allParams.add(SEARCH_BY_HOME_PHONE_NUMBER);
			if(search(p,allParams).size() == 0)
				persons.add(p);
		}				
	}
	
	public void add(List<PersonModel> pArr) {
		for(PersonModel p:pArr) {
			add(p);
		}
	}
	
	public void remove(PersonModel p) {
		persons.remove(p);
	}
	
	public PersonModel get(int ind) {
		return persons.get(ind);
	}
	
	public int size() {
		return persons.size();
	}

	public ArrayList<PersonModel> search(PersonModel personModel, ArrayList<Integer> searchParams) {
		ArrayList<PersonModel> foundedList = new ArrayList<PersonModel>();
		
		for(PersonModel base : persons) {
			if(searchParams.contains(SEARCH_BY_FIRST_NAME) && 
					(!base.getFirstName().equals(personModel.getFirstName()))) {
				continue;
			}
			if(searchParams.contains(SEARCH_BY_SECOND_NAME) && 
					(!base.getSecondName().equals(personModel.getSecondName()))) {
				continue;
			}
			if(searchParams.contains(SEARCH_BY_THIRD_NAME) && 
					(!base.getThirdName().equals(personModel.getThirdName()))) {
				continue;
			}
			if(searchParams.contains(SEARCH_BY_CITY) && 
					(!base.getCity().equals(personModel.getCity()))) {
				continue;
			}
			if(searchParams.contains(SEARCH_BY_STREET) && 
					(!base.getStreet().equals(personModel.getStreet()))) {
				continue;
			}
			if(searchParams.contains(SEARCH_BY_HOUSE_NUMBER) &&
					(base.getHouseNumber() != personModel.getHouseNumber())) {
				continue;
			}
			if(searchParams.contains(SEARCH_BY_MOBILE_PHONE_NUMBER) &&
					(base.getMobilePhoneNumber() != personModel.getMobilePhoneNumber())) {
				continue;
			}
			if(searchParams.contains(SEARCH_BY_HOME_PHONE_NUMBER) &&
					(base.getHomePhoneNumber() != personModel.getHomePhoneNumber())) {
				continue;
			}
			foundedList.add(base);
		}
			
		return foundedList;
	}
	
	public void cleanAll() {
		persons = new ArrayList<PersonModel>();
	}

}
