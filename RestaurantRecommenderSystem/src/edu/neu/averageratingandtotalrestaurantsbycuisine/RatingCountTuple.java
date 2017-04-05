package edu.neu.averageratingandtotalrestaurantsbycuisine;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.Writable;

public class RatingCountTuple implements Writable {

	private int count = 0;
	private double rating = 0;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	@Override
	public void readFields(DataInput in) throws IOException {
		count = in.readInt();
		rating = in.readDouble();
	}

	@Override
	public void write(DataOutput out) throws IOException {
		out.writeInt(count);
		out.writeDouble(rating);
	}

	@Override
	public String toString() {
		return Integer.toString(count) + " " + Double.toString(rating);
	}

}