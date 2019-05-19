package persons_gui;

import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import persons_model.Person;

public class PersonInputPanel {
	protected JPanel panel;
	protected JTextField[] personFields;
	protected final String[] labelNames = {
			"Фамилия","Город","Имя","Улица",
			"Отчество","Дом","Моб. тел.","Дом. тел."
	}; 
	
	public PersonInputPanel() {
		panel = new JPanel();
		personFields = new JTextField[8];
		for(JTextField tf:personFields) {
			tf = new JTextField();
		}
	}
	
	public JPanel getPanel() {
		addComponents();
		return panel;
	}
	
	protected void addComponents() {
		panel.setLayout( new GridLayout(4,4));
		for(int i = 0; i < 8; i++) {
			panel.add( new JLabel(labelNames[i]));
			panel.add(personFields[i]);
		}
		panel.setSize(700, 200);
	}

	public Person getPerson() {
		Person person = new Person(
				getFirstName(),
				getSecondName(),
				getThirdName(),
				getCity(),			
				getStreet(),
				getHouseN(),
				getMobilePHN(),
				getHomePHN());
		return person;
	}
	
	protected String getFirstName() {
		return personFields[0].getText();
	}
	
	protected String getSecondName() {
		return personFields[1].getText();
	}
	
	protected String getThirdName() {
		return personFields[2].getText();
	}
	
	protected String getMobilePHN() {
		return personFields[3].getText();
	}
	
	protected String getCity() {
		return personFields[4].getText();
	}
	
	protected String getStreet() {
		return personFields[5].getText();
	}
	
	protected String getHouseN() {
		return personFields[6].getText();
	}
	
	protected String getHomePHN() {
		return personFields[7].getText();
	}
	
	
}
