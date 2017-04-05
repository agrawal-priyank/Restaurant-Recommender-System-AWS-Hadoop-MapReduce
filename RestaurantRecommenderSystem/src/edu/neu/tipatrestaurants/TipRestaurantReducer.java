package edu.neu.tipatrestaurants;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class TipRestaurantReducer extends Reducer<Text, Text, Text, Text> {

	private ArrayList<Text> listA = new ArrayList<Text>();
	private ArrayList<Text> listB = new ArrayList<Text>();

	public void reduce(Text businessId, Iterable<Text> values, Context context)
			throws IOException, InterruptedException {
		listA.clear();
		listB.clear();
		for (Text value : values) {
			String chr = value.toString().substring(0, 1);
			if (chr.equalsIgnoreCase("a"))
				listA.add(new Text(value.toString().substring(1)));
			else if (chr.equalsIgnoreCase("b"))
				listB.add(new Text(value.toString().substring(1)));
		}
		executeInnerJoinLogic(context);
	}

	private void executeInnerJoinLogic(Context context) throws IOException, InterruptedException {
		if (!listA.isEmpty() && !listB.isEmpty()) {
			for (Text A : listA) {
				for (Text B : listB)
					context.write(A, B);
			}
		}
	}

}