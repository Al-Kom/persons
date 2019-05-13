package persons_gui;

import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PersonInputPanel extends JPanel {

	private JTextField firstNameField;
	private JTextField secondNameField;
	private JTextField thirdNameField;
	private JTextField mobilePHNField;
	private JTextField cityField;
	private JTextField streetField;
	private JTextField houseNField;
	private JTextField homePHNField;
	
	public PersonInputPanel() {

		JPanel FIOPanel = new JPanel();
			JLabel firstNameLabel = new JLabel("Имя");
			JLabel secondNameLabel = new JLabel("Фамилия");
			JLabel thirdNameLabel = new JLabel("Отчество");
			JLabel mobilePHNLabel = new JLabel("Моб. тел.");
			firstNameField = new JTextField();
			secondNameField = new JTextField();
			thirdNameField = new JTextField();
			mobilePHNField = new JTextField();
		JPanel addressDataPanel = new JPanel();
			JLabel cityLabel = new JLabel("Город");
			JLabel streetLabel = new JLabel("Улица");
			JLabel houseNLabel = new JLabel("Дом");
			JLabel homePHNLabel = new JLabel("Дом. тел.");
			streetField = new JTextField();
			cityField = new JTextField();
			houseNField = new JTextField();
			homePHNField = new JTextField();
			
		this.setLayout( new BoxLayout(this, BoxLayout.X_AXIS));
		this.add(FIOPanel);
			FIOPanel.setLayout(new GridLayout(4,2));
			FIOPanel.add(secondNameLabel);
			FIOPanel.add(secondNameField);
			FIOPanel.add(firstNameLabel);
			FIOPanel.add(firstNameField);
			FIOPanel.add(thirdNameLabel);
			FIOPanel.add(thirdNameField);
			FIOPanel.add(mobilePHNLabel);
			FIOPanel.add(mobilePHNField);
		this.add(addressDataPanel);
			addressDataPanel.setLayout( new GridLayout(4,2));
			addressDataPanel.add(cityLabel);
			addressDataPanel.add(cityField);
			addressDataPanel.add(streetLabel);
			addressDataPanel.add(streetField);
			addressDataPanel.add(houseNLabel);
			addressDataPanel.add(houseNField);
			addressDataPanel.add(homePHNLabel);
			addressDataPanel.add(homePHNField);
	}
	
	public String getFirstName() {
		return firstNameField.getText();
	}
	
	public String getSecondName() {
		return secondNameField.getText();
	}
	
	public String getThirdName() {
		return thirdNameField.getText();
	}
	
	public String getMobilePHN() {
		return mobilePHNField.getText();
	}
	
	public String getCity() {
		return cityField.getText();
	}
	
	public String getStreet() {
		return streetField.getText();
	}
	
	public String getHouseN() {
		return houseNField.getText();
	}
	
	public String getHomePHN() {
		return homePHNField.getText();
	}
	
	
}
