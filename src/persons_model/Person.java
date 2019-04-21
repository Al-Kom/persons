package persons_model;

public class Person {
	private String FIO;
	private String address;
	private long mobilePhoneNumber;
	private long homePhoneNumber;

	public Person() {
		FIO = "";
		address = "";
		mobilePhoneNumber = 0;
		homePhoneNumber = 0;
	}
	
	public Person(Person p) {
		if(p != null) {
			FIO = p.getFIO();
			address = p.getAddress();
			mobilePhoneNumber = p.getMobilePhoneNumber();
			homePhoneNumber = p.getHomePhoneNumber();
		} else {
			FIO = "";
			address = "";
			mobilePhoneNumber = 0;
			homePhoneNumber = 0;
		}
	}

	public Person(String fio, String addr, long mobilePN, long homePN) {
		FIO = fio;
		address = addr;
		mobilePhoneNumber = mobilePN;
		homePhoneNumber = homePN;
	}

	public void setFIO(String fio) {
		FIO = fio;
	}
	
	public String getFIO() {
		return FIO;
	}

	public void setAddress(String addr) {
		address = addr;
	}
	
	public String getAddress() {
		return address;
	}

	public void setMobilePhoneNumber(long mobilePN) {
		mobilePhoneNumber = mobilePN;
	}
	
	public long getMobilePhoneNumber() {
		return mobilePhoneNumber;
	}

	public void setHomePhoneNumber(long homePN) {
		homePhoneNumber = homePN;
	}
	
	public long getHomePhoneNumber() {
		return homePhoneNumber;
	}
	
	public String toString() {
		String res = FIO + "|" + address + "|" + mobilePhoneNumber + 
				"|" + homePhoneNumber;
		return res;
	}
	
}
