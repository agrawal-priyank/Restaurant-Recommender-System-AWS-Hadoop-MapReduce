package edu.neu.contentbasedrecommendation;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class ContentBasedRecommender {

	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
		Configuration conf = new Configuration();
/*		Job job = Job.getInstance(conf, "Recommeding Restaurants Phase 1");
		job.setJarByClass(ContentBasedRecommender.class);
		job.setMapperClass(MapperPhase1.class);
		job.setReducerClass(ReducerPhase1.class);
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(UserRatingTuple.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(Text.class);
		FileInputFormat.addInputPath(job, new Path(args[0]));
		Path p1 = new Path(args[1] + "/phase1");
		FileOutputFormat.setOutputPath(job, p1);
		job.waitForCompletion(true);

		Job job2 = Job.getInstance(conf, "Recommeding Restaurants Phase 1");
		job2.setJarByClass(ContentBasedRecommender.class);
		job2.setMapperClass(MapperPhase2.class);
		job2.setReducerClass(ReducerPhase2.class);
		job2.setMapOutputKeyClass(Text.class);
		job2.setMapOutputValueClass(RestaurantRatingRatersTuple.class);
		job2.setOutputKeyClass(Text.class);
		job2.setOutputValueClass(Text.class);
		Path path2 = new Path(p1 + "/part-r-00000");
		FileInputFormat.addInputPath(job2, path2);
		Path p2 = new Path(args[1] + "/phase2");
		FileOutputFormat.setOutputPath(job2, p2);
		job2.waitForCompletion(true);
*/
		Job job3 = Job.getInstance(conf, "Recommeding Restaurants Phase 1");
		job3.setJarByClass(ContentBasedRecommender.class);
		job3.setMapperClass(MapperPhase3.class);
		job3.setReducerClass(ReducerPhase3.class);
		job3.setMapOutputKeyClass(ReducerKeyTuple.class);
		job3.setMapOutputValueClass(ReducerValueTuple.class);
		job3.setOutputKeyClass(Text.class);
		job3.setOutputValueClass(Text.class);
		//Path path3 = new Path(p2 + "/part-r-00000");
		Path path3 = new Path(args[0]);
		FileInputFormat.addInputPath(job3, path3);
		Path p3 = new Path(args[1] + "/phase3");
		FileOutputFormat.setOutputPath(job3, p3);
		System.exit(job3.waitForCompletion(true) ? 0 : 1);
	}

}