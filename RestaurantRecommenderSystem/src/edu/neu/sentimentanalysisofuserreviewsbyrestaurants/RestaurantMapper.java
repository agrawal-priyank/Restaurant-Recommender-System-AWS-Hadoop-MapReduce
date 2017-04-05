package edu.neu.sentimentanalysisofuserreviewsbyrestaurants;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class RestaurantMapper extends Mapper<LongWritable, Text, Text, Text> {

	private Text restaurantId = new Text();
	private Text restaurantName = new Text();

	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
		if (value.toString().contains("business_id")) {
			// do nothing
		} else {
			String[] input = value.toString().split(",");
			restaurantId.set(input[1]);
			restaurantName.set("A"+" "+input[2]);
			context.write(new Text(restaurantId.toString().replace("\"", "")), restaurantName);
		}
	}

}