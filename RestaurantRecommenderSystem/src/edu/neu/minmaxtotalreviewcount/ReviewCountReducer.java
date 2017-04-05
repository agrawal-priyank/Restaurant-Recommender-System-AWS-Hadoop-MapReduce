package edu.neu.minmaxtotalreviewcount;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class ReviewCountReducer extends Reducer<Text, IntWritable, Text, IntWritable> {

	private int max = Integer.MIN_VALUE;
	private int min = Integer.MIN_VALUE;
	private int total = 0;

	public void reduce(Text key, Iterable<IntWritable> values, Context context) {
		for (IntWritable value : values) {
			total += value.get();
			if (max == Integer.MIN_VALUE && min == Integer.MIN_VALUE) {
				max = value.get();
				min = value.get();
			} else {
				if (value.get() >= max)
					max = value.get();
				else {
					if (value.get() <= min)
						min = value.get();
				}
			}
		}

	}

	@Override
	protected void cleanup(Context context) throws IOException, InterruptedException {
		context.write(new Text("Total Review Count of all Users"), new IntWritable(total));
		context.write(new Text("Maximum Review Count by a User"), new IntWritable(max));
		context.write(new Text("Minimum Review Count by a User"), new IntWritable(min));
	}

}