package edu.neu.simplemovingaverageratingofrestaurants;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class SimpleMovingAverageMapper extends Mapper<LongWritable, Text, CompositeKey, TimeSeriesData> {

	private CompositeKey cK = new CompositeKey();
	private TimeSeriesData tSD = new TimeSeriesData();

	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
		if (value.toString().contains("review_id")) {
			// do nothing
		} else {
			String[] input = value.toString().split(",");
			tSD.setRating(Double.parseDouble(input[4]));
			tSD.setTimestamp(input[3].replaceAll("\"", ""));
			String str = input[3].replace("\"", "");
			String[] date = str.toString().split("-");
			cK.setRestaurantId(input[2].replaceAll("\"", ""));
			cK.setTimestamp(Long.parseLong(date[0] + date[1] + date[2]));
			context.write(cK, tSD);
		}
	}

}