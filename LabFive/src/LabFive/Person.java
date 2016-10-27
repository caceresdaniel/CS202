package LabFive;

public class Person {

	protected String personsName;
	protected Address personsAddress;

	public Person() {
	}

	public Person(String personsNameIn, Address personsAddressIn) {

		personsName = personsNameIn;
		personsAddress = personsAddressIn;

	}

	public String getPersonsName() {
		return personsName;
	}

	public void setPersonsName(String personsName) {
		this.personsName = personsName;
	}

	public Address getPersonsAddress() {
		return personsAddress;
	}

	public void setPersonsAddress(Address personsAddress) {
		this.personsAddress = personsAddress;
	}

	public String toString() {
		return personsName;
	}

}
