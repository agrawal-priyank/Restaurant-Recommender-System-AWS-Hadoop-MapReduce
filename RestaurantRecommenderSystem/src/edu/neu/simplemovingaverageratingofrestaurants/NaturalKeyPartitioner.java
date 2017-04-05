package edu.neu.simplemovingaverageratingofrestaurants;

import org.apache.hadoop.mapreduce.Partitioner;

public class NaturalKeyPartitioner extends Partitioner<CompositeKey, TimeSeriesData> {

	@Override
	public int getPartition(CompositeKey key, TimeSeriesData value, int numberOfPartitions) {
		return (key.getRestaurantId().hashCode() % numberOfPartitions);
	}

}