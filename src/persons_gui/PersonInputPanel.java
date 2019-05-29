package persons_gui;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import persons_model.PersonModel;

public class PersonInputPanel {
	private final int GRIDLAYOUT_ROW_NUMBER = 4;
	private final int GRIDLAYOUT_COLUMN_NUMBER = 4;
	protected final String[] personParametres = {
			"Фамилия","Город","Имя","Улица",
			"Отчество","Дом","Моб. тел.","Дом. тел."
	};
	protected JPanel panel;
	protected JTextField[] personFields;
	
	public PersonInputPanel() {
		panel = new JPanel();
		personFields = new JTextField[personParametres.length];
		for(int i = 0; i < personFields.length; i++) {
			personFields[i] = new JTextField();
		}
	}
	
	public JPanel getPanel() {
		addComponents();
		return panel;
	}
	
	protected void addComponents() {
		panel.setLayout(
				new GridLayout(GRIDLAYOUT_ROW_NUMBER,GRIDLAYOUT_COLUMN_NUMBER));
		for(int i = 0; i < personParametres.length; i++) {
			panel.add( new JLabel(personParametres[i]));
			panel.add(personFields[i]);
		}
		panel.setSize(500, 100);
	}

	public PersonModel getPerson() {
		PersonModel personModel = new PersonModel(
				getFirstName(),
				getSecondName(),
				getThirdName(),
				getCity(),			
				getStreet(),
				getHouseN(),
				getMobilePHN(),
				getHomePHN());
		return personModel;
	}
	
	protected String getSecondName() {
		return personFields[0].getText();
	}
	
	protected String getCity() {
		return personFields[1].getText();
	}
	
	protected String getFirstName() {
		return personFields[2].getText();
	}
	
	protected String getStreet() {
		return personFields[3].getText();
	}
	
	protected String getThirdName() {
		return personFields[4].getText();
	}
	
	protected String getHouseN() {
		return personFields[5].getText();
	}
	
	protected String getMobilePHN() {
		return personFields[6].getText();
	}
	
	protected String getHomePHN() {
		return personFields[7].getText();
	}
	
	
}
