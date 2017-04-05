package edu.neu.simplemovingaverageratingofrestaurants;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class SimpleMovingAverageReducer extends Reducer<CompositeKey, TimeSeriesData, Text, Text> {

	int count = 0;

	public void reduce(CompositeKey key, Iterable<TimeSeriesData> values, Context context)
			throws IOException, InterruptedException {
		double sum = 0;
		int count = 0;
		double average = 0;
		for (TimeSeriesData value : values) {
			sum += value.getRating();
			count++;
			average = sum / count;
			context.write(new Text(key.getRestaurantId().toString()),
					new Text(value.getTimestamp() + "        " + String.format("%.2f", average)));
		}
	}

}