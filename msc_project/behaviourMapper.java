package msc_project;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Mapper.Context;

public class behaviourMapper extends Mapper<LongWritable, Text, Text, Text>{
	
	public void map(LongWritable key, Text value, Context context
            ) throws IOException, InterruptedException {
		
		String[] tokens=value.toString().split("\\t");
		
		String author1=tokens[0];
		String author2=tokens[1];
		String weight=tokens[2];
		
//		String author=tokens[0];
//		String helpful_vote=tokens[3];
//		String feedbacks=tokens[4];
//		String item=tokens[1];
//		String date=tokens[2];
//		String rating=tokens[5];
//		String summary=tokens[6];
//		String body=tokens[7];		
		
		context.write(new Text(author1), new Text(author2+":"+weight));
	}

}
