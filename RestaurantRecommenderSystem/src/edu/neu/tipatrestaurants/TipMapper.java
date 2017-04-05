package edu.neu.tipatrestaurants;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class TipMapper extends Mapper<LongWritable, Text, Text, Text> {

	private Text businessId = new Text();
	private Text info = new Text();

	public void map(LongWritable Key, Text value, Context context) throws IOException, InterruptedException {
		if (value.toString().contains("user_id")) {
			// do nothing
		} else {
			String[] input = value.toString().split("\",\"");
			if (input.length == 5) {
				businessId.set(input[3].replaceAll("\"", ""));
				info.set(new Text("B" + input[1] + "\t" + input[2]));
				context.write(businessId, info);
			}
		}
	}

}