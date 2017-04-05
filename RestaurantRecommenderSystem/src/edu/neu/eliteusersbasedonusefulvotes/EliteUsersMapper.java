package edu.neu.eliteusersbasedonusefulvotes;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class EliteUsersMapper extends Mapper<LongWritable, Text, IntWritable, Text> {

	private IntWritable usefulVotes = new IntWritable();
	private Text userId = new Text();
	
	public void map(LongWritable Key, Text value, Context context) throws IOException, InterruptedException {
		if (value.toString().contains("user_id")) {
			// do nothing
		} else {
			String[] input = value.toString().split(",");
			usefulVotes.set(Integer.parseInt(input[5]));
			userId.set(input[1]);
			context.write(usefulVotes, userId);
		}
	}

}