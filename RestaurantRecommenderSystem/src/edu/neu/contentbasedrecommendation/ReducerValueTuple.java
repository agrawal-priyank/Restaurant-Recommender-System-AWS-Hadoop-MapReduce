package edu.neu.contentbasedrecommendation;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.Writable;

public class ReducerValueTuple implements Writable {

	private double res1Rating;
	private double res2Rating;
	private int res1NumOfRaters;
	private int res2NumOfRaters;
	private double ratingProduct;
	private double rating1Squared;
	private double rating2Squared;

	public double getRes1Rating() {
		return res1Rating;
	}

	public void setRes1Rating(double res1Rating) {
		this.res1Rating = res1Rating;
	}

	public double getRes2Rating() {
		return res2Rating;
	}

	public void setRes2Rating(double res2Rating) {
		this.res2Rating = res2Rating;
	}

	public int getRes1NumOfRaters() {
		return res1NumOfRaters;
	}

	public void setRes1NumOfRaters(int res1NumOfRaters) {
		this.res1NumOfRaters = res1NumOfRaters;
	}

	public int getRes2NumOfRaters() {
		return res2NumOfRaters;
	}

	public void setRes2NumOfRaters(int res2NumOfRaters) {
		this.res2NumOfRaters = res2NumOfRaters;
	}

	public double getRatingProduct() {
		return ratingProduct;
	}

	public void setRatingProduct(double ratingProduct) {
		this.ratingProduct = ratingProduct;
	}

	public double getRating1Squared() {
		return rating1Squared;
	}

	public void setRating1Squared(double rating1Squared) {
		this.rating1Squared = rating1Squared;
	}

	public double getRating2Squared() {
		return rating2Squared;
	}

	public void setRating2Squared(double rating2Squared) {
		this.rating2Squared = rating2Squared;
	}

	@Override
	public void readFields(DataInput in) throws IOException {
		res1Rating = in.readDouble();
		res2Rating = in.readDouble();
		res1NumOfRaters = in.readInt();
		res2NumOfRaters = in.readInt();
		ratingProduct = in.readDouble();
		rating1Squared = in.readDouble();
		rating2Squared = in.readDouble();
	}

	@Override
	public void write(DataOutput out) throws IOException {
		out.writeDouble(res1Rating);
		out.writeDouble(res2Rating);
		out.writeInt(res1NumOfRaters);
		out.writeInt(res2NumOfRaters);
		out.writeDouble(ratingProduct);
		out.writeDouble(rating1Squared);
		out.writeDouble(rating2Squared);
	}

	public String toString() {
		return res1Rating + "\t" + res2Rating + "\t" + res1NumOfRaters + "\t" + res2NumOfRaters + "\t" + ratingProduct
				+ "\t" + rating1Squared + "\t" + rating2Squared;
	}

}