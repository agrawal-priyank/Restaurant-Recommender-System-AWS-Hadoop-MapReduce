package edu.neu.toprestaurantsbystate;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class TopRestaurantsMapper extends Mapper<LongWritable, Text, Text, Text> {

	private Text state = new Text();
	private Text restaurant = new Text();

	public void map(LongWritable Key, Text value, Context context) throws IOException, InterruptedException {
		if (value.toString().contains("business_id")) {
			// do nothing
		} else {
			String[] input = value.toString().split(",");
			if (input[6].equals("5")) {
				state.set(input[4].replaceAll("\"", ""));
				restaurant.set(input[2].replaceAll("\"", ""));
				context.write(state, restaurant);
			}
		}
	}

}