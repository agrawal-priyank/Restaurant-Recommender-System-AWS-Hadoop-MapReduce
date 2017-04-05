package edu.neu.restaurantsearchusingbloomfiltering;

public class City {

	final String cityName;

	public City(String cityName) {
		this.cityName = cityName;
	}
	
	@Override
	public String toString(){
		return this.cityName;
	}

}