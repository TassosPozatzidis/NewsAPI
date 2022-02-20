package model;

import NewsAPI.Location;

public class IpCountry {
	private String Country;

	public IpCountry(String country) {
		super();
		Country = country;
	}
	
	public IpCountry(Location theResult) {
		super();
		this.Country=theResult.getCountry();
	}
	
	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}

	public String toString() {
		return 
				"country='"+ Country +"'\n";
	}

}
