package edu.neu.contentbasedrecommendation;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.Writable;

public class UserRatingTuple implements Writable {

	private String user;
	private double rating;

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	@Override
	public void readFields(DataInput in) throws IOException {
		user = in.readUTF();
		rating = in.readDouble();

	}

	@Override
	public void write(DataOutput out) throws IOException {
		out.writeUTF(user);
		out.writeDouble(rating);
	}
	
	@Override
	public String toString(){
		return user+"\t"+rating;
	}

}