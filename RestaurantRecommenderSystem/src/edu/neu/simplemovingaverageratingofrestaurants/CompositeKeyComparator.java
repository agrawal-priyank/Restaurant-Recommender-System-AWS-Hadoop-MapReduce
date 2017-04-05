package edu.neu.simplemovingaverageratingofrestaurants;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class CompositeKeyComparator extends WritableComparator {

	protected CompositeKeyComparator() {
		super(CompositeKey.class, true);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public int compare(WritableComparable w1, WritableComparable w2) {
		CompositeKey key1 = (CompositeKey) w1;
		CompositeKey key2 = (CompositeKey) w2;
		int comparison = key1.getRestaurantId().compareTo(key2.getRestaurantId());
		if (comparison == 0) {
			if (key1.getTimestamp() == key2.getTimestamp())
				return 0;
			if (key1.getTimestamp() < key2.getTimestamp())
				return -1;
			else
				return 1;
		} else {
			return comparison;
		}
	}

}