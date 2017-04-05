package edu.neu.contentbasedrecommendation;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class ReducerPhase3 extends Reducer<ReducerKeyTuple, ReducerValueTuple, Text, Text> {

	double groupSize = 0; // length of each vector
	double dotProduct = 0; // sum of ratingProd
	double rating1Sum = 0; // sum of rating1
	double rating2Sum = 0; // sum of rating2
	double rating1NormSq = 0; // sum of rating1Squared
	double rating2NormSq = 0; // sum of rating2Squared
	double maxNumOfumRaters1 = 0; // max of numOfRaters1
	double maxNumOfumRaters2 = 0; // max of numOfRaters2

	public void reduce(ReducerKeyTuple key, Iterable<ReducerValueTuple> tuples, Context context)
			throws IOException, InterruptedException {
		for (ReducerValueTuple t : tuples) {
			dotProduct += t.getRatingProduct();
			rating1Sum += t.getRes1Rating();
			rating2Sum += t.getRes2Rating();
			rating1NormSq += t.getRating1Squared();
			rating2NormSq += t.getRating2Squared();
			if (t.getRes1NumOfRaters() > maxNumOfumRaters1)
				maxNumOfumRaters1 = t.getRes1NumOfRaters();
			if (t.getRes2NumOfRaters() > maxNumOfumRaters2)
				maxNumOfumRaters2 = t.getRes2NumOfRaters();
			groupSize++;
		}

		CorrelationValueTuple cVT = new CorrelationValueTuple();
		double pearson = calculatePearsonCorrelation(groupSize, dotProduct, rating1Sum, rating2Sum, rating1NormSq,
				rating2NormSq);
		double cosine = calculateCosineCorrelation(dotProduct, Math.sqrt(rating1NormSq), Math.sqrt(rating2NormSq));
		double jaccard = calculateJaccardCorrelation(groupSize, maxNumOfumRaters1, maxNumOfumRaters2);
		cVT.setPearson(pearson);
		cVT.setCosine(cosine);
		cVT.setJaccard(jaccard);
		context.write(new Text(key.getRestaurant1().toString() + key.getRestaurant2().toString()),
				new Text(cVT.toString()));
	}

	public double calculatePearsonCorrelation(double size, double dotProduct, double rating1Sum, double rating2Sum,
			double rating1NormSq, double rating2NormSq) {
		double numerator = size * dotProduct - rating1Sum * rating2Sum;
		double denominator = Math.sqrt(size * rating1NormSq - rating1Sum * rating1Sum)
				* Math.sqrt(size * rating2NormSq - rating2Sum * rating2Sum);
		return numerator / denominator;
	}

	public double calculateCosineCorrelation(double dotProduct, double rating1Norm, double rating2Norm) {
		return dotProduct / (rating1Norm * rating2Norm);
	}

	public double calculateJaccardCorrelation(double inCommon, double totalA, double totalB) {
		double union = totalA + totalB - inCommon;
		return inCommon / union;
	}

}