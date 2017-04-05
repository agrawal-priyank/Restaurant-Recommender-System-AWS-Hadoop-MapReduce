package edu.neu.simplemovingaverageratingofrestaurants;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.Writable;

public class TimeSeriesData implements Writable {

	private double rating;
	private String timestamp;

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public void readFields(DataInput in) throws IOException {
		rating = in.readDouble();
		timestamp = in.readUTF();
	}

	@Override
	public void write(DataOutput out) throws IOException {
		out.writeDouble(rating);
		out.writeUTF(timestamp);
	}
	
}