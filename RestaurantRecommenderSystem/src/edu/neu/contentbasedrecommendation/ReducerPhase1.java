package edu.neu.contentbasedrecommendation;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class ReducerPhase1 extends Reducer<Text, UserRatingTuple, Text, Text> {

	public void reduce(Text restaurant, Iterable<UserRatingTuple> tuples, Context context)
			throws IOException, InterruptedException {
		int count = 0;
		HashMap<String, Double> map = new HashMap<>();
		for (UserRatingTuple tuple : tuples) {
			map.put(tuple.getUser().toString(), tuple.getRating());
			count++;
		}
		for (Entry<String, Double> entry : map.entrySet()) {
			RestaurantRatingRatersTuple tuple = new RestaurantRatingRatersTuple();
			tuple.setNumberOfRaters(count);
			tuple.setRestaurant(restaurant.toString());
			tuple.setRating(Double.parseDouble(entry.getValue().toString()));
			context.write(new Text(entry.getKey().toString()), new Text(tuple.toString()));
		}
	}

}