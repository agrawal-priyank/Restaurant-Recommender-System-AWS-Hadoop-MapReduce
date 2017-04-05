package edu.neu.contentbasedrecommendation;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class MapperPhase1 extends Mapper<LongWritable, Text, Text, UserRatingTuple>{
	
	private Text businessId = new Text();
	private UserRatingTuple tuple = new UserRatingTuple();
	
	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException{
		if(value.toString().contains("business_id")){
			//do nothing
		}
		else{
			String[] input = value.toString().split(",");
			businessId.set(input[1]);
			tuple.setUser(input[2]);
			tuple.setRating(Double.parseDouble(input[3]));
			context.write(businessId, tuple);
		}
	}

}