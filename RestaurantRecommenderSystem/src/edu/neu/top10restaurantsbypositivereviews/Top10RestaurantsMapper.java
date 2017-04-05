package edu.neu.top10restaurantsbypositivereviews;

import java.io.IOException;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class Top10RestaurantsMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

	private TreeMap<Integer, NameNegativeReviewTuple> map = new TreeMap<>();
	
	public void map(LongWritable key, Text value, Context context) {
		int positiveCount = 0;
		NameNegativeReviewTuple tuple = new NameNegativeReviewTuple();
		String[] input = value.toString().split("\t");
		tuple.setRestaurantName(input[0].replaceAll("\"", ""));
		positiveCount = Integer.parseInt(input[1]);
		tuple.setNegativeCount(Integer.parseInt(input[2]));
		if (map.containsKey(positiveCount)) {
			NameNegativeReviewTuple t = map.get(positiveCount);
			if (t.getNegativeCount() > tuple.getNegativeCount())
				map.put(positiveCount, tuple);
		} else{
			map.put(positiveCount, tuple);
		}
		if (map.size() > 10)
			map.remove(map.firstKey());
	}

	@Override
	protected void cleanup(Context context) throws IOException, InterruptedException {
		for (Entry<Integer, NameNegativeReviewTuple> entry : map.descendingMap().entrySet()) {
			context.write(new Text(entry.getValue().getRestaurantName().toString()), new IntWritable(entry.getKey()));
		}
	}

}