package edu.neu.restaurantsearchusingbloomfiltering;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import com.google.common.base.Charsets;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnel;
import com.google.common.hash.Sink;

public class RestaurantSearchMapper extends Mapper<LongWritable, Text, Text, NullWritable> {

	Funnel<City> p = new Funnel<City>() {
		public void funnel(City city, Sink into) {
			into.putString(city.cityName, Charsets.UTF_8);
		}
	};

	private BloomFilter<City> restaurants = BloomFilter.create(p, 500, 0.1);

	@Override
	protected void setup(Context context) {
		Configuration conf = context.getConfiguration();
		String c = conf.get("city");
		City city = new City(c);
		System.out.println(city);
		restaurants.put(city);
	}

	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
		if (value.toString().contains("business_id")) {
			// do nothings
		} else {
			String[] input = value.toString().split(",");
			City city = new City(input[5].replaceAll("\"", "").toLowerCase());
			if (restaurants.mightContain(city)) {
				context.write(value, NullWritable.get());
			}
		}
	}

}