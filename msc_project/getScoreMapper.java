package msc_project;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Mapper.Context;

public class getScoreMapper extends Mapper<LongWritable, Text, Text, Text>{
	
	public void map(LongWritable key, Text value, Context context
            ) throws IOException, InterruptedException {
		
		String[] tokens=value.toString().split("\\t");
		
		String[] authors=tokens[0].split(", ");
		String score=tokens[1];
		
		for(String a:authors){
			context.write(new Text(a.replaceAll("\\s+", "")), new Text(score));
		}
		
	}
}
