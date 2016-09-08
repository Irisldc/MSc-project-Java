package msc_project;

import java.io.IOException;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Mapper.Context;

public class itemRatingMapper extends Mapper<LongWritable, Text, Text, DoubleWritable>{
	
	public void map(LongWritable key, Text value, Context context
            ) throws IOException, InterruptedException {
		
		String[] tokens=value.toString().split(",");
		
		String item=tokens[0];
		
		double rating=Double.parseDouble(tokens[1]);
		
		context.write(new Text(item), new DoubleWritable(rating));
		
	}

}
