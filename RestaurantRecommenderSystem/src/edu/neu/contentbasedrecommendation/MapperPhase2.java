package edu.neu.contentbasedrecommendation;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class MapperPhase2 extends Mapper<LongWritable, Text, Text, RestaurantRatingRatersTuple>{
	
	private Text userId = new Text();
	private RestaurantRatingRatersTuple tuple = new RestaurantRatingRatersTuple();
	
	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException{
		String[] input = value.toString().split("\t");
		userId.set(input[0]);
		tuple.setRestaurant(input[1]);
		tuple.setRating(Double.parseDouble(input[2]));
		tuple.setNumberOfRaters(Integer.parseInt(input[3]));
		context.write(userId, tuple);
	}

}