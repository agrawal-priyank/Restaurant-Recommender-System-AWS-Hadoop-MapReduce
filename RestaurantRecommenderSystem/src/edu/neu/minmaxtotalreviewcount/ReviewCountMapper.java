package edu.neu.minmaxtotalreviewcount;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class ReviewCountMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

	private IntWritable reviewCount = new IntWritable();
	int count = 0;

	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
		if (value.toString().contains("user_id")) {
			// do nothing
		} else {
			String[] input = value.toString().split(",");
			reviewCount.set(Integer.parseInt(input[3]));
			context.write(new Text("Review Count"), reviewCount);
		}
	}

}