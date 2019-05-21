package controllers;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import persons_model.PersonModel;

public class PersonsLoader {
	private ArrayList<PersonModel> loadedList;
	
	public PersonsLoader(PersonsBookController bookController, File file) {
		loadedList = new ArrayList<PersonModel>();
		
		try {
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser parser = factory.newSAXParser();
			
			parser.parse(file, new PersonXMLHandler());
		} catch (FileNotFoundException ex) {
			System.out.println("Ошибка! " + ex.getMessage());
		} catch (Exception ex) {
			System.out.println("Неизвестная ошибка! " + ex.getMessage());
			ex.printStackTrace();
		}
		
		bookController.addEntry(loadedList);
	}
	
	private class PersonXMLHandler extends DefaultHandler {
		String fName;
		String sName;
		String tName;
		String city;
		String street;
		String houseN;
		String mobilePHN;
		String homePHN;
		
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
				houseN = attributes.getValue("value");
            }
			if(qName.equals("mobilePHN")) {
            	mobilePHN = attributes.getValue("value");
            }
			if(qName.equals("homePHN")) {
            	homePHN = attributes.getValue("value");
            }
        }
		
		@Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
			if(qName.equals("person")) {
            	PersonModel p = new PersonModel(
            			fName,
            			sName,
            			tName,
            			city,
            			street,
            			houseN,
            			mobilePHN,
            			homePHN);
            	loadedList.add(p);
            }
        }
	}
		
}
