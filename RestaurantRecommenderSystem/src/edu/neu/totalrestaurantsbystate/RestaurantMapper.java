package edu.neu.totalrestaurantsbystate;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class RestaurantMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

	private Text state = new Text();
	private IntWritable one = new IntWritable(1);

	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
		if (value.toString().contains("business_id")) {
			// do nothing
		} else {
			String[] input = value.toString().split(",");
			state.set(input[4].replaceAll("\"", ""));
			context.write(state, one);
		}
	}

}