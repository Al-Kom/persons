package controllers;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import persons_model.Person;

public class PersonsLoader {
	private ArrayList<Person> personList;
	
	public Person[] loadPersonsFromFile(File file) {
		personList = new ArrayList<Person>();
		
		try {
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser parser = factory.newSAXParser();
			
			parser.parse(file, new PersonXMLHandler());
			
		} catch (NumberFormatException ex) {
			System.out.println("Error when parsing phones. " + ex.getLocalizedMessage());
			ex.printStackTrace();
		} catch (Exception ex) {
			System.out.println("Unknown exception: ");
			ex.printStackTrace();
		}
		
		Person [] personArray = new Person[personList.size()];
		int pAIterator = 0;
		for(Person p : personList) {
			personArray[pAIterator++] = p;
		}
		
		return personArray;
	}
	
	private class PersonXMLHandler extends DefaultHandler {
		String fName;
		String sName;
		String tName;
		String city;
		String street;
		int houseN;
		long mobilePHN;
		long homePHN;
		
		@Override
		public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
			if(qName.equals("firstName")) {
            	fName = attributes.getValue("value");
            }
			if(qName.equals("secondName")) {
            	sName = attributes.getValue("value");
            }
			if(qName.equals("thirdName")) {
            	tName = attributes.getValue("value");
            }
			if(qName.equals("city")) {
            	city = attributes.getValue("value");
            }
			if(qName.equals("street")) {
            	street = attributes.getValue("value");
            }
			if(qName.equals("houseN")) {
				houseN = Integer.parseInt(attributes.getValue("value"));
            }
			if(qName.equals("mobilePHN")) {
            	mobilePHN = Long.parseLong(attributes.getValue("value"));
            }
			if(qName.equals("homePHN")) {
            	homePHN = Long.parseLong(attributes.getValue("value"));
            }
        }
		
		@Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
			if(qName.equals("person")) {
            	Person p = new Person();
            	p.setFirstName(fName);
            	p.setSecondName(sName);
            	p.setThirdName(tName);
            	p.setCity(city);
            	p.setStreet(street);
            	p.setHouseNumber(houseN);
            	p.setMobilePhoneNumber(mobilePHN);
            	p.setHomePhoneNumber(homePHN);
            	personList.add(p);
            }
        }
	}
		
}
