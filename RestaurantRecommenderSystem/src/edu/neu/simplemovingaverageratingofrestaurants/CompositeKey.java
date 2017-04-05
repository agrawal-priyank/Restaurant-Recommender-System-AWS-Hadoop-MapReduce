package edu.neu.simplemovingaverageratingofrestaurants;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.Writable;
import org.apache.hadoop.io.WritableComparable;

public class CompositeKey implements Writable, WritableComparable<CompositeKey> {

	private String restaurantId;
	private long timestamp;

	public String getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(String restaurantId) {
		this.restaurantId = restaurantId;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public void readFields(DataInput in) throws IOException {
		restaurantId = in.readUTF();
		timestamp = in.readLong();
	}

	@Override
	public void write(DataOutput out) throws IOException {
		out.writeUTF(restaurantId);
		out.writeLong(timestamp);
	}

	@Override
	public int compareTo(CompositeKey key) {
		return restaurantId.compareTo(key.getRestaurantId());
	}
	
}