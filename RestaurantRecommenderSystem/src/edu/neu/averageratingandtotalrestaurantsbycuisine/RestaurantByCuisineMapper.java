package edu.neu.averageratingandtotalrestaurantsbycuisine;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class RestaurantByCuisineMapper extends Mapper<LongWritable, Text, Text, RatingCountTuple> {

	private RatingCountTuple tuple = new RatingCountTuple();

	private String[] cuisines = { "pizza", "burgers", "american", "mexican", "indian", "chinese", "japanese", "italian",
			"korean", "sushi" };

	public void map(LongWritable Key, Text value, Context context) throws IOException, InterruptedException {
		if (value.toString().contains("business_id")) {
			// do nothing
		} else {
			tuple.setCount(1);
			String[] input = value.toString().split(",");
			tuple.setRating(Double.parseDouble(input[6]));
			String str = input[3].replace("\"", "");
			String[] category = str.toString().split(" ");
			Set<String> set = new HashSet<String>();
			for (String cat : category) {
				set.add(cat.toLowerCase());				
			}
			for (String cuisine : cuisines) {
				if (set.contains(cuisine))
					context.write(new Text(cuisine), tuple);
			}
		}
	}

}