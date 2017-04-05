package edu.neu.sentimentanalysisofuserreviewsbyrestaurants;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class RestaurantSentimentAnalysisReducer extends Reducer<Text, Text, Text, Text> {

	public void reduce(Text restaurantId, Iterable<Text> values, Context context)
			throws IOException, InterruptedException {
		String restaurantName = "";
		int posCount = 0;
		int negCount = 0;
		for (Text value : values) {
			String[] val = value.toString().split(" ");
			if (val[0].equalsIgnoreCase("A"))
				restaurantName = val[1];
			if (value.toString().equalsIgnoreCase("Positive Review"))
				posCount++;
			if (value.toString().equalsIgnoreCase("Negative Review"))
				negCount++;
		}
		if (posCount > 0 || negCount > 0) {
			if (!restaurantName.isEmpty()) {
				context.write(new Text(restaurantName), new Text(posCount + "\t" + negCount));
			}
		}
	}

}