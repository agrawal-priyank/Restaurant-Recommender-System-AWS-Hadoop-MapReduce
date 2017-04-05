package edu.neu.averageratingandtotalrestaurantsbycuisine;

import java.io.IOException;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class RestaurantByCuisineReducer extends Reducer<Text, RatingCountTuple, IntWritable, Text> {

	private TreeMap<Integer, Text> map = new TreeMap<>();
	
	public void reduce(Text cuisine, Iterable<RatingCountTuple> tuples, Context context)
			throws IOException, InterruptedException {
		double ratingSum = 0;
		int count = 0;
		for (RatingCountTuple tuple : tuples) {
			ratingSum += tuple.getRating();
			count += tuple.getCount();
		}
		double averageRating = ratingSum / count;
		map.put(Integer.valueOf(count), new Text(cuisine+" "+averageRating));
	}
	
	@Override
	protected void cleanup(Context context) throws IOException, InterruptedException{
		while(!map.isEmpty()){
			Entry<Integer, Text> entry = map.lastEntry();
			context.write(new IntWritable(entry.getKey()), entry.getValue());
			map.remove(entry.getKey());
		}
	}

}