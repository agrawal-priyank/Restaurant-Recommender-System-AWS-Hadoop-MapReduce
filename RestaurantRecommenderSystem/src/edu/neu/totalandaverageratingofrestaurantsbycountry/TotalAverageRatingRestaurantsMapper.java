package edu.neu.totalandaverageratingofrestaurantsbycountry;

import java.io.IOException;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class TotalAverageRatingRestaurantsMapper extends Mapper<LongWritable, Text, Text, DoubleWritable> {

	private DoubleWritable rating = new DoubleWritable();
	int count = 0;

	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
		if (value.toString().contains("business_id")) {
			// do nothing
		} else {
			String[] input = value.toString().split(",");
			System.out.println(count++);
			rating = new DoubleWritable(Double.parseDouble(input[6]));
			context.write(new Text("Restaurant"), rating);
		}
	}

}