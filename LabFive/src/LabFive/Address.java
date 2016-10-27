package LabFive;

public class Address {

	private long streetNumber;
	private String streetName;
	private String city;
	private String stateOrProvince;
	private String country;

	public Address() {

	}

	public Address(long streetNumberIn, String streetNameIn, String cityIn, String stateOrProvinceIn,
			String countryIn) {

		streetNumber = streetNumberIn;
		streetName = streetNameIn;
		city = cityIn;
		stateOrProvince = stateOrProvinceIn;
		country = countryIn;

	}

	public long getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(int streetNumber) {
		this.streetNumber = streetNumber;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStateOrProvince() {
		return stateOrProvince;
	}

	public void setStateOrProvince(String stateOrProvince) {
		this.stateOrProvince = stateOrProvince;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String toString() {
		return streetNumber + ", " + streetName + ", " + city + ", " + stateOrProvince + ", " + country;
	}
}
