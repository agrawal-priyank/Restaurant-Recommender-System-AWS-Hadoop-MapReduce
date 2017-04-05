package edu.neu.contentbasedrecommendation;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class ReducerPhase2 extends Reducer<Text, RestaurantRatingRatersTuple, Text, Text> {

	private ReducerKeyTuple rKT = new ReducerKeyTuple();
	private ReducerValueTuple rVT = new ReducerValueTuple();
	double ratingProduct = 0;
	double rating1Squared = 0;
	double rating2Squared = 0;

	public void reduce(Text key, Iterable<RestaurantRatingRatersTuple> tuples, Context context) throws IOException, InterruptedException {
		ArrayList<RestaurantRatingRatersTuple> list = new ArrayList<>();
		for (RestaurantRatingRatersTuple t : tuples) {
			list.add(t);
		}
		for (int i = 0; i < list.size() - 1; i++) {
			for (int j = i + 1; j < list.size(); j++) {
				rKT.setRestaurant1(new Text(list.get(i).getRestaurant()));
				rKT.setRestaurant2(new Text(list.get(j).getRestaurant()));
				ratingProduct = list.get(i).getRating() * list.get(j).getRating();
				rating1Squared = list.get(i).getRating() * list.get(i).getRating();
				rating2Squared = list.get(j).getRating() * list.get(j).getRating();
				rVT.setRatingProduct(ratingProduct);
				rVT.setRating1Squared(rating1Squared);
				rVT.setRating2Squared(rating2Squared);
				rVT.setRes1NumOfRaters(list.get(i).getNumberOfRaters());
				rVT.setRes1Rating(list.get(i).getRating());
				rVT.setRes2NumOfRaters(list.get(j).getNumberOfRaters());
				rVT.setRes2Rating(list.get(j).getRating());
				context.write(new Text(rKT.toString()), new Text(rVT.toString()));
			}
		}
	}

}