package edu.neu.totalandaverageratingofrestaurantsbycountry;

import java.io.IOException;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class TotalAverageRatingRestaurantsReducer extends Reducer<Text, DoubleWritable, Text, Text> {

	private double totalSum = 0;
	private int totalCount = 0;
	private double average = 0;

	public void reduce(Text key, Iterable<DoubleWritable> values, Context context)
			throws IOException, InterruptedException {
		for (DoubleWritable value : values) {
			totalSum += value.get();
			totalCount++;
		}
		average = totalSum / totalCount;
		context.write(new Text("Total Restaurants: "+totalCount), new Text("Average Rating: "+average));
	}

}