package edu.neu.top10restaurantsbypositivereviews;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.Writable;

public class NameNegativeReviewTuple implements Writable {

	private String restaurantName;
	private int negativeCount;

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public int getNegativeCount() {
		return negativeCount;
	}

	public void setNegativeCount(int negativeCount) {
		this.negativeCount = negativeCount;
	}

	@Override
	public void readFields(DataInput in) throws IOException {
		restaurantName = in.readUTF();
		negativeCount = in.readInt();
	}

	@Override
	public void write(DataOutput out) throws IOException {
		out.writeUTF(restaurantName);
		out.writeInt(negativeCount);
	}

}