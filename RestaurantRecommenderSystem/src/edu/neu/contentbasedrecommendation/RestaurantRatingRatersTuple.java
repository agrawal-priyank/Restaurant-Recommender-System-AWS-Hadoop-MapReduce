package edu.neu.contentbasedrecommendation;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.Writable;

public class RestaurantRatingRatersTuple implements Writable {

	private String restaurant;
	private double rating;
	private int numberOfRaters;

	public String getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(String restaurant) {
		this.restaurant = restaurant;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public int getNumberOfRaters() {
		return numberOfRaters;
	}

	public void setNumberOfRaters(int numberOfRaters) {
		this.numberOfRaters = numberOfRaters;
	}

	@Override
	public void readFields(DataInput in) throws IOException {
		restaurant = in.readUTF();
		rating = in.readDouble();
		numberOfRaters = in.readInt();
	}

	@Override
	public void write(DataOutput out) throws IOException {
		out.writeUTF(restaurant);
		out.writeDouble(rating);
		out.writeInt(numberOfRaters);
	}

	@Override
	public String toString() {
		return restaurant + "\t" + rating + "\t" + numberOfRaters;
	}

}