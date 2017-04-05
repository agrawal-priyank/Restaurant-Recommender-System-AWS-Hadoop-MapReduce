package edu.neu.eliteusersbasedonusefulvotes;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class SortKeyComparator extends WritableComparator {

	protected SortKeyComparator() {
		super(IntWritable.class, true);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public int compare(WritableComparable a, WritableComparable b) {
		IntWritable key1 = (IntWritable) a;
		IntWritable key2 = (IntWritable) b;
		return -1 * key1.compareTo(key2);
	}

}