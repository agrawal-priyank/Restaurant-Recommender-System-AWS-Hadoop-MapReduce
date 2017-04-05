package edu.neu.eliteusersbasedonusefulvotes;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class EliteUsersReducer extends Reducer<IntWritable, Text, Text, IntWritable> {

	public void reduce(IntWritable usefulVotes, Iterable<Text> userIds, Context context)
			throws IOException, InterruptedException {
		if (usefulVotes.get() > 10000) {
			for (Text userId : userIds)
				context.write(userId, usefulVotes);

		}
	}

}