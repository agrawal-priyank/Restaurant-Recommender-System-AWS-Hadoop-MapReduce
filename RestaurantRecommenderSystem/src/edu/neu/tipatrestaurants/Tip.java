package edu.neu.tipatrestaurants;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.MultipleInputs;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class Tip {

	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
		Configuration conf = new Configuration();
		Job job = Job.getInstance(conf, "Inner Join of Restaurant and Tip Data Sources");
		job.setJarByClass(Tip.class);
		MultipleInputs.addInputPath(job, new Path(args[0]), TextInputFormat.class, RestaurantMapper.class);
		MultipleInputs.addInputPath(job, new Path(args[1]), TextInputFormat.class, TipMapper.class);
		job.setReducerClass(TipRestaurantReducer.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(Text.class);
		FileOutputFormat.setOutputPath(job, new Path(args[2]));
		System.exit(job.waitForCompletion(true) ? 0 : 1);
	}

}