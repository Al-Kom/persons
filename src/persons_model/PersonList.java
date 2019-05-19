package persons_model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class PersonList {
	
	public static final int SEARCH_BY_FIRST_NAME = 0;
	public static final int SEARCH_BY_SECOND_NAME = 1;
	public static final int SEARCH_BY_THIRD_NAME = 2;
	public static final int SEARCH_BY_CITY = 3;
	public static final int SEARCH_BY_STREET = 4;
	public static final int SEARCH_BY_HOUSE_NUMBER = 5;
	public static final int SEARCH_BY_MOBILE_PHONE_NUMBER = 6;
	public static final int SEARCH_BY_HOME_PHONE_NUMBER = 7;
	
	private ArrayList<Person> persons;
	private ArrayList<ChangeListener> listenerList;
	
	public PersonList() {
		persons = new ArrayList<Person>();
		listenerList = new ArrayList<ChangeListener>();
		fireDataChanged();
	}
	
	public void add(Person p) {
		if((p != null) && (!persons.contains(p)))
			persons.add(p);
		fireDataChanged();		
	}
	
	public void add(List<Person> pArr) {
		for(Person p:pArr) {
			add(p);
		}
		fireDataChanged();		
	}
	
	public void remove(Person p) {
		persons.remove(p);
	}
	
	public Person get(int ind) {
		return persons.get(ind);
	}
	
	public int size() {
		return persons.size();
	}

	public ArrayList<Person> search(Person person, ArrayList<Integer> searchParams) {
		ArrayList<Person> foundedList = new ArrayList<Person>();
		
		for(Person base : persons) {
			if(searchParams.contains(SEARCH_BY_FIRST_NAME) && 
					(!base.getFirstName().equals(person.getFirstName()))) {
				continue;
			}
			if(searchParams.contains(SEARCH_BY_SECOND_NAME) && 
					(!base.getSecondName().equals(person.getSecondName()))) {
				continue;
			}
			if(searchParams.contains(SEARCH_BY_THIRD_NAME) && 
					(!base.getThirdName().equals(person.getThirdName()))) {
				continue;
			}
			if(searchParams.contains(SEARCH_BY_CITY) && 
					(!base.getCity().equals(person.getCity()))) {
				continue;
			}
			if(searchParams.contains(SEARCH_BY_STREET) && 
					(!base.getStreet().equals(person.getStreet()))) {
				continue;
			}
			if(searchParams.contains(SEARCH_BY_HOUSE_NUMBER) &&
					(base.getHouseNumber() != person.getHouseNumber())) {
				continue;
			}
			if(searchParams.contains(SEARCH_BY_MOBILE_PHONE_NUMBER) &&
					(base.getMobilePhoneNumber() != person.getMobilePhoneNumber())) {
				continue;
			}
			if(searchParams.contains(SEARCH_BY_HOME_PHONE_NUMBER) &&
					(base.getHomePhoneNumber() != person.getHomePhoneNumber())) {
				continue;
			}
			foundedList.add(base);
		}
			
		return foundedList;
	}
	
	public void cleanAll() {
		persons = new ArrayList<Person>();
		fireDataChanged();
	}
	
	
	public void addChangeListener(ChangeListener listener) {
		listenerList.add(listener);
	}

	private void fireDataChanged() {
		ChangeEvent evt = new ChangeEvent(this);
		for(ChangeListener listener:listenerList) {
			listener.stateChanged(evt);
		}
	}
}
