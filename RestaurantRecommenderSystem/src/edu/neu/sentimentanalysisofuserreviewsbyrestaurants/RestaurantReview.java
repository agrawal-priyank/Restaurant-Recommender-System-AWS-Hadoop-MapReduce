package edu.neu.sentimentanalysisofuserreviewsbyrestaurants;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.MultipleInputs;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class RestaurantReview {

	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException, URISyntaxException {
		Configuration conf = new Configuration();
		Job job = Job.getInstance(conf, "Reviews of Restaurants based on Sentiment Analysis");
		job.setJarByClass(RestaurantReview.class);
		job.addCacheFile(new URI("/input/lexicon/positive-lexicon.txt"));
		job.addCacheFile(new URI("/input/lexicon/negative-lexicon.txt"));
		MultipleInputs.addInputPath(job, new Path(args[0]), TextInputFormat.class, RestaurantMapper.class);
		MultipleInputs.addInputPath(job, new Path(args[1]), TextInputFormat.class, SentimentAnalysisMapper.class);
		job.setReducerClass(RestaurantSentimentAnalysisReducer.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(Text.class);
		FileOutputFormat.setOutputPath(job, new Path(args[2]));
		System.exit(job.waitForCompletion(true) ? 0 : 1);
	}

}