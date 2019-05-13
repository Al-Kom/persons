package persons_model;

public class Person {
	private String firstName;
	private String secondName;
	private String thirdName;
	private String city;
	private String street;
	private int houseNumber;
	private long mobilePhoneNumber;
	private long homePhoneNumber;

	public Person() {
		setFirstName("");
		setSecondName("");
		setThirdName("");
		setCity("");
		setStreet("");
		setHouseNumber(0);
		setMobilePhoneNumber(0);
		setHomePhoneNumber(0);
	}
	
	public Person(Person p) {
		if(p != null) {
			firstName = p.getFirstName();
			secondName = p.getSecondName();
			thirdName = p.getThirdName();
			city = p.getCity();
			street = p.getStreet();
			mobilePhoneNumber = p.getMobilePhoneNumber();
			homePhoneNumber = p.getHomePhoneNumber();
		} else {
			setFirstName("");
			setSecondName("");
			setThirdName("");
			setStreet("");
			setCity("");
			setMobilePhoneNumber(0);
			setHomePhoneNumber(0);
		}
	}

	public Person(String firstN, String secondN, String thirdN, String city, String street, 
			int houseN, long mobilePHN, long homePHN) {
		setFirstName(firstN);
		setSecondName(secondN);
		setThirdName(thirdN);
		setCity(city);
		setStreet(street);
		setHouseNumber(houseN);
		setMobilePhoneNumber(mobilePHN);
		setHomePhoneNumber(homePHN);
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstN) {
		firstName = firstN;
	}
	
	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public String getThirdName() {
		return thirdName;
	}

	public void setThirdName(String thirdName) {
		this.thirdName = thirdName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setStreet(String street) {
		this.street = street;
	}
	
	public String getStreet() {
		return street;
	}

	public int getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(int houseNumber) {
		this.houseNumber = houseNumber;
	}

	public void setHouseNumber(String sHouseNumber) {
		try {
			int houseN = 0;
			houseN = Integer.parseInt(sHouseNumber);
			setHouseNumber(houseN);
		} catch(NumberFormatException ex) {}
	}

	public void setMobilePhoneNumber(long mobilePHN) {
		mobilePhoneNumber = mobilePHN;
	}
	
	public void setMobilePhoneNumber(String mobilePHN) {
		try {
			long mphn = 0;
			mphn = Long.parseLong(mobilePHN);
			setMobilePhoneNumber(mphn);
		} catch(NumberFormatException ex) {}
	}
	
	public long getMobilePhoneNumber() {
		return mobilePhoneNumber;
	}

	public void setHomePhoneNumber(long homePHN) {
		homePhoneNumber = homePHN;
	}

	public void setHomePhoneNumber(String homePHN) {
		try {
			long hphn = 0;
			hphn = Long.parseLong(homePHN);
			setHomePhoneNumber(hphn);
		} catch(NumberFormatException ex) {}
	}
	
	public long getHomePhoneNumber() {
		return homePhoneNumber;
	}
	
	public String toString() {
		String res = getFIO() + "," + getAddress() + ","
				+ mobilePhoneNumber + "," + homePhoneNumber;
		return res;
	}	
	
	public String getFIO() {
		String res = secondName + " " + firstName + " " + thirdName;
		return res;
	}
	
	public String getAddress() {
		String res = city + "," + street + "," + houseNumber;
		return res;
	}
}
