package edu.neu.totalrestaurantsbystate;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class RestaurantReducer extends Reducer<Text, IntWritable, Text, IntWritable> {

	@SuppressWarnings("unused")
	public void reduce(Text state, Iterable<IntWritable> values, Context context)
			throws IOException, InterruptedException {
		int count = 0;
		for (IntWritable value : values)
			count++;
		context.write(state, new IntWritable(count));
	}

}