package edu.neu.restaurantsbystar;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.output.MultipleOutputs;

public class StarMapper extends Mapper<LongWritable, Text, Text, NullWritable> {

	private MultipleOutputs<Text, NullWritable> mos = null;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void setup(Context context) {
		mos = new MultipleOutputs(context);
	}

	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
		if (value.toString().contains("business_id")) {
			// do nothing
		} else {
			String[] input = value.toString().split(",");
			if (input[6].equals("5")) {
				mos.write("5", value.toString().replaceAll("\"", ""), NullWritable.get());
			} else if (input[6].equals("4.5") || input[6].equals("4")) {
				mos.write("4", value.toString().replaceAll("\"", ""), NullWritable.get());
			} else if (input[6].equals("3.5") || input[6].equals("3")) {
				mos.write("3", value.toString().replaceAll("\"", ""), NullWritable.get());
			} else if (input[6].equals("2.5") || input[6].equals("2")) {
				mos.write("2", value.toString().replaceAll("\"", ""), NullWritable.get());
			} else {
				mos.write("1", value.toString().replaceAll("\"", ""), NullWritable.get());
			}
		}
	}

	protected void cleanup(Context context) throws IOException, InterruptedException {
		mos.close();
	}

}