package edu.neu.averageratingandtotalrestaurantsbycuisine;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class RestaurantByCuisine {

	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
		Configuration conf = new Configuration();
		Job job = Job.getInstance(conf, "Total Restaurants by Cuisines and their Average Rating");
		job.setJarByClass(RestaurantByCuisine.class);
		job.setMapperClass(RestaurantByCuisineMapper.class);
		job.setReducerClass(RestaurantByCuisineReducer.class);
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(RatingCountTuple.class);
		job.setOutputKeyClass(IntWritable.class);
		job.setOutputValueClass(Text.class);
		FileInputFormat.addInputPath(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		System.exit(job.waitForCompletion(true) ? 0 : 1);
	}

}