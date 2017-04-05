package edu.neu.contentbasedrecommendation;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.io.WritableComparable;

public class ReducerKeyTuple implements Writable, WritableComparable<ReducerKeyTuple> {

	private Text restaurant1;
	private Text restaurant2;

	public Text getRestaurant1() {
		return restaurant1;
	}

	public void setRestaurant1(Text restaurant1) {
		this.restaurant1 = restaurant1;
	}

	public Text getRestaurant2() {
		return restaurant2;
	}

	public void setRestaurant2(Text restaurant2) {
		this.restaurant2 = restaurant2;
	}

	@Override
	public void readFields(DataInput in) throws IOException {
		restaurant1 = new Text(in.readUTF());
		restaurant2 = new Text(in.readUTF());
	}

	@Override
	public void write(DataOutput out) throws IOException {
		out.writeUTF(restaurant1.toString());
		out.writeUTF(restaurant2.toString());
	}

	@Override
	public String toString() {
		return restaurant1.toString() + "\t" + restaurant2.toString();
	}

	@Override
	public int compareTo(ReducerKeyTuple key) {
		return restaurant1.compareTo(key.getRestaurant1());
	}

}