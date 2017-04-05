package edu.neu.contentbasedrecommendation;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class MapperPhase3 extends Mapper<LongWritable, Text, ReducerKeyTuple, ReducerValueTuple> {

	private ReducerKeyTuple k = new ReducerKeyTuple();
	private ReducerValueTuple v = new ReducerValueTuple();
	
	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
		String[] input = value.toString().split("\t");
		k.setRestaurant1(new Text(input[0]));
		k.setRestaurant2(new Text(input[1]));
		v.setRes1Rating(Double.parseDouble(input[2]));
		v.setRes2Rating(Double.parseDouble(input[3]));
		v.setRes1NumOfRaters(Integer.parseInt(input[4]));
		v.setRes2NumOfRaters(Integer.parseInt(input[5]));
		v.setRatingProduct(Double.parseDouble(input[6]));
		v.setRating1Squared(Double.parseDouble(input[7]));
		v.setRating2Squared(Double.parseDouble(input[8]));
		context.write(k, v);
	}

}