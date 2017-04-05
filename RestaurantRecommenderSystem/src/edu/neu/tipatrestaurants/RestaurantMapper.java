package edu.neu.tipatrestaurants;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class RestaurantMapper extends Mapper<LongWritable, Text, Text, Text> {

	private Text businessId = new Text();
	private Text info = new Text();

	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
		if (value.toString().contains("business_id")) {
			// do nothing
		} else {
			String[] input = value.toString().split(",");
			businessId.set(input[1].replaceAll("\"", ""));
			info.set(("A"+input[1] + "\t" + input[2] + "\t" + input[4] + "\t" + input[5] + "\t" + input[6]).replaceAll("\"", ""));
			context.write(businessId, info);
		}
	}

}