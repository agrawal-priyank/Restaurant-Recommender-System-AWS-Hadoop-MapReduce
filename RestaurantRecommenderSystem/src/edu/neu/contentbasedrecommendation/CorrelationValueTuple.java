package edu.neu.contentbasedrecommendation;

public class CorrelationValueTuple {

	private double pearson;
	private double cosine;
	private double jaccard;

	public double getPearson() {
		return pearson;
	}

	public void setPearson(double pearson) {
		this.pearson = pearson;
	}

	public double getCosine() {
		return cosine;
	}

	public void setCosine(double cosine) {
		this.cosine = cosine;
	}

	public double getJaccard() {
		return jaccard;
	}

	public void setJaccard(double jaccard) {
		this.jaccard = jaccard;
	}

	@Override
	public String toString() {
		return "Pearson: " + pearson + " Cosine: " + cosine + " Jaccard: " + jaccard;
	}

}