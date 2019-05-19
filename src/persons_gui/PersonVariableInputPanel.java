package persons_gui;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JCheckBox;

public class PersonVariableInputPanel extends PersonInputPanel{
	public static final int FIRST_NAME_SELECTED = 0;
	public static final int SECOND_NAME_SELECTED = 1;
	public static final int THIRD_NAME_SELECTED = 2;
	public static final int CITY_SELECTED = 3;
	public static final int STREET_SELECTED = 4;
	public static final int HOUSE_NUMBER_SELECTED = 5;
	public static final int MOBILE_PHONE_NUMBER_SELECTED = 6;
	public static final int HOME_PHONE_NUMBER_SELECTED = 7;
	
	protected JCheckBox[] checkBoxes;
	
	public PersonVariableInputPanel() {
		super();
		checkBoxes = new JCheckBox[8];
		for(JCheckBox ch:checkBoxes) {
			ch = new JCheckBox();
		}
	}
	
	@Override
	protected void addComponents() {
		panel.setLayout( new GridLayout(4,6));
		for(int i = 0; i < 8; i++) {
			panel.add(checkBoxes[i]);
			panel.add( new JLabel(labelNames[i]));
			panel.add(personFields[i]);
		}	
		panel.setSize(700, 200);
	}
	
	public ArrayList<Integer> getVariableParametres() {
		ArrayList<Integer> params = new ArrayList<Integer>();
		if(checkBoxes[0].isSelected())
			params.add(SECOND_NAME_SELECTED);
		if(checkBoxes[1].isSelected())
			params.add(CITY_SELECTED);
		if(checkBoxes[2].isSelected())
			params.add(FIRST_NAME_SELECTED);
		if(checkBoxes[3].isSelected())
			params.add(STREET_SELECTED);
		if(checkBoxes[4].isSelected())
			params.add(THIRD_NAME_SELECTED);
		if(checkBoxes[5].isSelected())
			params.add(HOUSE_NUMBER_SELECTED);
		if(checkBoxes[6].isSelected())
			params.add(MOBILE_PHONE_NUMBER_SELECTED);
		if(checkBoxes[7].isSelected())
			params.add(HOME_PHONE_NUMBER_SELECTED);
		
		return params;
	}
	
	
}
