package edu.neu.simplemovingaverageratingofrestaurants;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Text;

public class SimpleMovingAverage {

	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
		Configuration conf = new Configuration();
		Job job = Job.getInstance(conf, "Simple Moving Average of Rating of Restaurants");
		job.setJarByClass(SimpleMovingAverage.class);
		job.setMapperClass(SimpleMovingAverageMapper.class);
		job.setMapOutputKeyClass(CompositeKey.class);
		job.setMapOutputValueClass(TimeSeriesData.class);
		job.setPartitionerClass(NaturalKeyPartitioner.class);
		job.setSortComparatorClass(CompositeKeyComparator.class);
		job.setGroupingComparatorClass(NaturalKeyGroupingComparator.class);
		job.setReducerClass(SimpleMovingAverageReducer.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(Text.class);
		FileInputFormat.addInputPath(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		System.exit(job.waitForCompletion(true) ? 0 : 1);
	}

}