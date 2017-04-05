package edu.neu.sentimentanalysisofuserreviews;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.apache.hadoop.filecache.DistributedCache;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

@SuppressWarnings("deprecation")
public class SentimentAnalysisMapper extends Mapper<LongWritable, Text, Text, Text> {

	private Text reviewId = new Text();
	private Set<String> positiveWords = new HashSet<>();
	private Set<String> negativeWords = new HashSet<>();

	@Override
	protected void setup(Context context) throws IOException {
		Path[] lexiconFiles = DistributedCache.getLocalCacheFiles(context.getConfiguration());
		File posfile = new File(lexiconFiles[0].getName());
		File negfile = new File(lexiconFiles[1].getName());
		readFile(posfile, 0);
		readFile(negfile, 1);
	}

	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
		if (value.toString().contains("review_id")) {
			// do nothing
		} else {
			int posCount = 0;
			int negCount = 0;
			String[] input = value.toString().split(",");
			if (input.length == 7) {
				reviewId.set(input[1]);
				String review = input[3].toString().toLowerCase();
				String[] reviewTokens = review.split(" ");
				for (String token : reviewTokens) {
					if (positiveWords.contains(token))
						posCount++;
					if (negativeWords.contains(token))
						negCount++;
				}
				if (posCount >= negCount)
					context.write(reviewId, new Text("Positive Review"));
				else
					context.write(reviewId, new Text("Negative Review"));
			}
		}
	}

	private void readFile(File file, int count) throws IOException {
		BufferedReader bf = new BufferedReader(new FileReader(file.toString()));
		String word = null;
		while ((word = bf.readLine()) != null) {
			if (count == 0)
				positiveWords.add(word);
			else
				negativeWords.add(word);
		}
		bf.close();
	}

}